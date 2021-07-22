package com.divyansh.TwoPointer;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

//this approach will work if duplicates exist in the array and you don't want to display duplicates
public class ThreeSumUsingTwoPointer {

	public static void main(String[] args) {
		
        int[] arr = {-1,0,1,2,-1,-4};
        int sum = 0;
        threeSumUsingTwoPointer(arr,sum);
	}
       
        public static void threeSumUsingTwoPointer(int[] a,int target) {
        	
        	Arrays.sort(a);
        	List<List<Integer>> result = new LinkedList<>();
        	int i=0;
        	int lo = i+1;
        	int hi = a.length-1;
        	
        	for(i=0;i<a.length-2;i++) {
 
        		if(i==0 || a[i]>a[i-1]) {
        			int sum = target-a[i];
                	
            		while(lo<hi) {
            			
            			if(a[lo]+a[hi]<sum)
            				lo++;
            			else if(a[lo]+a[hi]>sum) 
            				hi--;
            			else {
            				result.add(Arrays.asList(a[i],a[lo],a[hi]));
            				
            				while(lo<hi && a[lo]==a[lo+1]) lo++;
            				while(lo<hi && a[hi]==a[hi-1]) hi--;
            				
            				lo++;
            				hi--;
            			}
            		}
        		}             	
        	}
        	if(result.size()==0) {
        		System.out.println("No such triplets");
        	}
        	for(i=0;i<result.size();i++) {
        		System.out.println(result.get(i));
        	}
        	return;
        }
}
