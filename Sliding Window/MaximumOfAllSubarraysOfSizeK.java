package com.divyansh.DSAPractice.SlidingWindow;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class MaximumOfAllSubarraysOfSizeK {

	public static void main(String[] args) {
		
		int[] arr = {1,3,-1,-3,5,3,6,7};
		int windowsize = 3;
		maximumOfAllSubarraysOfSizeK(arr,windowsize);
		
	}
	
	public static void maximumOfAllSubarraysOfSizeK(int[] a, int k) {
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		ArrayDeque<Integer> max = new ArrayDeque<Integer>();
		
		int i=0,j=0;
		while(j<a.length) {
	
			while(list.size()>0 && list.getLast()<a[j]) {       //pop elements less than a[j]
				list.removeLast();                              				
			}
			list.add(a[j]);                                     //push a[j] in the list 
			
			if(j-i+1<k) {
				j++;
			}
			else {
				max.addLast(list.getFirst());
				if(list.contains(a[i])) {
					list.removeFirst();
				}
					i++;
					j++;				
			}
		}
		System.out.println(max);
	}
}
