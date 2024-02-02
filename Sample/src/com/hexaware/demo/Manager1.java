package com.hexaware.demo;

import java.util.ArrayList;
import java.util.List;

public class Manager1 {

	private int mgrId;
	private String mgrName;

	public int getMgrId() {
		return mgrId;
	}

	public void setMgrId(int mgrId) {
		this.mgrId = mgrId;
	}

	public String getMgrName() {
		return mgrName;
	}

	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}
	
	public Manager1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager1(int mgrId, String mgrName) {
		super();
		this.mgrId = mgrId;
		this.mgrName = mgrName;
	}

	public static void managerInfo(List<? extends Employee1> list) {
		
		
	}

	public static void main(String[] args) {
		
		
		List<Manager1> mgr = new ArrayList<>();
		

	}

}
