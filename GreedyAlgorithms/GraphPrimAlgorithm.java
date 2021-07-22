package com.divyansh.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GraphPrimAlgorithm {
	
	static class Edge implements Comparable<Edge>{
		
		int dest;
		int weight;
		
		Edge(){
			
		}
		Edge(int dest,int weight){
			this.dest = dest;
			this.weight = weight;
		}
		
		public int compareTo(Edge e) {
			Edge edge = (Edge)e;
			if(this.weight<edge.weight)return -1;
			else if(this.weight>edge.weight)return 1;
			else return 0;
		}	
	}
	
	public static void PrimAlgorithm(ArrayList<ArrayList<Edge>> edges) {
		
		int key[] = new int[edges.size()];
		boolean[] MST = new boolean[edges.size()];
		int[] parent = new int[edges.size()];
		
		//initializing arrays
		for(int i=0;i<edges.size();i++) {
			key[i] = Integer.MAX_VALUE;
			MST[i] = false;
			parent[i] = -1;
		}
		
		//using Priority Queue to store minimal weights
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		key[0] = 0;
		pq.add(new Edge(0,key[0]));
		int mincost=0;
		
		//storing V-1 edges in the MST
		for(int i=0;i<edges.size();i++) {
			
			//getting minimal weight edge from priority queue
			Edge ed = pq.poll();
			int u = ed.dest;
			mincost = mincost + ed.weight;
			MST[u] = true;
			
			//searching adjacent nodes of minimal value 
			for(Edge e:edges.get(u)) {
				if(MST[e.dest] == false && e.weight<key[e.dest]) {
					parent[e.dest] = u;
					key[e.dest] = e.weight;
					pq.add(new Edge(e.dest,e.weight));
				}
			}
		}
		for(int i=1;i<edges.size();i++) {
			System.out.println(i + "->" + parent[i]);
		}
		
		System.out.println("Minimum cost is: " + mincost);
	}

	public static void main(String[] args) {
		
		int n=5;
		ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			edges.add(new ArrayList<Edge>());
		}
		
		//dummy graph
		edges.get(0).add(new Edge(1,2));
		edges.get(1).add(new Edge(0,2));
		
		edges.get(0).add(new Edge(3,6));
		edges.get(3).add(new Edge(0,6));
		
		edges.get(1).add(new Edge(4,5));
		edges.get(4).add(new Edge(1,5));
		
		edges.get(1).add(new Edge(2,3));
		edges.get(2).add(new Edge(1,3));
		
		edges.get(2).add(new Edge(4,7));
		edges.get(4).add(new Edge(2,7));
		
		edges.get(1).add(new Edge(3,8));
		edges.get(3).add(new Edge(1,8));
		
		PrimAlgorithm(edges);
	}
}
