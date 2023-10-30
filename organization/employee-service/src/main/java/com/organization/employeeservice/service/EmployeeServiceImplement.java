package com.organization.employeeservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.employeeservice.Dto.EmployeeDto;
import com.organization.employeeservice.entity.Employee;
import com.organization.employeeservice.repository.EmployeeRepository;

@Service("EmployeeService")
public class EmployeeServiceImplement implements EmployeeService{

	@Autowired
	private EmployeeRepository repo;
	private Employee employee_entity,result;
	@Autowired
	private ModelMapper modelmapper;
	
	@Override
	public EmployeeDto saveData(EmployeeDto data) {
		
		employee_entity=modelmapper.map(data, Employee.class);
		result=repo.save(employee_entity);
		return modelmapper.map(result, EmployeeDto.class);
	}

	@Override
	public EmployeeDto fetchData(int id) {
		
		Optional<Employee> entity=repo.findById(id);
		return modelmapper.map(entity, EmployeeDto.class);
	}

	@Override
	public String removeData(int id) {
		
		repo.deleteById(id);
		return "Entity Deleted";
		
	}

	@Override
	public List<EmployeeDto> fetchall() {
		
		List<Employee> list=repo.findAll();
		List<EmployeeDto> dtoList=new ArrayList<>();
		for (Employee data : list) {
			dtoList.add(modelmapper.map(data,EmployeeDto.class));
		}
		return dtoList;
	}

}
