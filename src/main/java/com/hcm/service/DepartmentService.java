package com.hcm.service;

import java.util.List;
import java.util.Map;

import com.hcm.dto.DepartmentDTO;

public interface DepartmentService {
	
	public DepartmentDTO save(DepartmentDTO department);
	public DepartmentDTO update(DepartmentDTO department, long deptId) throws Exception;
	public DepartmentDTO getById(long deptId) throws Exception;
	public List<DepartmentDTO> getAll();
	public Map<String, Boolean> delete(long deptId) throws Exception;

}
