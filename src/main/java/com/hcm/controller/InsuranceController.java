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

import com.hcm.dto.InsuranceDTO;
import com.hcm.service.InsuranceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class InsuranceController {
	
	private final InsuranceService insuranceService;
	
	@PostMapping("/insurence")
	public ResponseEntity<InsuranceDTO> addInsurence(@RequestBody InsuranceDTO insurence){
		InsuranceDTO insurenceDto = insuranceService.save(insurence);
		return ResponseEntity.ok().body(insurenceDto);
	}
	
	@PutMapping("/insurence/{id}")
	public ResponseEntity<InsuranceDTO> updateInsurence(@RequestBody InsuranceDTO dto,
			@PathVariable("id") long iId) throws Exception {
		InsuranceDTO insurenceDto = insuranceService.update(dto, iId);
		return ResponseEntity.ok().body(insurenceDto);
	}
	
	
	@GetMapping(value="/insurance/{id}")
	public ResponseEntity<InsuranceDTO> findById(@PathVariable long id) throws Exception {
		
		InsuranceDTO insDTO =  insuranceService.getById(id);
		return ResponseEntity.ok().body(insDTO);
	}
	
	@GetMapping(value="/insurance")
	public ResponseEntity<List<InsuranceDTO>> listAll()
	{
		List<InsuranceDTO> insList =  insuranceService.getAll();
		return ResponseEntity.ok().body(insList);
	}

	@DeleteMapping(value="/insurance/{id}")
	public Map<String, Boolean> deleteInsurance(@PathVariable long id) throws Exception
	{
		return insuranceService.delete(id);
	}
}
