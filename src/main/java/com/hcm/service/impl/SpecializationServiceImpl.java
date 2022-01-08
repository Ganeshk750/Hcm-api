package com.hcm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hcm.dto.SpecializationDTO;
import com.hcm.model.Specialization;
import com.hcm.repository.SpecializationRepository;
import com.hcm.service.SpecializationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SpecializationServiceImpl implements SpecializationService {
	
	private final SpecializationRepository specializationRepository;

	@Override
	public SpecializationDTO save(SpecializationDTO specializationDTO) {
		Specialization spec = convertDTOtoModel(specializationDTO);
		specializationRepository.save(spec);
		log.info("::::::::::::::::::::::::::::::"+ spec.getSpecId());
		return convertModelToDTO(spec);
	}

	@Override
	public SpecializationDTO update(SpecializationDTO specializationDTO, long specId) throws Exception {
		SpecializationDTO specDto = getById(specId);
		specDto.setSpeciality(specializationDTO.getSpeciality());
		Specialization spec = convertDTOtoModel(specDto);
		specializationRepository.save(spec);
		log.info("Update :::::::::::::::::::::::::::::::"+ spec.getSpecId());
		return convertModelToDTO(spec);
	}

	@Override
	public SpecializationDTO getById(long specId) throws Exception {
		Specialization specialization = specializationRepository.findById(specId)
				.orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + specId));
		 return convertModelToDTO(specialization);
	}

	@Override
	public List<SpecializationDTO> getAll() {

		List<Specialization> specializationList = specializationRepository.findAll();
		List<SpecializationDTO> specializationDTOList = new ArrayList<>();
		
		for(Specialization specialization : specializationList) {
			specializationDTOList.add(convertModelToDTO(specialization));
		}
		
		return specializationDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long specId) throws Exception {
		Specialization specialization = convertDTOtoModel(getById(specId));
		specializationRepository.delete(specialization);
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Delete", Boolean.TRUE);
		
		return response;
	}
	
	private Specialization  convertDTOtoModel(SpecializationDTO speDTO) {
		Specialization spe = new Specialization();
		speDTO.setSpecId(spe.getSpecId());
		speDTO.setSpeciality(spe.getSpeciality());
		return spe;
	}
	
	private SpecializationDTO convertModelToDTO(Specialization spciSpecialization) {
		SpecializationDTO dto = new SpecializationDTO();
		dto.setSpecId(spciSpecialization.getSpecId());
		dto.setSpeciality(spciSpecialization.getSpeciality());
		return dto;
	}

}
