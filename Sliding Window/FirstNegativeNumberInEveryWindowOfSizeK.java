package com.divyansh.DSAPractice.SlidingWindow;

import java.util.LinkedList;

public class FirstNegativeNumberInEveryWindowOfSizeK {

	public static void main(String[] args) {
		int[] arr = {12,-1,-7,8,-15,30,16,8};
		int windowsize = 3;
		firstNegativeNumberInEveryWindowOfSizeK(arr, windowsize);
		
	}
	
	public static void firstNegativeNumberInEveryWindowOfSizeK(int[] a, int k){
		LinkedList<Integer> list = new LinkedList<Integer>();
		LinkedList<Integer> negatives2 = new LinkedList<Integer>();
		int i=0;
		int j=0;
		while(j<a.length) {
			if(a[j]<0) {
				list.add(a[j]);         //add negative numbers to list
			}
			if(j-i+1<k) {
				j++;
			}
			else {
				if(list.size()==0) {   //add 0 to list of negatives if window does not contain negative element
					negatives2.add(0);
					i++;
					j++;
				}
				else {
					negatives2.add(list.getFirst()); //add first element of list to list of negatives
					if(list.contains(a[i])) {  //if element in array exist in list remove its calculations
						list.removeFirst();
					}
					i++;
					j++;
				}				
			}
		}
		System.out.println(negatives2);
	}
}
