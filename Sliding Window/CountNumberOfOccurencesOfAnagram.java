package com.divyansh.DSAPractice.SlidingWindow;

import java.util.Scanner;

public class CountNumberOfOccurencesOfAnagram {
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("enter first string: ");
		String s1 = sc.nextLine();
		System.out.println("enter second string: ");
		String s2 = sc.nextLine();
		countNumberOfOccurencesOfAnagram(s1,s2);
	}
	
	public static boolean isAnagram(int[] arr) {
		for(int index=0;index<arr.length;index++) {
			if(arr[index]!=0) {
				return false;
			}
		}	
		return true;
	}
	
	public static void countNumberOfOccurencesOfAnagram(String s1, String s2) {
		
		int count = 0;
		int k = s2.length();
		int[] arr = new int[256];

		for(int c=0;c<k;c++) {                    //loop to check 1st window is anagram
			arr[s1.charAt(c)]++;
			arr[s2.charAt(c)]--;
		}		
		if(isAnagram(arr)) {
			count++;
			System.out.println("Count is: " + count);
		}					
		
		for(int i=k;i<s1.length();i++) {         //loop to remove first element of window and 
				arr[s1.charAt(i)]++;             //add next element to window
				arr[s1.charAt(i-k)]--;	
				
				if(isAnagram(arr)) {
					count++;
					System.out.println("Count is: " + count);
				}
		}	
		System.out.println("Number of occurences of anagrams is: " + count);
	}
}