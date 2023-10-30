package com.organization.departmentservice.service;

import java.util.List;

import com.organization.departmentservice.Dto.DepartmentDto;

public interface DepartmentService {
	
	public DepartmentDto saveData(DepartmentDto data);
	
	public DepartmentDto fetchData(int id);
	
	public String removeData(int id);
	
	public List<DepartmentDto> fetchall();

}
