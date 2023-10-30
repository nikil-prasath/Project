package com.organization.employeeservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.organization.employeeservice.Dto.DepartmentDto;

@FeignClient(name = "department-service")
public interface Feign_Client {
	
	@GetMapping("/{id}")
	public ResponseEntity<DepartmentDto> getEntity(@PathVariable("id") int id);

}
