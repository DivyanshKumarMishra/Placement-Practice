package com.divyansh.Recursion.Backtracking;

public class PermuteLetterCaseChange {

	public static void permute(String ip, String op) {
		
		if(ip.length() == 0) {
			System.out.println(op);
			return;
		}
		
		 if(Character.isLetter(ip.charAt(0))){
             String op1 = op + ip.substring(0,1).toLowerCase();
             String op2 = op + ip.substring(0,1).toUpperCase();
             ip = ip.substring(1);
             permute(ip,op1);
             permute(ip,op2);
        }
        else{
            String op3 = op + ip.substring(0,1); 
            ip = ip.substring(1);
            permute(ip,op3);
        }
	}
	
	public static void main(String[] args) {
		String ip = "a1B2";
		String op = "";
		permute(ip,op);
	}
}
