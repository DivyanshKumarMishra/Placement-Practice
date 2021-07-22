package com.divyansh.collections;

import java.util.HashSet;
import java.util.Set;

public class MyHashSetDemo {

	public static void main(String[] args){
		
		Set<String> names = new HashSet<String>();
		Set<String> names2 = new HashSet<String>();
		
		names.add("Divyansh Mishra");
		names.add("Sakshi Verma");
		names.add("Gullo");
		
		names2.add("Dipanakar Chakraborty");
		names2.add("Aman Gupta");
		names2.add("Vipul Kumar Maurya");
		
		Set<String> names3 = new HashSet<String>();
		names3.add("Divyansh Mishra");
		names3.add("Sakshi Verma");
		
		names.addAll(names2);
		System.out.println(names.size());
		
		for(String name:names) {
			System.out.println(name);
		}
		
		names.remove("Sakshi Verma");
		names.removeAll(names2);
		
		System.out.println(names);
		
		System.out.println(names.contains("Gullo"));
		System.out.println(names.contains("Sakshi Verma"));
		
		names.retainAll(names3);
		System.out.println(names);
		
		String[] name = new String[names.size()];
		
		names.toArray(name);
		
		for(String n:name) {
			System.out.println(n);
		}
		
		System.out.println(names.isEmpty());
		
	}
	
}
