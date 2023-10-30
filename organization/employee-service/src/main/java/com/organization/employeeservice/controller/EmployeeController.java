package com.organization.employeeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.organization.employeeservice.Dto.DepartmentDto;
import com.organization.employeeservice.Dto.EmployeeDetails;
import com.organization.employeeservice.Dto.EmployeeDto;
import com.organization.employeeservice.feign.Feign_Client;
import com.organization.employeeservice.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	private EmployeeDto employeeDto;
	@Autowired
	private Feign_Client feign;
	
	@PostMapping("/post")
	public ResponseEntity<EmployeeDto> storeEntity(@RequestBody EmployeeDto data){
		
		employeeDto=service.saveData(data);
		return new ResponseEntity<>(employeeDto,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> fetchEntity(@PathVariable("id") int id ){
		
		employeeDto=service.fetchData(id);
		
		return new ResponseEntity<>(employeeDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteData(@PathVariable("id") int id) {
		String result=service.removeData(id);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<EmployeeDto>> fetchAllEntity(){
		
		List<EmployeeDto> entities=service.fetchall();
		return new ResponseEntity<List<EmployeeDto>>(entities,HttpStatus.OK);
	}
	
	@GetMapping("/{id}/details")
	public ResponseEntity<EmployeeDetails> fetchDetails(@PathVariable int id){
		EmployeeDetails entity=new EmployeeDetails();
		employeeDto=service.fetchData(id);
		ResponseEntity<DepartmentDto> department=feign.getEntity(employeeDto.getDepartmentID()); 
		entity.setEmp(employeeDto);
		entity.setDept(department.getBody());
		return new ResponseEntity<>(entity,HttpStatus.OK);
		
		
	}

}
