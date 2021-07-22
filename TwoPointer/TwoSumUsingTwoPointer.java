package com.divyansh.TwoPointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;

//this approach will work if duplicates exist in the array and you don't want to display duplicates
public class TwoSumUsingTwoPointer{
 
    public static void main(String[] args) {
    	int sum = 10;
        int[] arr = {1,1,2,2,4,4,4,5,5,5,6,6,7,8,8};
       twoSumUsingTwoPointer(arr, sum);     
    }
 
    public static void twoSumUsingTwoPointer(int[] a, int target) {
    	Arrays.sort(a);
        List<List<Integer>> result1 =  new LinkedList<>();
        List<List<Integer>> result2 =  new LinkedList<>();
        int i = 0, j = a.length - 1;
        while (i < j) {
            int sum = a[i] + a[j];
            if (sum == target) {
                while(a[i]==a[i+1])i++;
                while(a[j]==a[j-1])j--;
                result1.add(Arrays.asList(a[i], a[j]));
                result2.add(Arrays.asList(i,j));
                i++;
                j--;
            }
            if (sum < target) i++;
            else j--;
        }

        System.out.println(result2);
        System.out.println(result1);
        	
        return;
    }
    
    
}