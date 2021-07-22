package com.divyansh.DSAPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//this approach will work if duplicates don't exist in the array and you don't want to display duplicates
public class TwoSumUsingHashMap {
	
	public static void main(String[] args) {
    	int sum = 14;
        int[] arr = {2,6,5,8,11};
        twoSumUsingHashMap(arr, sum);      
    }
	
	public static void twoSumUsingHashMap(int[] a, int target) {
    	List<List<Integer>> result1 = new LinkedList<>();
    	List<List<Integer>> result2 = new LinkedList<>();
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i<a.length;i++){
        	int compliment = (target - a[i]);
        	if(map.containsKey(compliment)) {
        		 result1.add(Arrays.asList(map.get(compliment),i));
        		 result2.add(Arrays.asList(compliment,a[i]));
        	}
        	else {
        		map.put(a[i], i);
        		System.out.println(map);
        	}  
        }
        System.out.println(result1);
        System.out.println(result2);
        
        return;
    }
}
