package com.divyansh.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Map.Entry;

public class MyHashMapDemo {

	public static void main(String [] args){
		
		HashMap<Integer,String> students = new HashMap<Integer,String>();
		
		HashMap<Integer,String> students2 = new HashMap<Integer,String>();
		
		students2.put(26, "Dipankar Chakraborty");
		students2.put(7, "Aman Gupta");
		students2.put(73, "Vipul Kumar Maurya");
		
		
		students.put(27, "Divyansh Mishra");
		students.put(6, "Sakshi Verma");
		students.putAll(students2);
		
		System.out.println(students);
		
		students.putIfAbsent(99, "Vashu Mishra");
		
		System.out.println(students);
		
		System.out.println(students.get(6));
		
		System.out.println(students.containsKey(27));
		System.out.println(students.containsValue("Sakshi Verma"));
		
		students.replace(99, "Vashu Kumar Mishra");
		students.replace(27,"Divyansh Mishra", "Divyansh Kumar Mishra");
		students.replace(27,"Divyansh Kumar Mishra", "D K Mishra");
		
		System.out.println(students);
		
		students.remove(99);
		students.remove(26, "Dipankar Chakraborty");
		
		System.out.println(students);
		
		Set<Integer> keys = new HashSet<Integer>();
		keys = students.keySet();
		
		System.out.println(keys);
		
		Collection<String> values = new LinkedList<String>();
		values = students.values();
		
		System.out.println(values);
		
		Set<Entry<Integer,String>> entries = new HashSet<Entry<Integer,String>>();
		entries = students.entrySet();
		
		System.out.println(entries);
		
		for(Entry<Integer,String> entry:entries) {
			entry.setValue("Honorable " + entry.getValue());
		}
		
		System.out.println(entries);
	}	
}
	
