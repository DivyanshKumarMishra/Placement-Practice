package com.divyansh.Recursion;

import java.util.ArrayList;

public class BalancedParenthesis {

	public static ArrayList<String> generateparenthesis(int n, String op){
		ArrayList<String> res = new ArrayList<>();
		int open = n;
		int close = n;
		solve(res,open,close,op);
		return res;
	}
	
	public static void solve(ArrayList<String> res, int open,int close,String op) {
		if(open ==0 && close == 0) {
			res.add(op);
			return;
		}
		
		if(open!=0) {
				String op1 = op + "(";
				solve(res,open-1,close,op1);
		}
		
		if(close>open) 
		{
			String op2 = op + ")";
			solve(res,open,close-1,op2);
		}
	}
	public static void main(String[] args) {
		int n=3;
		String op = "";
		ArrayList<String> res = new ArrayList<>();
		res = generateparenthesis(n,op);
		for(String s:res) {
			System.out.println(s);
		}
	}
}
