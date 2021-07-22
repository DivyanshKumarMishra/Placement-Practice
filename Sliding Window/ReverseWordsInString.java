package com.divyansh.DSAPractice.SlidingWindow;

import java.util.Scanner;

public class ReverseWordsInString {

public static void reverse(String s) {
		
		String s1 = s.trim();
		String[] arr = s1.split("\\s+");
		int len  = arr.length;
		String ans = "";
		for(int i=len-1;i>=0;i--) {
			if(ans.isEmpty()) {
				ans = ans + arr[i];
			}
			else {
				ans = ans + " " + arr[i];
			}
		}
		System.out.println("\"" + ans + "\"");
	}
	
	public static void main(String[] args) {
		
        System.out.println("Enter a string: ");
		Scanner sc = new Scanner(System.in);
		
		String s= sc.nextLine();
		reverse(s);
		
		
	}
}
