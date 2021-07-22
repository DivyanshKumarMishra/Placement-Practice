package com.divyansh.sorting;

import java.util.Scanner;

public class SelectionSort {
	
	public static void selectionSort(int[] a) {
		
		int len = a.length;
		int temp,indexmin;
		
		//array {22,4,6,12,20}
		//loop runs for n-1 passes
		System.out.println("\nRunning Selection sort...\n");
		for (int i = 0; i < len-1; i++)
	    {
	        indexmin = i;
	        for (int j = indexmin+1; j <=len-1; j++)
	        {
	            if(a[j] < a[indexmin]){
	                indexmin = j;
	            }
	        }
	        // Swap a[i] and a[indexMin]
	        temp = a[i];
	        a[i] = a[indexmin];
	        a[indexmin] = temp;
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
		
		selectionSort(arr);
		System.out.println("Array after sorting: ");
		for(int num:arr) {
			System.out.print( num + " " );
		}
	}
}
