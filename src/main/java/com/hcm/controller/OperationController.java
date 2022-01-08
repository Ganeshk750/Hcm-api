package com.hcm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcm.dto.OperationDTO;
import com.hcm.service.OperationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class OperationController {
	
	private final OperationService operationService;
	
	@PostMapping("/operation")
	public ResponseEntity<OperationDTO> addOperation(@RequestBody OperationDTO operation) {

		OperationDTO operDTO = operationService.save(operation);
		return ResponseEntity.ok().body(operDTO);
	}
	
	@PutMapping("/operation/{id}")
	public ResponseEntity<OperationDTO> updateOperation(@RequestBody OperationDTO operation,
			@PathVariable("id") long oId) throws Exception {

		OperationDTO operDTO = operationService.update(operation, oId);
		return ResponseEntity.ok().body(operDTO);
	}
	
	@DeleteMapping(value = "/operation/{id}")
	public Map<String, Boolean> deleteOperation(@PathVariable long id) throws Exception {
		return operationService.delete(id);
	}
	
	@GetMapping("/operation/{id}")
	public ResponseEntity<OperationDTO> findById(@PathVariable long id) throws Exception {

		OperationDTO operDTO = operationService.getById(id);
		return ResponseEntity.ok().body(operDTO);
	}

	@GetMapping(value = "/operation")
	public ResponseEntity<List<OperationDTO>> listAll() {
		List<OperationDTO> operDTO = operationService.getAll();
		return ResponseEntity.ok().body(operDTO);
	}

}
