package com.hcm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.Doc;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hcm.dto.DepartmentDTO;
import com.hcm.dto.DoctorDTO;
import com.hcm.model.Department;
import com.hcm.model.Doctor;
import com.hcm.repository.DoctorRepository;
import com.hcm.service.DoctorService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class DoctorServiceImpl implements DoctorService{
	
	private final DoctorRepository doctorRepository;

	@Override
	public DoctorDTO save(DoctorDTO doctor) {
		Doctor doc = convertDTOToModel(doctor);
		doctorRepository.save(doc);
		log.info(":::::::::::::::::::::::::::::::::: "+ doc.getDocId());
		return convertModelToDTO(doc);
	}

	@Override
	public DoctorDTO update(DoctorDTO doctor, long docId) throws Exception {
		Doctor doctorEntity = doctorRepository.getById(docId);
		
		doctorEntity.setDocId(doctor.getDoctorId());
		doctorEntity.setDept(doctor.getDepartment());
		doctorEntity.setDoctorAddress(doctor.getDoctorAddress());
		doctorEntity.setDoctorName(doctor.getDoctorName());
		doctorEntity.setPhoneNo(doctor.getDoctorPhoneNo());
		doctorEntity.setSpec(doctor.getSpecialization());
		
		DoctorDTO docDto = convertModelToDTO(doctorEntity);
		Doctor docSave = convertDTOToModel(docDto);
		Doctor save = doctorRepository.save(docSave);
		DoctorDTO dto = convertModelToDTO(save);
		log.info(":::::::::::::::::::::::: "+ dto.getDoctorId());
		return dto;
	}
	
	@Override
	public DoctorDTO getById(long doctorId) throws Exception{
		Doctor doctor = doctorRepository.findById(doctorId)
				.orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION ::::::::::: " + doctorId));
		return convertModelToDTO(doctor);
	}

	@Override
	public List<DoctorDTO> getAll() {
		List<Doctor> docList = doctorRepository.findAll();
		List<DoctorDTO> docDTOList = new ArrayList<>();
		
		for(Doctor doc : docList) {
			docDTOList.add(convertModelToDTO(doc));
		}
		return docDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long doctorId) throws Exception {
       Doctor doc = convertDTOToModel(getById(doctorId));
		
       doctorRepository.delete(doc);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Delete", Boolean.TRUE);
		
		return response;
	}

	@Override
	public boolean existsByNumber(DoctorDTO doctor) {
		Doctor doc = doctorRepository.findByPhoneNo(doctor.getDoctorPhoneNo());
		if(doc != null) {
			return true;
		}
		return false;
	}
	
	
	private Doctor convertDTOToModel(DoctorDTO doctorDTO) {
		Doctor doctor = new Doctor();
		doctor.setDocId(doctorDTO.getDoctorId());
		doctor.setDoctorName(doctorDTO.getDoctorName());
		doctor.setDoctorAddress(doctorDTO.getDoctorAddress());
		doctor.setPhoneNo(doctorDTO.getDoctorPhoneNo());
		doctor.setDept(doctorDTO.getDepartment());
		doctor.setSpec(doctorDTO.getSpecialization());
		return doctor;
	}
	
	private DoctorDTO convertModelToDTO(Doctor doctor) {
		DoctorDTO dto = new DoctorDTO();
		dto.setDoctorId(doctor.getDocId());
		dto.setDoctorName(doctor.getDoctorName());
		dto.setDepartment(doctor.getDept());
		dto.setDoctorAddress(doctor.getDoctorAddress());
		dto.setDoctorPhoneNo(doctor.getPhoneNo());
		dto.setSpecialization(doctor.getSpec());
		return dto;
	}

}
