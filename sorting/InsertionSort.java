package com.divyansh.sorting;

import java.util.Scanner;

public class InsertionSort {
	
	public static void insertionSort(int[] a) {
		
		//loop loop runs for n-1 passes
		int len = a.length;
		for(int i=1;i<=len-1;i++) {
			int key = a[i];
			int j = i-1;
			//loop for comparisons
			while(j>=0 && a[j]>key) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = key;
		}
	}

	public static void main(String[] args) {
		
		System.out.println("Enter the number of elements: ");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		
		int[] arr = new int[number];
		System.out.println("Enter the elements in array: ");
		
		for(int i=0;i<number;i++) {
			arr[i] = sc.nextInt(); 
		}
		
		System.out.println("Array before sorting: ");
		for(int num:arr) {
			System.out.print( num + " " );
		}
		
		insertionSort(arr);
		System.out.println("\nArray after sorting: ");
		for(int num:arr) {
			System.out.print( num + " " );
		}
	}
}
