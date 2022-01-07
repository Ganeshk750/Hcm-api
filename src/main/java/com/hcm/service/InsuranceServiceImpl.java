package com.hcm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hcm.dto.InsuranceDTO;
import com.hcm.model.Insurance;
import com.hcm.repository.InsuranceRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class InsuranceServiceImpl implements InsuranceService {
	
	private final InsuranceRepository insuranceRepository;

	@Override
	public InsuranceDTO save(InsuranceDTO insuranceDTO) {
		Insurance insurence = convertDTOToModel(insuranceDTO);
		insuranceRepository.save(insurence);
		log.info(":::::::::::::::::::::::::::::::::: "+ insurence.getINo());
		return convertModelToDTO(insurence);
	}

	@Override
	public InsuranceDTO update(InsuranceDTO insuranceDTO, long iNo) throws Exception {
		InsuranceDTO insurenceDto = getById(iNo);
		insurenceDto.setIAmt(insuranceDTO.getIAmt());
		insurenceDto.setIExpiryDate(insuranceDTO.getIExpiryDate());
		insurenceDto.setPatient(insuranceDTO.getPatient());
		
		Insurance insurence = convertDTOToModel(insurenceDto);
		insuranceRepository.save(insurence);
		log.info("update :::::::::::::::::::::::::::::::::: "+ insurence.getINo());
		return convertModelToDTO(insurence);
	}

	@Override
	public InsuranceDTO getById(long iNo) throws Exception {
		Insurance ins =insuranceRepository.findById(iNo)
				.orElseThrow(() -> new Exception("ID NOT FOUND :::::::: " + iNo));
		return convertModelToDTO(ins);
		
	}

	@Override
	public List<InsuranceDTO> getAll() {
		List<Insurance> insurenceList = new ArrayList<>();
		List<InsuranceDTO> insurenceDtoList = new ArrayList<>();
		for(Insurance insurence: insurenceList) {
			insurenceDtoList.add(convertModelToDTO(insurence));
		}
		return insurenceDtoList;
	}

	@Override
	public Map<String, Boolean> delete(long iNo) throws Exception {
		
		Insurance insurence = convertDTOToModel(getById(iNo));
		insuranceRepository.delete(insurence);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Delete", Boolean.TRUE);
		return response;
	}
	
	private Insurance convertDTOToModel(InsuranceDTO dto) {
		Insurance insurence = new Insurance();
		insurence.setINo(dto.getINo());
		insurence.setInsuranceAmmount(dto.getIAmt());
		insurence.setInsuranceExp(dto.getIExpiryDate());
		insurence.setPait(dto.getPatient());
		return insurence;
	}
	
	private InsuranceDTO convertModelToDTO(Insurance insurence) {
		InsuranceDTO dto = new InsuranceDTO();
		dto.setINo(insurence.getINo());
		dto.setIAmt(insurence.getInsuranceAmmount());
		dto.setIExpiryDate(insurence.getInsuranceExp());
		dto.setPatient(insurence.getPait());
		return dto;
	}

}
