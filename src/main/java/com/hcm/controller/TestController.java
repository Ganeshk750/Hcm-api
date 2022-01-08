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

import com.hcm.dto.TestDTO;
import com.hcm.service.TestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TestController {
	
	private final TestService testService;
	
	@PostMapping(value = "/test")
	public ResponseEntity<TestDTO> addTest(@RequestBody TestDTO test) {

		TestDTO testDTO = testService.save(test);
		return ResponseEntity.ok().body(testDTO);

	}

	@PutMapping(value = "/test/{id}")
	public ResponseEntity<TestDTO> updateTest(@RequestBody TestDTO test
			, @PathVariable("id") long tid) throws Exception {

		TestDTO testDTO = testService.update(test, tid);
		return ResponseEntity.ok().body(testDTO);
	}

	@DeleteMapping(value = "/test/{id}")
	public Map<String, Boolean> deleteTest(@PathVariable long id) throws Exception {
		return testService.delete(id);
	}

	@GetMapping(value = "/test/{id}")
	public ResponseEntity<TestDTO> findById(@PathVariable long id) throws Exception {

		TestDTO testDTO = testService.getById(id);
		return ResponseEntity.ok().body(testDTO);
	}

	@GetMapping(value = "/test")
	public ResponseEntity<List<TestDTO>> listAll() {
		List<TestDTO> testDTOList = testService.getAll();
		return ResponseEntity.ok().body(testDTOList);
	}

}
