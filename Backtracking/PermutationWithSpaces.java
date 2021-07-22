package com.divyansh.Recursion.Backtracking;

public class PermutationWithSpaces {
	
	public static void permutationspaces(String ip, String op) {
		
		if(ip.length()==0) {
			System.out.println(op);
			return;
		}		
		String op1 = op + ip.substring(0,1);
		String op2 = op + "_" + ip.substring(0,1);
		
		ip = ip.substring(1);
		permutationspaces(ip,op1);
		permutationspaces(ip,op2);
	}
	public static void main(String[] args) {
		
		String ip = "abc";
		String op = "";
		op = op + ip.charAt(0);
		ip = ip.substring(1);
		permutationspaces(ip,op);
	}

}
