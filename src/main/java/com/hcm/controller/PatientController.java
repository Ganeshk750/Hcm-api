package com.hcm.controller;

import java.util.HashMap;
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

import com.hcm.dto.PatientDTO;
import com.hcm.service.PatientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class PatientController {
	
	private final PatientService patientService;
	
	@PostMapping(value="/patient")
	public ResponseEntity<PatientDTO> addPatient(@RequestBody PatientDTO patient) {
		
		PatientDTO patDTO = patientService.save(patient);	
		return ResponseEntity.ok().body(patDTO);
	}
	
	@PutMapping(value="/patient/{id}")
	public ResponseEntity<PatientDTO> updatePatient(@RequestBody PatientDTO patient,
								@PathVariable("id") long patId) throws Exception {
		
		PatientDTO patDTO = patientService.update(patient, patId);
		return ResponseEntity.ok().body(patDTO);
	}
	
	@DeleteMapping(value="/patient/{id}")
	public Map<String, Boolean> deletePatient(@PathVariable long id) throws Exception
	{
		return patientService.delete(id);
	}

	@GetMapping(value="/patient/{id}")
	public ResponseEntity<PatientDTO> findById(@PathVariable long id) throws Exception {
		
		PatientDTO patDTO =  patientService.getById(id);
		return ResponseEntity.ok().body(patDTO);
	}
	
	@GetMapping(value="/patient")
	public ResponseEntity<List<PatientDTO>> listAll()
	{
		List<PatientDTO> patDTOList =  patientService.getAll();
		return ResponseEntity.ok().body(patDTOList);
	}
	
	@PostMapping(value = "/patient/check")
	public ResponseEntity<Map<String, Boolean>> isExists(@RequestBody PatientDTO patient){
		Map<String, Boolean> res = new HashMap<>();
		if(patientService.existsByNumber(patient)) {
			res.put("available", Boolean.TRUE);
		}else {
			res.put("available", Boolean.FALSE);
		}
		
		return ResponseEntity.ok().body(res);
	}

}
