package com.organization.employeeservice.Dto;

public class DepartmentDto {
	
	int id;
	String name;
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
	@Override
	public String toString() {
		return "DepartmentDto [id=" + id + ", name=" + name + "]";
	}
	

}
