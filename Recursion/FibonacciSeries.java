package com.divyansh.Recursion;
import  java.util.Scanner;

public class FibonacciSeries {
	
	public static int a=0,b=1;
	public static void fib(int n) {
		
		if(n>=1) {
			int c = a+b;
			System.out.print(c + " ");
			a=b;
			b=c;
			fib(n-1);
		}
	}

	public static void main(String [] args) {
		
		System.out.println("Enter the number of terms in series: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(a + " " + b + " ");
		fib(n-2);		
	}
}
