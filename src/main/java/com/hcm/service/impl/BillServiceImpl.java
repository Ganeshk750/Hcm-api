package com.hcm.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.hcm.dto.BillDTO;
import com.hcm.model.Bill;
import com.hcm.repository.BillRepository;
import com.hcm.service.BillService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class BillServiceImpl implements BillService {
	
	private final BillRepository billRepository;

	@Override
	public BillDTO save(BillDTO billDto) {
		Bill bill = convertDTOToModel(billDto);
		bill.setBillDate(new Date());
		Bill saveBill = billRepository.save(bill);
		return convertModelToDTO(saveBill);
	}

	@Override
	public BillDTO update(BillDTO bill, long bid) throws Exception {
		return null;
	}

	@Override
	public BillDTO getById(long bid) throws Exception {
		return null;
	}

	@Override
	public List<BillDTO> getALLBills() {
		return null;
	}

	@Override
	public Map<String, Boolean> delete(long bid) throws Exception {
		return null;
	}
	
	private Bill convertDTOToModel(BillDTO billDTO) {
		Bill bill = new Bill();
		bill.setBId(billDTO.getBId());
		bill.setBillAmmount(billDTO.getBAmt());
		bill.setInsurance(billDTO.getIns());
	    bill.setBillInsuared(billDTO.isInsured());
		bill.setPatient(billDTO.getPatient());
		bill.setBillDate(billDTO.getBillDate());
	    return bill;
	}
	
	private BillDTO convertModelToDTO(Bill bill) {
		return new BillDTO(bill);
	}

}
