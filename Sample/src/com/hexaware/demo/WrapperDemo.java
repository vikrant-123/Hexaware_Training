package com.hexaware.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class WrapperDemo {

	public static void main(String[] args) {
		/*int x = 100;
		Integer i = x;               // Boxing(Converting ValueType to ReferenceType)
		
		int z = i.intValue();       // Unboxing(Converting ReferenceType to ValueType)
		
		System.out.println(x + "  " + i);
		
		System.out.println(x+i+z);
		System.out.println(i+z+x);
		
		//TypeCasting
		int a =10;          // 4 bytes
		double b = a;       // 8 bytes
		byte c = (byte)b;   // 1  byte
		*/
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(3);
		intList.add(5);
		intList.add(2);
		intList.add(9);
		System.out.println(intList);
		
//		Integer x=Collections.max(intList);
//		System.out.println(x);
		
		getMax(intList);
		
	}
	public static void getMax(List<Integer> list){
	    int max = list.get(0).intValue();
	    for(int i=0; i<list.size(); i++){
	        if(list.get(i).intValue() > max){
	            max = list.get(i).intValue();
	        }	        
	    }
	    System.out.println(max);
	   
	}

}
