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

import com.hcm.dto.SpecializationDTO;
import com.hcm.service.SpecializationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SpecializationController {
	
	private final SpecializationService specializationService;
	
	@PostMapping(value = "/spec")
	public ResponseEntity<SpecializationDTO> addSpecialization(@RequestBody SpecializationDTO specialization) {

		SpecializationDTO specDTO = specializationService.save(specialization);
		return ResponseEntity.ok().body(specDTO);
	}

	@PutMapping(value = "/spec/{id}")
	public ResponseEntity<SpecializationDTO> updateSpecialization(@RequestBody SpecializationDTO specialization,
			@PathVariable long id) throws Exception {

		SpecializationDTO specDTO = specializationService.update(specialization, id);
		return ResponseEntity.ok().body(specDTO);
	}

	@DeleteMapping(value = "/spec/{id}")
	public Map<String, Boolean> deleteSpecialization(@PathVariable long id) throws Exception {
		return specializationService.delete(id);
	}

	@GetMapping(value = "/spec/{id}")
	public ResponseEntity<SpecializationDTO> findById(@PathVariable long id) throws Exception {

		SpecializationDTO specDTO = specializationService.getById(id);
		return ResponseEntity.ok().body(specDTO);
	}

	@GetMapping(value = "/spec")
	public ResponseEntity<List<SpecializationDTO>> listAll() {
		List<SpecializationDTO> specDTO = specializationService.getAll();
		return ResponseEntity.ok().body(specDTO);
	}

}
