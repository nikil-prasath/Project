package com.organization.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
