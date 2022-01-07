package com.hcm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hcm.dto.PatientDTO;
import com.hcm.model.Patient;
import com.hcm.repository.PatientRepositoy;
import com.hcm.service.PatientService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PatientServiceImpl implements PatientService {
	
	private final PatientRepositoy patientRepositoy;

	@Override
	public PatientDTO save(PatientDTO patientDTO) {
		
		Patient patient = convertDTOToModel(patientDTO);
		patientRepositoy.save(patient);
		log.info(":::::::::::::::::::::::::::::: "+ patient.getPid());
		return convertModelToDTO(patient);
	}

	@Override
	public PatientDTO update(PatientDTO patientDTO, long pId) throws Exception {
		PatientDTO patientDto = getById(pId);
		
		patientDto.setPName(patientDTO.getPName());
		patientDto.setPAdd(patientDTO.getPAdd());
		patientDto.setPDob(patientDTO.getPDob());
		patientDto.setDoc(patientDTO.getDoc());
		patientDto.setPMobileNo(patientDTO.getPMobileNo());
		patientDto.setTest(patientDTO.getTest());
		
		Patient patient = convertDTOToModel(patientDto);
		patientRepositoy.save(patient);
		log.info("update:::::::::::::::::::::::::::: "+ patient.getPid());
		return convertModelToDTO(patient);
	}

	@Override
	public PatientDTO getById(long pId) throws Exception {
		Patient  patient = patientRepositoy.findById(pId)
				.orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + pId));
		return convertModelToDTO(patient);
	}

	@Override
	public List<PatientDTO> getAll() {
		List<Patient> patientList = patientRepositoy.findAll();
		List<PatientDTO> patientDTOList = new ArrayList<>();
		
		for(Patient patient : patientList) {
			patientDTOList.add(convertModelToDTO(patient));
		}
		
		return patientDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long pId) throws Exception {
		Patient patient = convertDTOToModel(getById(pId));
		patientRepositoy.delete(patient);
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Delete", Boolean.TRUE);
		log.info("Deleted:::::::::::::::::::::::::::: "+ pId);
		return response;
	}

	@Override
	public boolean existsByNumber(PatientDTO patientDTO) {
		Patient patient = patientRepositoy.findByPMobileNo(patientDTO.getPMobileNo());
		if(patient != null) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	private Patient convertDTOToModel(PatientDTO patientDTO) {
		Patient patient = new Patient();
		patient.setPid(patientDTO.getPid());
		patient.setPName(patientDTO.getPName());
		patient.setPDob(patientDTO.getPDob());
		patient.setPMobileNo(patientDTO.getPMobileNo());
		patient.setPAddress(patientDTO.getPAdd());
		patient.setDoc(patientDTO.getDoc());
		patient.setTest(patientDTO.getTest());
		return patient;
	}
	
	
	private PatientDTO convertModelToDTO(Patient patient) {
		PatientDTO dto = new PatientDTO();
		dto.setPid(patient.getPid());
		dto.setPName(patient.getPName());
		dto.setPDob(patient.getPDob());
		dto.setPMobileNo(patient.getPMobileNo());
		dto.setDoc(patient.getDoc());
		dto.setPAdd(patient.getPAddress());
		dto.setTest(patient.getTest());
		return dto;
	}

}
