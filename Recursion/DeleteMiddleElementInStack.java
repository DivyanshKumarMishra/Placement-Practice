package com.divyansh.Recursion;

import java.util.Stack;

public class DeleteMiddleElementInStack {
	
	public static void solve(Stack<Integer> s, int k) {

		if(k==1) {
			s.pop();
			return;
		}
		int temp = s.peek();
		s.pop();
		solve(s,k-1);
		s.push(temp);
		return;
	}
	
	public static void midDelete(Stack<Integer> s) {

		if(s.size() == 0)
			return;
		int k = (s.size()/2) + 1;
		solve(s,k);
	}

	public static void main(String[] args) {
		
		Stack<Integer> s1 = new Stack<Integer>();
		s1.push(1);
		s1.push(2);
		s1.push(3);
		s1.push(4);
		s1.push(5);

		midDelete(s1);
		
		while(s1.size()!=0) {
			int n = s1.peek();
			s1.pop();
			System.out.print(n + " ");
		}
		System.out.println();
		
	}
}
