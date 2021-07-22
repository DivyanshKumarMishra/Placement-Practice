package com.divyansh.DSAPractice;

import java.util.HashMap;

public class CountNumberOfOccurences {

	public static void countUsinghHashMap(String s) {
		
		HashMap<Character, Integer> freq = new HashMap<>();
		String lower = s.toLowerCase();
		char[] c = lower.toCharArray();
		int count=1;
		for(int i=0;i<c.length;i++) {
			if(!freq.containsKey(c[i])) {
				freq.put(c[i],count);
			}else {
				freq.replace(c[i], freq.get(c[i])+1);
			}			
		}
		System.out.println("Character frequency using HashMap: " + freq);
	}
	
	public static void countUsingArrayList(String s) {
		
		int[] arr = new int[256];
		String lower = s.toLowerCase();
		char[] c = lower.toCharArray();
		for(int i=0;i<c.length;i++) {
			arr[c[i]]++;
		}
		System.out.print("Character frequency using array: ");
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>0) {
				System.out.print((char)i + "=" + arr[i] + " ");
			}
		}
	}
	
	public static void main(String [] args) {
			
			String s = "abbcccdddd";
			System.out.println("Text:" + s);
			
			countUsinghHashMap(s);
			countUsingArrayList(s);
	}
}
