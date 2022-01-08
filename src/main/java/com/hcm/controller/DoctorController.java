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

import com.hcm.dto.DoctorDTO;
import com.hcm.service.DoctorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DoctorController {

	private final DoctorService doctorService;
	
	
	@PostMapping("/doctor")
	public ResponseEntity<DoctorDTO> addDoctor(@RequestBody DoctorDTO dto){
		DoctorDTO doctorDto = doctorService.save(dto);
		return ResponseEntity.ok().body(doctorDto);
	}
	
	@PutMapping("/doctor/{id}")
	public ResponseEntity<DoctorDTO> updateDoctor(@RequestBody DoctorDTO dto,
			@PathVariable("id") long dId) throws Exception {
		DoctorDTO doctorDto = doctorService.update(dto, dId);
		return ResponseEntity.ok().body(doctorDto);
	}
	
	@GetMapping("/doctor/{id}")
	public ResponseEntity<DoctorDTO> findById(@PathVariable long id) throws Exception {
		DoctorDTO dto = doctorService.getById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping("/doctor")
	public ResponseEntity<List<DoctorDTO>> listAllDoctor(){
		List<DoctorDTO> docList = doctorService.getAll();
		return ResponseEntity.ok().body(docList);
	}
	
	@DeleteMapping("/doctor/{id}")
	public Map<String, Boolean> deleteDoctor(@PathVariable long id) throws Exception{
		return doctorService.delete(id);
	}
	
	public ResponseEntity<Map<String, Boolean>> existsByContactNo(@RequestBody DoctorDTO dto){
		Map<String, Boolean> res = new HashMap<>();
		boolean present = doctorService.existsByNumber(dto);
		if(present) {
			res.put("available", Boolean.TRUE);
		}else {
			res.put("available", Boolean.FALSE);
		}
		return ResponseEntity.ok().body(res);
	}
	
}
