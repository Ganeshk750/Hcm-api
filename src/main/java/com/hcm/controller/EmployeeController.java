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

import com.hcm.dto.EmployeeDTO;
import com.hcm.repository.EmployeeRepository;
import com.hcm.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO dto){
		EmployeeDTO empDto = employeeService.save(dto);
		return ResponseEntity.ok().body(empDto);
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO dto,
			@PathVariable("id") long eId) throws Exception {
		EmployeeDTO emp = employeeService.update(dto, eId);
		return ResponseEntity.ok().body(emp);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeDTO> findById(@PathVariable long id) throws Exception {
		EmployeeDTO dto = employeeService.getById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value="/employee/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable long id) throws Exception{
		return employeeService.delete(id);
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
		List<EmployeeDTO> empList = employeeService.getAll();
		return ResponseEntity.ok().body(empList);
	}
	
	@PostMapping(value="/employee/check")
	public ResponseEntity<Map<String, Boolean>> isExists(@RequestBody EmployeeDTO empDTO){
		Map<String, Boolean> res = new HashMap<>();
		if(employeeService.isExists(empDTO)) {
			res.put("available", Boolean.TRUE);
		}else {
			res.put("available", Boolean.FALSE);
		}
		
		return ResponseEntity.ok().body(res);
	}

}
