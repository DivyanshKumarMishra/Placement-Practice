package com.divyansh.Recursion.Backtracking;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SubSets {
	
	public static List<List<Integer>> subset_helper(int index,int[] nums,
			List<List<Integer>> subsets,List<Integer> list){
		
		if(index == nums.length) {
			subsets.add(new ArrayList<>(list));
			return subsets;
		}
		subset_helper(index+1,nums,subsets,list);
		list.add(nums[index]);
		subset_helper(index+1,nums,subsets,list);
		list.remove(list.size()-1);
		
		return subsets;
	}

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<List<Integer>>();
        
        if(nums == null || nums.length == 0)
            return subsets;
        
        Arrays.sort(nums);
     
		List<Integer> list = new ArrayList<>();
		int index = 0;
		subsets = subset_helper(index,nums,subsets,list);
        return subsets;
    }

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();

		int index = 0;
		subsets = subsets(arr);
		System.out.println(subsets);
	}
}
