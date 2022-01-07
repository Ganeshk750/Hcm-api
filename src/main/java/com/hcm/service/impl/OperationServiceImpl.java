package com.hcm.service.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hcm.dto.OperationDTO;
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
		return null;
	}

	@Override
	public OperationDTO update(OperationDTO operationDTO, long oId) throws Exception {
		return null;
	}

	@Override
	public OperationDTO getById(long oId) throws Exception {
		return null;
	}

	@Override
	public List<OperationDTO> getAll() {
		return null;
	}

	@Override
	public Map<String, Boolean> delete(long oId) throws Exception {
		return null;
	}

}
