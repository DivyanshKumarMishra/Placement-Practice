package com.divyansh.Recursion;

import java.util.Scanner;

public class NthFibonacciTerm {
	
	public static int fib(int n) {
		
		if(n<=1) 
			return n;
		return fib(n-1) + fib(n-2);
	}

	public static void main(String [] args) {
			
			System.out.println("Enter the term of series you want: ");
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			System.out.print(fib(n));		
		}
}
