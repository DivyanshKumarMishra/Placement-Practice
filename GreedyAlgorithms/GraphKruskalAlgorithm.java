package com.divyansh.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Collections;

public class GraphKruskalAlgorithm {

	static int v;
	static int e;
	
	static class Edge implements Comparable<Edge>{
		
		int src;
		int dest;
		int weight;
		
		Edge(){
			
		}		
		Edge(int src,int dest,int weight){
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
		
		public int compareTo(Edge e) {
			Edge edge = (Edge)e;
			if(this.weight<edge.weight) return -1;
			else if(this.weight>edge.weight)return 1;
			else return 0;
		}
	}
	
	static ArrayList<Edge> edges = new ArrayList<>();
	
	GraphKruskalAlgorithm(){
		
	}
	GraphKruskalAlgorithm(int v,int e){
		this.v = v;
		this.e = e;
	}
	
	public static int findParent(int i,int[] parent) {
		if(i==parent[i])
			return i;
		int par = findParent(parent[i],parent);
		return par;
	}
	
	public static void union(int src,int dest,int[] parent,int[] rank) {
		
		int srcpar = findParent(src,parent);
		int destpar = findParent(dest,parent);

			if(rank[srcpar]>rank[destpar]) {
				parent[destpar] = srcpar;
			}
			else if(rank[srcpar]<rank[destpar]) {
				parent[srcpar] = destpar;
			}
			else {
				parent[destpar] = srcpar;
				rank[srcpar]++;
			}	
	}
	
	public static void KruskalAlgoMST() {
		
		int[] parent = new int[v];
		int[] rank = new int[v];
		
		for(int i=0;i<v;i++) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		int minweight = 0;
		ArrayList<Edge> mst = new ArrayList<>(v-1);
		
		Collections.sort(edges);
		for(Edge e:edges) {
			if(findParent(e.src,parent)!=findParent(e.dest,parent)) {
				minweight += e.weight;
				mst.add(e);
				union(e.src,e.dest,parent,rank);
			}
		}
		for(Edge e:mst) {
			System.out.println(e.src + "--" + e.dest + "->" + e.weight);
		}
		System.out.println("Minimum Weight is: " + minweight);
		for(int i=0;i<parent.length;i++) {
			System.out.println(i+"->" + parent[i]);
		}
	}
	
	public static void main(String[] args) {
		
		GraphKruskalAlgorithm graph = new GraphKruskalAlgorithm(4,5);
		
		edges.add(new Edge(0,1,10));
		edges.add(new Edge(0,2,6));
		edges.add(new Edge(0,3,5));
		edges.add(new Edge(1,3,15));
		edges.add(new Edge(2,3,4));
		
		KruskalAlgoMST();
	}
}
