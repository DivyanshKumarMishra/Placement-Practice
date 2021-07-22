package com.divyansh.Recursion.Backtracking;

import java.util.List;
import java.util.ArrayList;

public class HamiltonianCyclePermutation {

	final int V = 5;
	int path[] = new int[V];
	
	private boolean isSafe(int[][] graph,int v, int pos, int[] path) {
		if(graph[path[pos-1]][v] == 0)
			return false;
		
		for(int i=0;i<V;i++) {
			if(path[i] == v)return false;
		}
		return true;
	}
	
	private List<List<Integer>> solve(int[][] graph,int pos, int[] path,List<List<Integer>> res,List<Integer> list) {
		if(pos == V) {
			if(graph[path[pos-1]][path[0]] == 1) {
				res.add(new ArrayList(list));
				return res;
			}
			else
				return res;
		}
		for(int v=1;v<V;v++) {
			if(isSafe(graph,v,pos,path)) {
				path[pos] = v;
				list.add(path[pos]);
				solve(graph,pos+1,path,res,list);
				path[pos] = -1;
				list.remove(list.size()-1);
			}
		}
		return res;
	}
	
	public List<List<Integer>> hamCycle(int[][] graph,List<List<Integer>> res,List<Integer> list) {
		
		for(int i=0;i<V;i++) path[i] = -1;		
		int pos = 1;
		path[0] = 0;
		list.add(path[0]);
		solve(graph,pos,path,res,list);
		return res;
	}

	public static void main(String args[])
    {
        HamiltonianCyclePermutation hamiltonian = new HamiltonianCyclePermutation();     
        int[][] graph = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0}};
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        res = hamiltonian.hamCycle(graph,res,list); 
        for(List<Integer> a:res) {
        	a.add(0);
        }
        System.out.println(res);
    }
}
