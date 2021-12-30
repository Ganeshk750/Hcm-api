package com.hcm.service;

import java.util.List;
import java.util.Map;

import com.hcm.dto.BillDTO;

public interface BillService {
	
	public BillDTO save(BillDTO billDto);
	public BillDTO update(BillDTO billDto, long bid) throws Exception;
	public BillDTO getById(long bid) throws Exception;
	public List<BillDTO> getALLBills();
	public Map<String, Boolean> delete(long bid) throws Exception;

}
