package com.divyansh.Recursion.Backtracking;

import java.util.List;
import java.util.ArrayList;

public class MColoringPermutationProblem {
	
	private static boolean isSafe(int node,List<Integer>[] G, int[] color,int m){
        for(int a:G[node]){
            if(color[a] == m)
                return false;
        }
        return true;
    }
    private static List<List<Integer>> solve(int node,List<Integer>[] G, int[] color,int n, int m,
    		List<List<Integer>> res, List<Integer> list){
        if(node == n) {
        	res.add(new ArrayList(list));
        	return res;
        }      
        for(int i=1;i<=m;i++){
            if(isSafe(node,G,color,i)){
                color[node] = i;
                list.add(color[node]);
                solve(node+1,G,color,n,m,res,list);  
                color[node] = 0;
                list.remove(list.size()-1);
            }
        }
        return res;
    }
    public static List<List<Integer>> graphColoring(List<Integer>[] G, int[] color,int C) 
    {
        int n = G.length;
        List<Integer> list  = new ArrayList<>();
        List<List<Integer>> res  = new ArrayList<>();
        res = solve(0,G,color,n,C,res,list);
        return res;
    }

    public static void main(String[] args) {
    	int V = 3;
    	int M = 3;    	
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
    	List<List<Integer>> res  = new ArrayList<>();
    	res = graphColoring(G,color,M);
    	System.out.print(res);
    }
}
