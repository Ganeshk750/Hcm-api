package com.hcm.service;

import java.util.List;
import java.util.Map;

import com.hcm.dto.PatientDTO;

public interface PatientService {
	
	public PatientDTO save(PatientDTO patientDTO);
	public PatientDTO update(PatientDTO patientDTO, long pId) throws Exception;
	public PatientDTO getById(long pId) throws Exception;
	public List<PatientDTO> getAll();
	public Map<String, Boolean> delete(long pId) throws Exception;
	public boolean existsByNumber(PatientDTO patientDTO);

}
