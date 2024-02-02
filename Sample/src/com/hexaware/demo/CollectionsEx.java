package com.hexaware.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class CollectionsEx {

	public static void main(String[] args) {
		
		System.out.println("-----------ArrayList------------");
		
		// ArrayList
		List<Object> list = new ArrayList<Object>();
		
		list.add("Vikrant");
		list.add(101);
		list.add(20.5);
		list.add("Vedant");
		list.add(null);
		list.add(true);
		list.add("Vikrant");
		list.add('V');
		
		System.out.println(list);
		list.remove(5);
		
		System.out.println(list);
		Iterator<Object> it =list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println(list.size());     // Gives Size of the list
		
		System.out.println(list.isEmpty());  // check if list is empty or not
		
		System.out.println();
		System.out.println("-----------LinkedList------------");
		
		// LinkedList
		List list1 = new LinkedList();
		
		list1.add("Vikrant");
		list1.add(101);
		list1.add(20.5);
		list1.add("Vedant");
		list1.add(null);
		list1.add(true);
		list1.add("Vikrant");
		list1.add('V');
		
		System.out.println(list1);
		System.out.println();
		System.out.println("-----------Vector------------");
		
		// Vector
		
		List list2 = new Vector();
		
		list2.add("Vikrant");
		list2.add(101);             
		list2.add(20.5);			  
		list2.add("Vedant");
		list2.add(null);
		list2.add(true);              
		list2.add("Vikrant");
		list2.add('V');
		
		System.out.println(list2);
		System.out.println();
		System.out.println("-----------HashSet------------");
		
		// HashSet 
		
		Set set = new HashSet();
		set.add("Prashant");
		set.add(null);
		set.add(102);
		set.add(24.1);
    	set.add(true);
		set.add("Prashant");     // cannot add Duplicate values
		set.add("Vikrant");
		set.add('H');
		
		System.out.println(set);
		System.out.println();
		
		Iterator itt =set.iterator();
		while(itt.hasNext()) {
			System.out.println(itt.next());
		}
		
		System.out.println("-----------TreeSet------------");
		
		//TreeSet
		
		Set set1= new TreeSet();	    // Accept only Homogeneous data
		set1.add("Prashant");       
		//set1.add(null);               // cannot add null into TreeSet
//		set1.add(102);
//		set1.add(24.1);
//		set1.add(true);
		set1.add("Prashant");           // cannot add duplicate values
		set1.add("Vikrant");
		//set1.add('H');				// Accept only Homogeneous data
		//set1.add('V');
		
		System.out.println(set1);
		System.out.println();
		System.out.println("-----------HashMap------------");
		
		// HashMap
		
		Map map = new HashMap();
		map.put("1", "Vikrant");
		map.put("2", 103);
		map.put("4", true);
		map.put("3", "Vikrant");
		map.put("5", 'M');
		map.put("4", 1.1);
		map.put(null, "Vedant");
		map.put("6", null);
		
		
		System.out.println(map);
		System.out.println();
		
		System.out.println("-----------TreeMap------------");
		
		// TreeMap 
		
		Map map2= new TreeMap();  //Sorted by keys
		map2.put("1", "Vikrant");
		map2.put("2", 103);
		map2.put("4", true);
		map2.put("4", 1.1);
		map2.put("3", "Vikrant");
		map2.put("5", 'M');
		map2.put("ab", 20);
		//map2.put(null, "Vedant"); // cannot add null key to TreeMap
		
		System.out.println(map2);
		System.out.println();
		
		Collection col=map2.values();
		Iterator itm =col.iterator();
		while(itm.hasNext()) {
			System.out.println(itm.next());
		}
		
		System.out.println("-----------Hashtable------------");
		
		// Hashtable
		
		Map map3 = new Hashtable();
		map3.put("1", "Vikrant");
		map3.put("2", 103);
		map3.put("4", true);
		map3.put("4", 1.1);
		map3.put("3", "Prashant");
		map3.put("5", 'M');
		//map3.put(null, "Vedant");       // cannot add null key to Hashtable
		
		System.out.println(map3);

	}

}
