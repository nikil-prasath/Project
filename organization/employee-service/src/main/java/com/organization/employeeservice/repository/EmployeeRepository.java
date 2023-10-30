package com.organization.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
