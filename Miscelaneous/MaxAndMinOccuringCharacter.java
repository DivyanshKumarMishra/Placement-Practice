package com.divyansh.DSAPractice;

import java.util.HashMap;

public class MaxAndMinOccuringCharacter {

public static void countUsinghHashMap(String s) {
		
		HashMap<Character, Integer> freq = new HashMap<>();
		char[] c = s.toCharArray();
		int count=1;
		for(int i=0;i<c.length;i++) {
			if(!freq.containsKey(c[i])) {
				freq.put(c[i],count);
			}else {
				freq.replace(c[i], freq.get(c[i])+1);
			}			
		}
		System.out.println("Character frequency using HashMap: " + freq);
		int maxcount = 0;
		char maxchar = ' ';
		int mincount = freq.get(c[0]);
		char minchar = c[0];
		for(Character ch:freq.keySet()) {
			if(freq.get(ch)>maxcount) {
				maxcount = freq.get(ch);
				maxchar = ch;
			}
			if(freq.get(ch)<mincount) {
				mincount = freq.get(ch);
				minchar = ch;
			}
		}
		System.out.println("Max Character and count: " + maxchar +" " + maxcount);
		System.out.println("Min Character and count: " + minchar +" " + mincount);
	}
	
	public static void countUsingArrayList(String s) {
		
		int[] arr = new int[256];
		char[] c = s.toCharArray();
		for(int i=0;i<c.length;i++) {
			arr[c[i]]++;
		}
		System.out.print("Character frequency using array: ");
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>0) {
				System.out.print((char)i + "=" + arr[i] + " ");
			}
		}
		int maxcount = -1;
		char maxchar = ' ';
		int mincount = arr[c[0]];
		char minchar = c[0];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>maxcount) {
				maxcount = arr[i];
				maxchar = (char)i;
			}
			if(arr[i]<mincount && s.indexOf((char)i)>0) {
				mincount = arr[i];
				minchar = (char)i;
			}
		}
		System.out.println("\nMax Character and count: " + maxchar +" " + maxcount);
		System.out.println("Min Character and count: " + minchar +" " + mincount);
		
	}
	
	public static void main(String [] args) {
			
			String s = "ABRACADABRA";
			System.out.println("Text:" + s);
			
			countUsinghHashMap(s);
			countUsingArrayList(s);		
	}
}
