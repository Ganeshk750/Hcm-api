package com.hcm.service;

import java.util.List;
import java.util.Map;

import com.hcm.dto.MedicosDTO;

public interface MedicosService {
	
	public MedicosDTO save(MedicosDTO medicosDTO);
	public MedicosDTO update(MedicosDTO medicosDTO, long mId) throws Exception;
	public MedicosDTO getById(long mId) throws Exception;
	public List<MedicosDTO> getAll();
	public Map<String, Boolean> delete(long mId) throws Exception;
	public List<MedicosDTO> getAllByPatientId(long pId);
	public long getTotal(long id);

}
