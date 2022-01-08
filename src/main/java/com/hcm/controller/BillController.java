package com.hcm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcm.dto.BillDTO;
import com.hcm.service.BillService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BillController {
	
	private final BillService billService;
	
	@PostMapping("/bill")
	public ResponseEntity<BillDTO> addBill(@RequestBody BillDTO billDTO){
		BillDTO billDTO2 = billService.save(billDTO);
		return ResponseEntity.ok().body(billDTO2);
	}
	
	@PutMapping("/bill/{id}")
	public ResponseEntity<BillDTO> updateBill(@RequestBody BillDTO billDTO,
			        @PathVariable("id") long bId) throws Exception{
		BillDTO bill = billService.update(billDTO, bId);
		return ResponseEntity.ok().body(bill);
	}
	
	@GetMapping("/bill/{id}")
	public ResponseEntity<BillDTO> findById(@PathVariable long id) throws Exception{
		BillDTO bill = billService.getById(id);
		return ResponseEntity.ok().body(bill);
	}
	
	@GetMapping("/bill")
	public ResponseEntity<List<BillDTO>> listAllBill(){
		List<BillDTO> billList = billService.getALLBills();
		return ResponseEntity.ok().body(billList);
	}
	
	@DeleteMapping("/bill/{id}")
	public Map<String, Boolean> deleteBill(@PathVariable long id) throws Exception {
		return billService.delete(id);
	}

}
