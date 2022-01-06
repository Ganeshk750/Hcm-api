package com.hcm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.hcm.dto.DepartmentDTO;
import com.hcm.model.Bill;
import com.hcm.model.Department;
import com.hcm.repository.DepartmentRepositrory;
import com.hcm.service.DepartmentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
	
	private final DepartmentRepositrory departmentRepositrory;

	@Override
	public DepartmentDTO save(DepartmentDTO department) {
		Department dept = convertDTOtoModel(department);
		departmentRepositrory.save(dept);
		log.info("::::::::::::::::::::::::"+ dept.getDId());
		return department;
	}

	@Override
	public DepartmentDTO update(DepartmentDTO department, long deptId) throws Exception {
		Department deptEntity = departmentRepositrory.getById(deptId);
		deptEntity.setDId(department.getDeptId());
		deptEntity.setDeptName(department.getDeptName());
		
		DepartmentDTO deptDto = convertModelToDTO(deptEntity);
		Department deptSave = convertDTOtoModel(deptDto);
		Department save = departmentRepositrory.save(deptSave);
		DepartmentDTO dto = convertModelToDTO(save);
		log.info("::::::::::::::::::::::::"+ dto.getDeptId());
		return dto;
	}

	@Override
	public DepartmentDTO getById(long deptId) throws Exception {
		Department dpt = departmentRepositrory.findById(deptId)
				          .orElseThrow(() ->  new Exception("ID NOT FOUND EXCEPTION:::: "+ deptId));
		return convertModelToDTO(dpt);
	}

	@Override
	public List<DepartmentDTO> getAll() {
		List<Department> deptList = departmentRepositrory.findAll();
		List<DepartmentDTO> deptDTOList = new ArrayList<>();
		for(Department dept: deptList) {
			deptDTOList.add(convertModelToDTO(dept));
		}
		return deptDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long deptId) throws Exception {
		
		DepartmentDTO dept = convertModelToDTO(departmentRepositrory.getById(deptId));
		departmentRepositrory.delete(convertDTOtoModel(dept));
		Map<String, Boolean> result = new HashMap();
		result.put("Delete", Boolean.TRUE);
		return result;
	}
	
	
	private Department convertDTOtoModel(DepartmentDTO departmentDTO) {
		Department dept = new Department();
		dept.setDId(departmentDTO.getDeptId());
		dept.setDeptName(departmentDTO.getDeptName());
		return dept;
	}
	
	private DepartmentDTO convertModelToDTO(Department department) {
		 DepartmentDTO dto = new DepartmentDTO();
		 dto.setDeptId(department.getDId());
		 dto.setDeptName(department.getDeptName());
		 return dto;
	}

}
