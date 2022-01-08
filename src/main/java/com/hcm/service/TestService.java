package com.hcm.service;

import java.util.List;
import java.util.Map;

import com.hcm.dto.TestDTO;

public interface TestService {
	
	public TestDTO save(TestDTO testDto);
	public TestDTO update(TestDTO testDto, long tId) throws Exception;
	public TestDTO getById(long tId) throws Exception;
	public List<TestDTO> getAll();
	public Map<String, Boolean> delete(long tId) throws Exception;

}
