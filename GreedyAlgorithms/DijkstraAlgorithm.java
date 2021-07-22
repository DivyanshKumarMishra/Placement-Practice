package com.divyansh.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

import com.divyansh.GreedyAlgorithms.GraphPrimAlgorithm.Edge;

public class DijkstraAlgorithm {
	
	static class Edge implements Comparable<Edge>
	{
	    private int dest;
	    private int weight;
	    
	    Edge(int dest, int weight) { 
	    	this.dest = dest; 
	    	this.weight = weight; 
	    }
	    
	    Edge() {}
	 
	    @Override
	    public int compareTo(Edge e) 
	    { 
	        if (this.weight < e.weight) 
	            return -1; 
	        if (this.weight > e.weight) 
	            return 1; 
	        return 0; 
	    } 
	}
	
	public static void shortestPath(ArrayList<ArrayList<Edge>> edges, int src)
    {
        int dist[] = new int[edges.size()];
        
        for(int i = 0;i<edges.size();i++) {
        	dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0; 
        
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.add(new Edge(src, 0));
        
        while(pq.size() > 0) {
            Edge ed = pq.poll();
            int u = ed.dest;
            
            for(Edge e: edges.get(u)) {
                if(dist[u] + e.weight < dist[e.dest]) {
                	 dist[e.dest] = dist[u] + e.weight; 
                    pq.add(new Edge(e.dest, dist[e.dest]));
                }
            }
        }        
        for (int i = 0; i < edges.size(); i++)
        {
            System.out.println( src + "->" + i + "=" + dist[i] );
        }
    }
	
    public static void main(String args[])
    {
    	int n=5;
		ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			edges.add(new ArrayList<Edge>());
		}
			
		edges.get(0).add(new Edge(1, 2));
		edges.get(1).add(new Edge(0, 2));
		
		edges.get(1).add(new Edge(2, 4));
		edges.get(2).add(new Edge(1, 4));
		
		edges.get(0).add(new Edge(3, 1));
		edges.get(3).add(new Edge(0, 1));
		
		edges.get(3).add(new Edge(2, 3));
		edges.get(2).add(new Edge(3, 3));
		
		edges.get(1).add(new Edge(4, 5));
		edges.get(4).add(new Edge(1, 5));
		
		edges.get(2).add(new Edge(4, 1));
		edges.get(4).add(new Edge(2, 1));
		
		shortestPath(edges,0); 
		
    }
}

