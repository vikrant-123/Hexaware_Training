package com.hexaware;

import java.util.Arrays;

public class MainClass {

	public static void main(String[] args) {
		
		Employee emp= new Employee();
		
		emp.setEmpno(101);
		emp.setEname("Vikrant");
		
		System.out.println("EmpNo: "+emp.getEmpno()+" Ename: "+emp.getEname());
		System.out.println(emp);
		
		Employee emp1 = new Employee(102, "Prashant");
		System.out.println(emp1);
		
		int[] arr = new int[3];
		arr[0]=1;
		arr[1]=2;
		arr[2]=3;
		System.out.println(arr); // it gives address
		System.out.println(Arrays.toString(arr)); // it gives Array Elements
		
		for(int i=0;i<arr.length;i++) {
			System.out.println("arr[i] = "+arr[i]);
		}
		
		// Enhanced For Loop
		for(int i:arr) {
			System.out.println(i);
		}
		
		// While Loop
		int i=0;
		while(i<arr.length) {
			System.out.println("arr[i] = "+arr[i]);
			i++;
		}
		
		System.out.println("-----------------------");
		
		String[] strArr = {"Shiva","Hari","Bala","Seetha"};
		System.out.println(Arrays.toString(strArr));
		
		System.out.println("-----------------------");
		
		// Do While Loop
		int j=0;
		do {
			
			System.out.println("arr[j] = "+arr[j]);
		    j++;
				
		}while(j<arr.length);
		
		System.out.println("--------Creating Employee Type of Array----------");
		
		Employee[] empArr = new Employee[3];
		empArr[0]= new Employee(101, "Vikrant");
		empArr[1]= new Employee(102, "Prashant");
		empArr[2]= new Employee(103, "Vedant");
		
		for(Employee k: empArr) {
			System.out.println(k);
		}
		
	}

}
