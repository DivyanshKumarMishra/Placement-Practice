package com.divyansh.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		ArrayList<Integer> l1 = new ArrayList<Integer>();       
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		
		l1.add(4);                    
		l1.add(5);
		l1.add(0,1);                  
		l1.add(1,2);
		l1.add(2,3);
		l2.add(0,6);
		l2.add(1,7);
		
		l2.addAll(0,l1);
		
		l1.clear();
		
		for(int i=0;i<l2.size();i++) {
			String separator = ",";
			if(i==(l2.size()-1)) {
				separator = "";
			}
			System.out.print(l2.get(i) + separator);			
		}
		ArrayList<Integer> l3 = new ArrayList<Integer>(l2); 
		
		l3.add(0,-2);
		l3.add(1,-1);
		l3.add(2,0);
		System.out.println();
		for(int i=0;i<l3.size();i++) {
			String separator = ",";
			if(i==(l3.size()-1)) {
				separator = "";
			}
			System.out.print(l3.get(i) + separator);			
		}
		
		l3.add(7);
		System.out.println("\n"+l3.indexOf(7));
		System.out.println(l3.lastIndexOf(7));
		
		System.out.println(l3.clone());
		
		System.out.println(l3.contains(6));
		
		l3.ensureCapacity(30);
		System.out.println(l3.size());
		
		System.out.println(l3.isEmpty());
		
		System.out.println(l3.set(10,8));
		
		l3.remove(0);
				
		//l3.removeAll(l2);
		
		List<Integer> l4 = new ArrayList<Integer>();
		
		l4 = l3.subList(3, 7);

		for(int i=0;i<l4.size();i++) {
			String separator = ",";
			if(i==(l4.size()-1)) {
				separator = "";
			}
			System.out.print(l4.get(i) + separator);			
		}
		
		//toArray() returns an array of Object type
		//Object[] x = l4.toArray() so to convert it into an array of desirable type 
		//we must use the overloaded version
		
		System.out.println();
		Integer[] num = new Integer[l4.size()];
		
		l4.toArray(num);
		
		for(Integer n:num) {
			System.out.print(n + " ");
		}
		
		
	}
}