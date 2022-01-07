package com.hcm.service;

import java.util.List;
import java.util.Map;

import com.hcm.dto.OperationDTO;

public interface OperationService {
	
	public OperationDTO save(OperationDTO operationDTO);
	public OperationDTO update(OperationDTO operationDTO, long oId) throws Exception;
	public OperationDTO getById(long oId) throws Exception;
	public List<OperationDTO> getAll();
	public Map<String, Boolean> delete(long oId) throws Exception;

}
