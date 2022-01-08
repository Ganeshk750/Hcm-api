package com.hcm.service;

import java.util.List;
import java.util.Map;

import com.hcm.dto.WardDTO;

public interface WardService {
	
	public WardDTO save(WardDTO ward);
	public WardDTO update(WardDTO ward, long wId) throws Exception;
	public WardDTO getById(long wId) throws Exception;
	public List<WardDTO> getAll();
	public Map<String, Boolean> delete(long wId) throws Exception;

}
