package com.divyansh.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {
	
	static class Job{
		
		int id;
		int deadline,profit;
		
		Job(){}
		
		Job(int id,int deadline, int profit){
			
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}
	}
			
	//array list to store jobs sequenced
	static ArrayList<Integer>  jobs = new ArrayList<>();
	
	static int maxprofit = 0;
				
	public static void jobSequence(ArrayList<Job> a) {
		
		//sorting array list in descending order of profit
		Collections.sort(a,(b,c)->{
			if(b.profit>c.profit) return -1;
			else if(b.profit<c.profit) return 1;
			else return 0;
		});
		
		//finding maximum deadline
		int maxdead = 0;
		for(int i=0;i<a.size();i++) {
			if(a.get(i).deadline>maxdead)
				maxdead = a.get(i).deadline;
		}
		
		//array of free slots available
		boolean[] result = new boolean[maxdead];
		
		//iterating over jobs array list and finding a slot in boolean array 
		//and marking array slot true if found false
		for(int i=0;i<a.size();i++) {
			//searching free slot for job 
			for(int j=a.get(i).deadline-1;j>=0;j--) {
				//if found free slot
				if(result[j]==false) {
					result[j] = true;
					jobs.add(a.get(i).id);
					maxprofit = maxprofit + a.get(i).profit;
					break;
				}
			}
		}
		System.out.print("\nJobs performed: ");
		for(Integer c:jobs) {
			System.out.print(c + " ");
		}
		System.out.println("\nMaximum profit is: " + maxprofit);
	}

	public static void main(String[] args) {
		
		int[] id = {1,2,3,4};
		int[] dead = {4,1,1,1};
		int[] profit = {20,10,40,30};
		
		//creating an array list of jobs
		ArrayList<Job> a = new ArrayList<>(id.length);
		for(int i=0;i<id.length;i++) {
			a.add(new Job(id[i],dead[i],profit[i]));
		}
		
		System.out.printf("%-15s%-15s%-15s","Jobid","Deadline","Profit");
		for(int i=0;i<id.length;i++) {
			System.out.printf("\n%-15d%-15d%-15d",id[i],dead[i],profit[i]);
		}
		
		jobSequence(a);
	}
}
