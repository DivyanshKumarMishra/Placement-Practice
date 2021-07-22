package com.divyansh.DSAPractice;

import java.util.Scanner;

public class CheckAnagramString {
	
	public static void checkAnagram(String s1, String s2) {
		
		int[] ascii = new int[256];
		boolean isAnagram = true;
		
		for(char c: s1.toCharArray()) {
			int index = (int) c;
			ascii[index]++;
		}
		
		for(char c: s2.toCharArray()) {
			int index = (int) c;
			ascii[index]--;
		}
		
		for(int i=0;i<=255;i++) {
			if(ascii[i]!=0) {
				isAnagram = false;
				break;
			}
		}
		
		if(isAnagram) {
			System.out.println("Anagram");
		}
		else {
			System.out.println("Not Anagram");
		}
	}

	public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
	        System.out.println("Enter first string: ");
			String s1 = sc.nextLine();
			
	        System.out.println("Enter second string: ");
			String s2 = sc.nextLine();
			
			checkAnagram(s1,s2);	
		}
}
