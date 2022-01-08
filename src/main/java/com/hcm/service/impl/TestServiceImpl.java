package com.hcm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hcm.dto.TestDTO;
import com.hcm.model.Test;
import com.hcm.repository.TestRepository;
import com.hcm.service.TestService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class TestServiceImpl implements TestService {
	
	private final TestRepository repository;

	@Override
	public TestDTO save(TestDTO testDto) {
		Test test = convertDTOtoModel(testDto);
		repository.save(test);
		log.info(":::::::::::::::::::::::"+ test.getTid());
		return convertModelToDTO(test);
	}

	@Override
	public TestDTO update(TestDTO testDto, long tId) throws Exception {
		TestDTO copytest=getById(tId);
		copytest.setTDate(testDto.getTDate());
		copytest.setTName(testDto.getTName());
		copytest.setDoctor(testDto.getDoctor());
		Test test = convertDTOtoModel(copytest);
		repository.save(test);
		log.info("update::::::::::::::::::::: "+ test.getTid());
		return convertModelToDTO(test);
	}

	@Override
	public TestDTO getById(long tId) throws Exception {
		Test test = repository.findById(tId)
				.orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + tId));
		 return convertModelToDTO(test);
	}

	@Override
	public List<TestDTO> getAll() {
		List<Test> testList = repository.findAll();
		List<TestDTO> testDTOList = new ArrayList<>();
		
		for(Test test : testList) {
			testDTOList.add(convertModelToDTO(test));
		}
		return testDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long tId) throws Exception {
		Test test = convertDTOtoModel(getById(tId));
		repository.delete(test);
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Delete", Boolean.TRUE);
		
		return response;
	}
	
	private Test convertDTOtoModel(TestDTO testDTO) {
		Test test = new Test();
		test.setTid(testDTO.getTid());
		test.setTName(test.getTName());
		test.setDoctor(testDTO.getDoctor());
		test.setTDate(testDTO.getTDate());
		return test;
	}
	
	private TestDTO convertModelToDTO(Test test) {
		TestDTO dto = new TestDTO();
		dto.setTid(test.getTid());
		dto.setTName(test.getTName());
		dto.setDoctor(test.getDoctor());
		dto.setTDate(test.getTDate());
		return dto;
	}

}
