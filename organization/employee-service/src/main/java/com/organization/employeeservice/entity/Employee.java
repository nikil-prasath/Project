package com.organization.employeeservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	int id;
	String name;
	int departmentID;
	int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", departmentID=" + departmentID + ", age=" + age + "]";
	}
	
	
}
