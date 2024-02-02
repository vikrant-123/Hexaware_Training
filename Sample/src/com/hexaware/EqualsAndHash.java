package com.hexaware;

import java.util.Comparator;
import java.util.Objects;

public class EqualsAndHash implements Comparable<EqualsAndHash> {
	private int empno;
	private String ename;

	// Constructor
	public EqualsAndHash() {
		System.out.println("From EqualsAndHash Constr...");
	}

	public EqualsAndHash(int eno, String ename) {
		this.empno = eno;
		this.ename = ename;
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public int compareTo(EqualsAndHash e) {
		return this.getEmpno() - e.getEmpno();
	}

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ename);
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (o == this) {
			return true;
		}
		if (getClass() != o.getClass()) {
			return false;
		}

		EqualsAndHash e = (EqualsAndHash) o;
		return (this.getEname() == e.getEname());
	}
	
	/*
	 * Best Practices to Follow 
	 * Always use the same fields to generate hashCode() and equals(). 
	 * As in our case, we have used employee name. 
	 * The equals() must be  consistent (if the objects are not modified, 
	 * then it must keep returning the same value). 
	 * Whenever a.equals(b), then a.hashCode() must be same as b.hashCode(). 
	 * If we override one method, then we should override the other
	 * method as well.
	 */
	
	public static void main(String[] args) {
		
		EqualsAndHash emp = new EqualsAndHash();
		
		emp.setEmpno(101);
		emp.setEname("Vikrant");
		
		System.out.println("EmpNo: "+emp.getEmpno()+" Ename: "+emp.getEname());
		System.out.println(emp);
		
		EqualsAndHash emp1 = new EqualsAndHash(102, "Prashant");
		System.out.println(emp1);
		
		System.out.println(emp.equals(emp1));
		
		System.out.println(emp.hashCode());
		System.out.println(emp1.hashCode());
	}

}