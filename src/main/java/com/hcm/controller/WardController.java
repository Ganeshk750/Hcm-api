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

import com.hcm.dto.WardDTO;
import com.hcm.service.WardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class WardController {
	
	private final WardService wardService;
	
	@PostMapping(value="/ward")
	public ResponseEntity<WardDTO> addWard(@RequestBody WardDTO ward) {
		
		WardDTO wardDTO = wardService.save(ward);	
		return ResponseEntity.ok().body(wardDTO);
	}
	
	@PutMapping(value="/ward/{id}")
	public ResponseEntity<WardDTO> updateWard(@RequestBody WardDTO Ward,
								@PathVariable("id") long wid) throws Exception {
		
		WardDTO wardDTO = wardService.update(Ward, wid);
		return ResponseEntity.ok().body(wardDTO);
	}
	
	@DeleteMapping(value="/ward/{id}")
	public Map<String, Boolean> deleteWard(@PathVariable long id) throws Exception
	{
		return wardService.delete(id);
	}

	@GetMapping(value="/ward/{id}")
	public ResponseEntity<WardDTO> findById(@PathVariable long id) throws Exception {
		
		WardDTO wardDTO = wardService.getById(id);
		return ResponseEntity.ok().body(wardDTO);
	}
	
	@GetMapping(value="/ward")
	public ResponseEntity<List<WardDTO>> listAll()
	{
		List<WardDTO> wardDTOList = wardService.getAll();
		return ResponseEntity.ok().body(wardDTOList);
	}

}
