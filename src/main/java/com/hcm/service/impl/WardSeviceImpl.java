package com.hcm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hcm.dto.WardDTO;
import com.hcm.model.Ward;
import com.hcm.repository.WardRepository;
import com.hcm.service.WardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class WardSeviceImpl implements WardService {
	
	private final WardRepository wardRepository;

	@Override
	public WardDTO save(WardDTO wardDto) {
		Ward ward = convertDTOtoModel(wardDto);
		wardRepository.save(ward);
		log.info(":::::::::::::::::::::::::::: "+ ward.getWid());
		return convertModelToDTO(ward);
	}

	@Override
	public WardDTO update(WardDTO ward, long wId) throws Exception {
		
        WardDTO wardDto = getById(wId);
		
        wardDto.setWardNumber(ward.getWardNumber());
        wardDto.setDoctor(ward.getDoctor());
        wardDto.setPatient(ward.getPatient());
		
		Ward wd = convertDTOtoModel(wardDto);
		wardRepository.save(wd);
		log.info("update ::::::::::::::::::::::::"+ wd.getWid());
		return convertModelToDTO(wd);
	}

	@Override
	public WardDTO getById(long wId) throws Exception {
		Ward ward = wardRepository.findById(wId)
				.orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + wId));
		return convertModelToDTO(ward);
	}

	@Override
	public List<WardDTO> getAll() {
		List<Ward> wardlList = wardRepository.findAll();
		List<WardDTO> wardDTOList = new ArrayList<>();
		
		for(Ward ward : wardlList) {
			wardDTOList.add(convertModelToDTO(ward));
		}
		
		return wardDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long wId) throws Exception {
		Ward ward = convertDTOtoModel(getById(wId));
		wardRepository.delete(ward);
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Delete", Boolean.TRUE);
		
		return response;
	}
	
	

	private Ward convertDTOtoModel(WardDTO wardDTO) {

		Ward ward = new Ward();

		ward.setWid(wardDTO.getWid());
		ward.setWardName(wardDTO.getWardNumber());
		ward.setPatient(wardDTO.getPatient());
		ward.setDoctor(wardDTO.getDoctor());
		
		return ward;
	}

	private WardDTO convertModelToDTO(Ward ward) {
		WardDTO dto = new WardDTO();
		dto.setWid(ward.getWid());
		dto.setDoctor(ward.getDoctor());
		dto.setWardNumber(ward.getWardName());
		dto.setPatient(ward.getPatient());
		return dto;
	}

}
