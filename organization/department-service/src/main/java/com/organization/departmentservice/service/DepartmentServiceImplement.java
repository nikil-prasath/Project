package com.organization.departmentservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.departmentservice.Dto.DepartmentDto;
import com.organization.departmentservice.entity.Department;
import com.organization.departmentservice.repository.DepartmentRepository;

@Service("DepartmentService")
public class DepartmentServiceImplement implements DepartmentService {
	
	@Autowired
	private DepartmentRepository repo;
	@Autowired
	private ModelMapper modelmapper;
	private Department department_entity,result;
	
	@Override
	public DepartmentDto saveData(DepartmentDto data) {
		
		department_entity=modelmapper.map(data,Department.class);
		
		result=repo.save(department_entity); 
		
		return modelmapper.map(result, DepartmentDto.class);
	}

	@Override
	public DepartmentDto fetchData(int id) {
		
		Optional<Department> entity=repo.findById(id);
		return modelmapper.map(entity, DepartmentDto.class);
	}

	@Override
	public String removeData(int id) {
		repo.deleteById(id);
		return "Entity Deleted";
	}

	@Override
	public List<DepartmentDto> fetchall() {
		List<Department> list=repo.findAll();
		List<DepartmentDto> dtoList=new ArrayList<>();
		for (Department data : list) {
			dtoList.add(modelmapper.map(data,DepartmentDto.class));
		}
		return dtoList;
	}

}
