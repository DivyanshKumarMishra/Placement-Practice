package com.divyansh.Recursion.Backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class SumOfSubsets {
	
	public static ArrayList<Integer> findsum(int index,int sum,ArrayList<Integer> arr,
			int N,ArrayList<Integer> sumsubset) {
		if(index == N) {
			sumsubset.add(sum);
			return sumsubset;
		}
		
		findsum(index+1,sum,arr,N,sumsubset);
		sum = sum+arr.get(index);
		findsum(index+1,sum,arr,N,sumsubset);
		sum = sum - arr.get(index);
		
		return sumsubset;
	}

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(3);
		arr.add(1);
		arr.add(2);
		
		ArrayList<Integer> sumsubset = new ArrayList<>();
		int N=arr.size();
		int index = 0;
		int sum = 0;
		sumsubset = findsum(index,sum,arr,N,sumsubset);
		Collections.sort(sumsubset);
		for(Integer i: sumsubset) {
			System.out.println(i);
		}
	}
}
