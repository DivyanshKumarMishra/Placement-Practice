package com.divyansh.sorting;

public class BubbleSort {

	public static void bubbleSort(int[] ar, int len) {
		
		boolean isSorted;
		for(int i=0;i<len-1;i++)                          //number of passes
		{   
			System.out.printf("\nWorking on pass %d",i+1);
			isSorted=true;
			for(int j=0;j<len-1-i;j++)                    //number of comparisons
			{
				if(ar[j]>ar[j+1]) {
					
					int temp = ar[j+1];
					ar[j+1] = ar[j];
					ar[j] = temp;
					isSorted=false;
				}
			}
			if(isSorted) {
				return;
			}
		}
		
	}
	public static void main(String [] args) {
		
		int[] ar = new int[] {23,4,56,7,8};
		int len = ar.length;
		System.out.println("Array before sorting: ");
		for(int num:ar) {
			System.out.print(num + " ");
		}
		bubbleSort(ar,len);
		System.out.println("Array after sorting: ");
		for(int num:ar) {
			System.out.print(num + " ");
		}
	}
}
