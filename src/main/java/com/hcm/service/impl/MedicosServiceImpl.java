package com.hcm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hcm.dto.MedicosDTO;
import com.hcm.model.Medicos;
import com.hcm.repository.MediosRepository;
import com.hcm.service.MedicosService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MedicosServiceImpl implements MedicosService{
	
	private final MediosRepository mediosRepository;

	@Override
	public MedicosDTO save(MedicosDTO medicosDTO) {
		medicosDTO.setTotal(medicosDTO.getPrice() * medicosDTO.getQuantity());
		Medicos medicos = convertDTOToModel(medicosDTO);
		mediosRepository.save(medicos);
		log.info(":::::::::::::::::::::::::::::::::: "+ medicos.getMPrice());
		return convertModelToDTO(medicos);
	}

	@Override
	public MedicosDTO update(MedicosDTO medicosDTO, long mId) throws Exception {
		MedicosDTO medicosDto = getById(mId);
		medicosDto.setMRecord(medicosDTO.getMRecord());
		medicosDto.setDoctor(medicosDTO.getDoctor());
		medicosDto.setDate(medicosDTO.getDate());
		medicosDto.setPatient(medicosDTO.getPatient());
		medicosDto.setPrice(medicosDTO.getPrice());
		medicosDto.setQuantity(medicosDTO.getQuantity());
		medicosDto.setTotal(medicosDTO.getPrice() * medicosDTO.getQuantity());
		Medicos medicos = convertDTOToModel(medicosDto);
		log.info("updated :::::::::::::::::::::::::::::::::: "+ medicos.getMedId());
		return convertModelToDTO(medicos);
	}

	@Override
	public MedicosDTO getById(long mId) throws Exception {
		Medicos medicos = mediosRepository.findById(mId).orElseThrow(() -> new Exception("ID NOT FOUND :::: " + mId));
		return convertModelToDTO(medicos);
	}

	@Override
	public List<MedicosDTO> getAll() {
		List<Medicos> mdedicosList = new ArrayList<>();
		List<MedicosDTO> medicosDTOList = new ArrayList<>();
		for(Medicos medicos: mdedicosList) {
			medicosDTOList.add(convertModelToDTO(medicos));
		}
		return medicosDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long mId) throws Exception {
		
		Medicos medicos = convertDTOToModel(getById(mId));
		mediosRepository.delete(medicos);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Delete",Boolean.TRUE);
		return response;
	}

	@Override
	public List<MedicosDTO> getAllByPatientId(long pId) {
		List<Medicos> medicosList = mediosRepository.findAllByPatientPid(pId);
		List<MedicosDTO> medicosDtoList = new ArrayList<>();
		for(Medicos med: medicosList) {
			medicosDtoList.add(convertModelToDTO(med));
		}
		return medicosDtoList;
	}

	@Override
	public long getTotal(long id) {
		List<MedicosDTO> medicosList = getAllByPatientId(id);
		long total = 0;
		for(MedicosDTO med: medicosList) {
			total += med.getTotal();
		}
		return total;
	}
	
	private Medicos convertDTOToModel(MedicosDTO dto) {
		Medicos medicos = new Medicos();
		medicos.setMedId(dto.getMId());
		medicos.setMRecord(dto.getMRecord());
		medicos.setDate(dto.getDate());
		medicos.setDoctor(dto.getDoctor());
		medicos.setPatient(dto.getPatient());
		medicos.setMPrice(dto.getPrice());
		medicos.setMQuentity(dto.getQuantity());
		medicos.setMTotal(dto.getTotal());
		return medicos;
	}
	
	private MedicosDTO convertModelToDTO(Medicos medicos) {
		MedicosDTO dto = new MedicosDTO();
		dto.setMId(medicos.getMedId());
		dto.setDate(medicos.getDate());
		dto.setDoctor(medicos.getDoctor());
		dto.setMRecord(medicos.getMRecord());
		dto.setPatient(medicos.getPatient());
		dto.setPrice(medicos.getMPrice());
		dto.setQuantity(medicos.getMQuentity());
		dto.setTotal(medicos.getMTotal());
		return dto;
	}

}
