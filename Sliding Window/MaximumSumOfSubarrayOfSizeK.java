package com.divyansh.DSAPractice.SlidingWindow;

public class MaximumSumOfSubarrayOfSizeK {

	public static void main(String[] args) {
		
		int[] arr = {2,1,7,8,1,5,6,9};
		int windowsize = 3;
		int max = maximumSumOfSubarrayOfSizeK(arr,windowsize);
		System.out.println("Maximum suum is: " + max);
	}	
		
	public static int maximumSumOfSubarrayOfSizeK(int[] a, int k) {
		
		int max = Integer.MIN_VALUE;
		int current = 0;
		
		int i=0,j=0;
		while(j<a.length) {
			current = current + a[j];
			
			if(j-i+1<k) {
				j++;
			}
			else {
				max = Math.max(max, current);
				current = current-a[i];
				i++;
				j++;
			}
		}
		return max;
	}
}
