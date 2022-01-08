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

import com.hcm.dto.DepartmentDTO;
import com.hcm.service.DepartmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class DepartmentController {
	
	private final DepartmentService departmentService;
	
	@PostMapping("/department")
	public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentDTO dto){
		DepartmentDTO deptDto = departmentService.save(dto);
		return ResponseEntity.ok().body(deptDto);
	}
	
	@PutMapping("/departmet/{id}")
	public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody DepartmentDTO dto, 
			@PathVariable("id") long dId) throws Exception{
		DepartmentDTO departmentDto = departmentService.update(dto, dId);
		return ResponseEntity.ok().body(departmentDto);
	}
	
	@GetMapping("/department/{id}")
	public ResponseEntity<DepartmentDTO> findById(@PathVariable long id) throws Exception{
		DepartmentDTO dto = departmentService.getById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping("/department")
	public ResponseEntity<List<DepartmentDTO>> listAllDepartment(){
		List<DepartmentDTO> deptList = departmentService.getAll();
		return ResponseEntity.ok().body(deptList);
	}
	
	
	@DeleteMapping("/department/{id}")
	public Map<String, Boolean> deleteDepartment(@PathVariable long id) throws Exception{
		return departmentService.delete(id);
	}

}
