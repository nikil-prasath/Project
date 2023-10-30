package com.organization.employeeservice.Dto;

public class EmployeeDetails {
	
	EmployeeDto emp;
	DepartmentDto dept;
	public EmployeeDto getEmp() {
		return emp;
	}
	public void setEmp(EmployeeDto emp) {
		this.emp = emp;
	}
	public DepartmentDto getDept() {
		return dept;
	}
	public void setDept(DepartmentDto dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [emp=" + emp + ", dep=" + dept + "]";
	}
	
	

}
