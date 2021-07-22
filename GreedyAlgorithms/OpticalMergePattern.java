package com.divyansh.GreedyAlgorithms;

import java.util.PriorityQueue;

public class OpticalMergePattern {
	
	public static int minimumComputation(int[] files) {
		
		//variable to store minimum computation
		int count = 0;
		
		//adding files to priority queue to create minimum heap
		PriorityQueue<Integer> pq = new PriorityQueue<>(files.length);
		
		//creating minimum heap
		for(int i=0;i<files.length;i++) {
			pq.add(files[i]);
		}
		
		while(pq.size()>1) {
			
			int sum = pq.poll() + pq.poll();
			count = count + sum;
			pq.add(sum);
		}		
		return count;
	}

	public static void main(String[] args) {
		
		int[] files = {20,30,10,5,30};
		int count = minimumComputation(files);
		System.out.println("Minimum computation is: " + count);
	}
}
