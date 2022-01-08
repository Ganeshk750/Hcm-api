package com.hcm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hcm.dto.EmployeeDTO;
import com.hcm.model.Employee;
import com.hcm.repository.DoctorRepository;
import com.hcm.repository.EmployeeRepository;
import com.hcm.service.EmployeeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeRepository employeeRepository;

	@Override
	public EmployeeDTO save(EmployeeDTO employee) {
		Employee emp = convertDTOtoModel(employee);
		employeeRepository.save(emp);
		log.info("::::::::::::::::::: "+ emp.getEId());
		return convertModeToDTO(emp);
	}

	@Override
	public EmployeeDTO update(EmployeeDTO employee, long empId) throws Exception {
		return null;
	}

	@Override
	public EmployeeDTO getById(long empId) throws Exception {
		Employee emp = employeeRepository.findById(empId)
				.orElseThrow(() -> new Exception("ID NOT FOUND :::: " + empId));
		return convertModeToDTO(emp);
	}

	@Override
	public List<EmployeeDTO> getAll() {
		List<Employee> empList = employeeRepository.findAll(); 
		List<EmployeeDTO> empDtoList = new ArrayList<>();
		
		for(Employee emp : empList) {
			empDtoList.add(convertModeToDTO(emp));
		}
		return empDtoList;
	}

	@Override
	public Map<String, Boolean> delete(long empId) throws Exception {
		Employee emp = convertDTOtoModel(getById(empId));

		employeeRepository.delete(emp);

		Map<String, Boolean> response = new HashMap<>();
		response.put("Delete", Boolean.TRUE);
		return response;
	}

	@Override
	public boolean isExists(EmployeeDTO empDto) {
		Employee emp = employeeRepository.findByEmpMob(empDto.getEmpMobNo());
		if(emp != null) {
			return true;
		}else {			
			return false;
		}
	}
	
	
	private Employee convertDTOtoModel(EmployeeDTO empDto) {
		Employee emp = new Employee();
		emp.setEId(empDto.getEmpId());
		emp.setDept(empDto.getDepartment());
		emp.setEmpMob(empDto.getEmpMobNo());
		emp.setEmpAddress(empDto.getEmpAdd());
		emp.setEmpName(empDto.getEmpName());
		return emp;
	}
	
	private EmployeeDTO convertModeToDTO(Employee employee) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpId(employee.getEId());
		dto.setEmpName(employee.getEmpName());
		dto.setDepartment(employee.getDept());
		dto.setEmpAdd(employee.getEmpAddress());
		dto.setEmpMobNo(employee.getEmpMob());
		return dto;
	}

}
