package com.hcm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hcm.dto.BillDTO;
import com.hcm.model.Bill;
import com.hcm.repository.BillRepository;
import com.hcm.service.BillService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BillServiceImpl implements BillService {
	
	private final BillRepository billRepository;

	@Override
	public BillDTO save(BillDTO billDto) {
		Bill bill = convertDTOToModel(billDto);
		bill.setBillDate(new Date());
		Bill saveBill = billRepository.save(bill);
		log.info("::::::::::::::::::::::::"+ bill.getInsurance().getINo());
		return convertModelToDTO(saveBill);
	}

	@Override
	public BillDTO update(BillDTO billDto, long bid) throws Exception {
		
		Bill getBillEntity = billRepository.getById(bid);
		getBillEntity.setBId(bid);
		getBillEntity.setBillAmmount(billDto.getBAmt());
		getBillEntity.setBillInsuared(billDto.isInsured());
		getBillEntity.setInsurance(billDto.getIns());
		getBillEntity.setBillDate(new Date());
		
		
		BillDTO bill = convertModelToDTO(getBillEntity);
		Bill billsave = convertDTOToModel(bill);
		Bill save = billRepository.save(billsave);
		BillDTO bills = convertModelToDTO(save);
		log.info("::::::::::::::::::::::::"+ bills.getIns());
		return bills;
	}

	@Override
	public BillDTO getById(long bid) throws Exception {
		Bill bill = billRepository.findById(bid)
				         .orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION:::: "+ bid));
	    return convertModelToDTO(bill);
	}

	@Override
	public List<BillDTO> getALLBills() {
		List<Bill> billList = billRepository.findAll();
		List<BillDTO> billDTOList = new ArrayList<>();
		for(Bill bill: billList) {
			billDTOList.add(convertModelToDTO(bill));
		}
		return billDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long bid) throws Exception {
		
		Bill bill = convertDTOToModel(getById(bid));
		billRepository.delete(bill);
		Map<String, Boolean> result = new HashMap();
		result.put("Delete", Boolean.TRUE);
		return result;
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
