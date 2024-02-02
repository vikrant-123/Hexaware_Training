package com.hexaware;

// private instance variable + public Constructor with no args + 
// public set() and get() methods + public toString() method 
// then it becomes POJO class(Plain Old Java Object)

public class Employee {

		private int empno;
		private String ename;
		
		public Employee() {
			System.out.println("From Employee() Constr...");
		}
		
		public Employee(int eno, String Ename) {
			System.out.println("From Employee(int eno, String Ename) Constr...");
				this.empno=eno;
				this.ename=Ename;
		}
		
		public int getEmpno() {
			return empno;
		}
		
		public void setEmpno(int empno) {
			this.empno=empno;
		}
		
		public String getEname() {
			return ename;
		}
		
		public void setEname(String ename) {
			this.ename=ename;
		}
		
		public String toString() {
			return empno+" -- "+ename;
			
		}

	}

