package com.divyansh.Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class MColoringOptimizationProblem {
	
	public static int graphColoring(List<Integer>[] G,int V) {
		int[] res = new int[V];
		boolean[] avail = new boolean[V];
		for(int i=0;i<V;i++) {
			res[i] = -1;
			avail[i] = true;
		}
		int cn = 0;
		res[0] = 0;
		for(int i=1;i<V;i++) {
			for(int x:G[i]) {
				if(res[x]!= -1) {
					avail[res[x]] = false;
				}
			}
			for(int j=0;j<V;j++) {
				if(avail[j] == true)
					res[i] = j;
			}
			
			cn = Math.max(cn, res[i]+1);
			for(int x:G[i]) {
				if(res[x]!= -1) {
					avail[res[x]] = true;
				}
			}			
		}
		return cn;
	}

	public static void main(String[] args) {
    	int V = 3;
    	int M = 2;    	
    	List<Integer>[] G = new ArrayList[V];
    	for(int i=0;i<V;i++) {
    		G[i] = new ArrayList<>();
    	}
    	G[0].add(1);
    	G[1].add(0);
    	G[0].add(2);
    	G[2].add(0);
    	G[1].add(2);
    	G[2].add(1);

    	int result = graphColoring(G,V);
    	System.out.println(result);
    }
}
