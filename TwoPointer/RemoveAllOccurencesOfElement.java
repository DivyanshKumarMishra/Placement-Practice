package com.divyansh.TwoPointer;

public class RemoveAllOccurencesOfElement {

	public static int removeElement(int[] nums, int val) {
		int i=0;
		for(int j=0;j<nums.length;j++) {
			if(nums[j]!=val) {
				nums[i]=nums[j];
				i++;
			}
		}
		return i;
	}
	
	public static void main(String[] args) {
			
			int[] nums = {3,2,2,3};
			int val = 3;
			int k = removeElement(nums,val);
			for(int i=0;i<k;i++) {
				System.out.print(nums[i] + " ");
			}
		}
}
