package com.organization.employeeservice.service;

import java.util.List;


import com.organization.employeeservice.Dto.EmployeeDto;

public interface EmployeeService {
	
	public EmployeeDto saveData(EmployeeDto data);
	
	public EmployeeDto fetchData(int id);
	
	public String removeData(int id);
	
	public List<EmployeeDto> fetchall();

}
