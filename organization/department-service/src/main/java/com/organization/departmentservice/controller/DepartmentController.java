package com.organization.departmentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.organization.departmentservice.Dto.DepartmentDto;
import com.organization.departmentservice.service.DepartmentServiceImplement;


@RestController
public class DepartmentController {
	
	private DepartmentDto dataDto;
	@Autowired
	private DepartmentServiceImplement department_service;
	
	@PostMapping("/post")
	public ResponseEntity<DepartmentDto> storeEntity(@RequestBody DepartmentDto data){
		
		dataDto=department_service.saveData(data);
		return new ResponseEntity<DepartmentDto>(dataDto, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DepartmentDto> getEntity(@PathVariable("id") int id){
		
		dataDto=department_service.fetchData(id);
		return new ResponseEntity<DepartmentDto>(dataDto,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteData(@PathVariable("id") int id) {
		String result=department_service.removeData(id);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<DepartmentDto>> fetchAllEntity(){
		
		List<DepartmentDto> entities=department_service.fetchall();
		return new ResponseEntity<List<DepartmentDto>>(entities,HttpStatus.OK);
	}

}
