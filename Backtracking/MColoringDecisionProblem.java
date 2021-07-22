package com.divyansh.Recursion.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class MColoringDecisionProblem {

	private static boolean isSafe(int node,List<Integer>[] G, int[] color,int m){
        for(int a:G[node]){
            if(color[a] == m)
                return false;
        }
        return true;
    }
    private static boolean solve(int node,List<Integer>[] G, int[] color,int n, int m){
        if(node == n) {
            return true;
        }       
        for(int i=1;i<=m;i++){
            if(isSafe(node,G,color,i)==true){
                color[node] = i;
                if(solve(node+1,G,color,n,m)==true)return true;
                color[node] = 0;
            }
        }
        return false;
    }
    public static boolean graphColoring(List<Integer>[] G, int[] color,int C) 
    {
        int n=G.length;
        if(solve(0,G,color,n,C)==true) return true;
        return false;
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
    	
    	int[] color = new int[V];
    	for(int i=0;i<color.length;i++) {
        	color[i] = 0;
    	}
    	boolean result = graphColoring(G,color,M);
    	System.out.println(result);
    }
}
