package com.divyansh.DynamicProgramming;

public class FloydWarshalAllPairShortestPath {

	public static int[][] floydwarshall(int[][] graph,int V)
	{
		int[][] dist = new int[V][V];

		//Assign all values of graph to allPairs_SP
		for(int i=0;i<V;++i)
			for(int j=0;j<V;++j)
				dist[i][j] = graph[i][j];

		//Find all pairs shortest path by trying all possible paths
		for(int k=0;k<V;++k) {	//Try all intermediate nodes
			for(int i=0;i<V;++i) {	//Try for all possible starting position
				for(int j=0;j<V;++j)	//Try for all possible ending position
				{
					if(dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE)	//SKIP if K is unreachable from i or j is unreachable from k
						continue;
					else if(dist[i][k]+dist[k][j] < dist[i][j])		//Check if new distance is shorter via vertex K
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
		//Check for negative edge weight cycle
		for(int i=0;i<V;++i) {
			if(dist[i][i] < 0)
			{
				System.out.println("Negative edge weight cycle is present\n");
			}
		}	
		return dist;
	}
	public static void  main(String[] args)
	{
		int V=4;
		int[][] graph = { 	{0,3,Integer.MAX_VALUE,5},
							{2,0,Integer.MAX_VALUE,8},
							{Integer.MAX_VALUE,1,0,Integer.MAX_VALUE},
							{Integer.MAX_VALUE,Integer.MAX_VALUE,2,0}};

		int[][] dist = floydwarshall(graph,V);
		//Print Shortest Path Graph
		//(Values printed as INT_MAX defines there is no path)
		for(int i=0;i<V;++i)
		{
			for(int j=0;j<V;++j)
				System.out.println(i + " to " + j + " distance is " + dist[i][j] + "\n");
			System.out.println("=================================\n");
		}
	}
}
