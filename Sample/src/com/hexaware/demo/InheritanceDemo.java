package com.hexaware.demo;

class Employee{
	int empno=101;
	String empName="Vikrant";
	
	Employee(){									// Constr.
		System.out.println("From Employee Constr....");
	}
	
	Employee(int eid, String ename){           // Constr. OverLoading
		this("Vedant", 103);				   // Call the same class Constr.
		System.out.println("From Param. Constr.....");
		this.empno=eid;
		this.empName=ename;
	}
	
	Employee(int eid, int sal){				  // Constr. OverLoading
		System.out.println("From Param. Constr..... "+eid+" --- "+sal);
	}
	
	Employee(String ename, int eid){		  // Constr. OverLoading
		System.out.println("From Param. Constr " +ename+ " --- "+ eid);
	}
	
	public String getDetails() {			// Method 1
		return empno+" "+empName;
	}
	
	public int getSalaryInfo() {            // Method 2
		return 100000;
	}
	
	protected String getSalaryInfo(int x) {	// Method 2 OverLoading
		return "200000";
	}
}

class Manager extends Employee{
	String dept="IT";
	
	public Manager() {
		super(104,"Tejas");                // Will invoke Parent class constructor
		System.out.println("From Manager Constr.....");
	}
	
	public String getDetails() {			   // Method 1 OverRiding
		return super.getDetails()+" "+dept;    // Call parent class overridden method
	}
	
}

public class InheritanceDemo {

	public static void main(String[] args) {
		Employee emp = new Employee(102, "Prashant");
//		System.out.println(emp.getDetails());
//		
//		Manager mgr = new Manager();
//		System.out.println(mgr.getDetails());
		
		System.out.println(emp.getSalaryInfo());
		System.out.println(emp.getSalaryInfo(50));
		
	}

}
