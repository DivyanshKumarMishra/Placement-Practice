package com.divyansh.Recursion.Backtracking;
import java.util.ArrayList;

public class TargetSum {
	
	private static void solve(int pos,int[] arr,
			ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list,int sum,int target){
		if(sum > target)
			return;
		else if(sum == target) {
			res.add(new ArrayList<>(list));
			return;
		}
		else if(pos == arr.length && sum<target) 
			return;
		if(sum == target && pos != arr.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		solve(pos+1,arr,res,list,sum,target);
		list.add(arr[pos]);
		solve(pos+1,arr,res,list,sum+arr[pos],target);
		list.remove(list.size()-1);
	}

	public static void main(String[] args) {
		int[] arr = {2,1,2,3};
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		int sum = 0;
		int target = 3;
		int pos = 0;		
		solve(pos,arr,res,list,sum,target);
		System.out.println(res);
	}
}
