package com.hcm.service;

import java.util.List;
import java.util.Map;

import com.hcm.dto.InsuranceDTO;

public interface InsuranceService {
	
	public InsuranceDTO save(InsuranceDTO insuranceDTO);
	public InsuranceDTO update(InsuranceDTO insuranceDTO, long iNo) throws Exception;
	public InsuranceDTO getById(long iNo) throws Exception;
	public List<InsuranceDTO> getAll();
	public Map<String, Boolean> delete(long iNo) throws Exception;

}
