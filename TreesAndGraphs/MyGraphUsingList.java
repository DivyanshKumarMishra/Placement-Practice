package com.divyansh.TreesAndGraphs;

import java.util.ArrayList;
import java.util.Scanner;

public class MyGraphUsingList {
 
		private int vn;
		private ArrayList<ArrayList<Integer>> al;
		
		MyGraphUsingList(int num){
			this.vn = num;
			al = new ArrayList<ArrayList<Integer>>(vn);
			for(int i=0;i<vn;i++) {
				al.add(new ArrayList<Integer>());
			}
		}
		
		public void addEdge(int u, int v) {
			al.get(u).add(v);
			al.get(v).add(u);
		}
		
		public void printGraph() {
			for(int i=0;i<al.size();i++) {
				System.out.println("\nAdjacency list of vertex" + i);
	            System.out.print("head");
				for(int j=0;j<al.get(i).size();j++) {
					System.out.print(" -> "+al.get(i).get(j));
				}
				System.out.println();
			}
		}
		
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the number of vertices you want: ");
			int v = sc.nextInt();
			MyGraphUsingList graph = new MyGraphUsingList(v);
					
			graph.addEdge(0, 1);
			graph.addEdge(0, 4);
			graph.addEdge(1, 2);
			graph.addEdge(1, 3);
			graph.addEdge(1, 4);
			graph.addEdge(2, 3);
			graph.addEdge(3, 4);
			
			graph.printGraph();
		}	
}
