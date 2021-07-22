package com.divyansh.Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class PermutationOfString {
	
	private static List<String> solve(String S,int pos,int len,List<String> res){
        if(pos == len-1){
            res.add(S);
            return res;
        }   
        for(int i=pos;i<=len-1;i++){
        	 S = swap(S,pos,i);
             solve(S,pos+1,len,res);
             S = swap(S,pos,i);
        }
        return res;
    }
	public static String swap(String a, int i, int j) {  
        char[] b =a.toCharArray();  
        char ch;  
        ch = b[i];  
        b[i] = b[j];  
        b[j] = ch;  
        return String.valueOf(b);  
    }  
    public static List<String> find_permutation(String S) {
        List<String> res = new ArrayList<>();
        int pos = 0;
        int len = S.length();
        res = solve(S,pos,len,res);
        Collections.sort(res);
        return res;
    }
    
    public static void main(String[] args) {
    	List<String> res = new ArrayList<>();
    	String S = "ABC";
    	res = find_permutation(S);
    	for(String s:res) {
    		System.out.print(s + " ");
    	}
    }
}
