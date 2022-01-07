package com.hcm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hcm.dto.OperationDTO;
import com.hcm.model.Operation;
import com.hcm.repository.OperationRepository;
import com.hcm.service.OperationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OperationServiceImpl implements OperationService {
	
	private final OperationRepository operationRepository;

	@Override
	public OperationDTO save(OperationDTO operationDTO) {
		Operation opt = convertDTOToModel(operationDTO);
		operationRepository.save(opt);
		log.info(":::::::::::::::::::::::::: "+ opt.getOid());
		return convertModeToDTO(opt);
	}

	@Override
	public OperationDTO update(OperationDTO operationDTO, long oId) throws Exception {
		OperationDTO optDto = getById(oId);
		optDto.setOName(operationDTO.getOName());
		optDto.setDoctor(operationDTO.getDoctor());
		optDto.setPatient(operationDTO.getPatient());
		
		Operation operation = convertDTOToModel(optDto);
		operationRepository.save(operation);
		log.info("update:::::::::::::::::::::::"+ operation.getOid());
		return convertModeToDTO(operation);
	}

	@Override
	public OperationDTO getById(long oId) throws Exception {
		Operation operation = operationRepository.findById(oId)
				.orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + oId));
		return convertModeToDTO(operation);
	}

	@Override
	public List<OperationDTO> getAll() {
		List<Operation> operationList = operationRepository.findAll();
		List<OperationDTO> operationDTOList = new ArrayList<>();
		for(Operation opt: operationList) {
			operationDTOList.add(convertModeToDTO(opt));
		}
		return operationDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long oId) throws Exception {
		Operation operation = convertDTOToModel(getById(oId));
		operationRepository.delete(operation);
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Delete", Boolean.TRUE);
		
		return response;
	}
	
	private Operation convertDTOToModel(OperationDTO operationDTO) {
		Operation operation = new Operation();
		operation.setOid(operationDTO.getOid());
		operation.setOpName(operationDTO.getOName());
		operation.setDoctor(operation.getDoctor());
		operation.setPatient(operationDTO.getPatient());
		return operation;
	}
	
	private OperationDTO convertModeToDTO(Operation operation) {
		OperationDTO dto = new OperationDTO();
		dto.setOid(operation.getOid());
		dto.setOName(operation.getOpName());
		dto.setDoctor(operation.getDoctor());
		dto.setPatient(operation.getPatient());
		return dto;
	}

}
