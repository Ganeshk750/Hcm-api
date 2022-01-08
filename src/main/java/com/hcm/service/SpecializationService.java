package com.hcm.service;

import java.util.List;
import java.util.Map;

import com.hcm.dto.SpecializationDTO;

public interface SpecializationService {
	
	public SpecializationDTO save(SpecializationDTO specializationDTO);
	public SpecializationDTO update(SpecializationDTO specializationDTO,long specId) throws Exception;
	public SpecializationDTO getById(long specId) throws Exception;
	public List<SpecializationDTO> getAll();
	public Map<String, Boolean> delete(long specId) throws Exception;

}
