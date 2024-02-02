package com.hexaware.demo;

import java.util.List;

public class Employee1 {
	private int empId;
	private String empName;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Employee1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee1(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}

	public void employeeInfo(List<? super Manager1> list) {
			
	}
}
