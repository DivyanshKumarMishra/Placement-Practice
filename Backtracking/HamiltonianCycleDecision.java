package com.divyansh.Recursion.Backtracking;

public class HamiltonianCycleDecision {
	
	final int V = 5;
	int path[] = new int[V];
	
	private boolean isSafe(int[][] graph,int v, int pos) {
		if(graph[path[pos-1]][v] == 0)
			return false;
		
		for(int i=0;i<V;i++) {
			if(path[i] == v)return false;
		}
		return true;
	}
	
	private boolean solve(int[][] graph,int pos) {
		if(pos == V) {
			if(graph[path[pos-1]][path[0]] == 1)
				return true;
			else
				return false;
		}
		for(int v=1;v<V;v++) {
			if(isSafe(graph,v,pos)) {
				path[pos] = v;
				if(solve(graph,pos+1) == true)return true;
				path[pos] = -1;
			}
		}
		return false;
	}
	
	public boolean hamCycle(int[][] graph) {
		
		for(int i=0;i<V;i++) path[i] = -1;		
		int pos = 1;
		path[0] = 0;
		if(solve(graph,pos)==true)return true;
		return false;
	}

	public static void main(String args[])
    {
        HamiltonianCycleDecision hamiltonian = new HamiltonianCycleDecision();     
        int[][] graph = {{0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0},
            };
        boolean result = hamiltonian.hamCycle(graph); 
        System.out.println(result);
    }
}
