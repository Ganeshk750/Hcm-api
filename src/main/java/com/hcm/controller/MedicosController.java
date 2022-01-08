package com.hcm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcm.dto.MedicosDTO;
import com.hcm.service.MedicosService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class MedicosController {
	
	private final MedicosService medicosService;
	
	@PostMapping("/medicos")
	public ResponseEntity<MedicosDTO> addMedicos(@RequestBody MedicosDTO medicos) {
		
		MedicosDTO medDTO = medicosService.save(medicos);	
		return ResponseEntity.ok().body(medDTO);
	}
	
	public ResponseEntity<MedicosDTO> updateMedicos(@RequestBody MedicosDTO medicos, @PathVariable("id") long mId)
			throws Exception {

		MedicosDTO medDTO = medicosService.update(medicos, mId);
		return ResponseEntity.ok().body(medDTO);
	}

	@DeleteMapping(value = "/medicos/{id}")
	public Map<String, Boolean> deleteMedicos(@PathVariable long id) throws Exception {
		return medicosService.delete(id);
	}
	
	@GetMapping(value="/medicos/{id}")
	public ResponseEntity<MedicosDTO> findById(@PathVariable long id) throws Exception {
		
		MedicosDTO medDTO =  medicosService.getById(id);
		return ResponseEntity.ok().body(medDTO);
	}
	
	@GetMapping(value="/medicos")
	public ResponseEntity<List<MedicosDTO>> listAll()
	{
		List<MedicosDTO> medList =  medicosService.getAll();
		return ResponseEntity.ok().body(medList);
	}
	
	@GetMapping(value = "/medicos/pat/{id}")
	public ResponseEntity<List<MedicosDTO>> findByPatientId(@PathVariable long id) {
		List<MedicosDTO> list = medicosService.getAllByPatientId(id);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/medicos/total/{id}")
	public ResponseEntity<Long> getTotal(@PathVariable long id) {
		long total = medicosService.getTotal(id);
		
		return ResponseEntity.ok().body(total);
	}

}
