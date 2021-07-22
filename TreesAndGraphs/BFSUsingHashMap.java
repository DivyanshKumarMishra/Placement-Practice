package com.divyansh.TreesAndGraphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayDeque;

class MyBFSGraphUsingHashMap<E>{
	
	private HashMap<E,List<E>> map;
	
	MyBFSGraphUsingHashMap(){
		map = new HashMap<>();
	}
	
	public void addEdge(E source, E destination, boolean bidirection) {
		
		if(!map.containsKey(source)) {
			map.put(source, new LinkedList<>());
		}			
		if(!map.containsKey(destination)){
			map.put(destination,new LinkedList<>());
		}			
		map.get(source).add(destination);
		
		if(bidirection == true)
			map.get(destination).add(source);
	}
	
	public void dfs(E src) {

		HashMap<E, Boolean> visited = new HashMap<>(map.size()); 
		
		for(E key: map.keySet()) {
			visited.put(key,false);
		}
		
		dfs_helper(src, visited);
	}
	
	public void dfs_helper(E src, HashMap<E,Boolean> visited) {
		
		System.out.print("->" + src);
		visited.replace(src, true);
		
		for(int i=0;i<map.get(src).size();i++) {
			E n = map.get(src).get(i);
			if(visited.get(n) == false) {
				dfs_helper(n,visited);
			}
		}
	}
	
	void bfs(E src) {
				
		HashMap<E, Boolean> visited = new HashMap<>(map.size()); 
				
		for(E key: map.keySet()) {
			visited.put(key,false);
		}
		
		bfs_helper(src,visited);
	}
	
	void bfs_helper(E src, HashMap<E,Boolean> visited) {
		
		ArrayDeque<E> ad = new ArrayDeque<>();
		ad.add(src);
		visited.replace(src, true);
		
		while(ad.size()!=0) {
			
			E s = ad.poll();
			System.out.print("->"+ s);
					
			for(int i=0; i<map.get(s).size();i++) {
				E n = map.get(s).get(i);
				
				if(visited.get(n) == false) {
					visited.replace(n, true);
					ad.add(n);
				}
			}
		}
	}
}

public class BFSUsingHashMap {

	public static void main(String[] args) { 
		
		MyBFSGraphUsingHashMap<Integer> graph = new MyBFSGraphUsingHashMap<>();
		
		graph.addEdge(0, 4,true);
		graph.addEdge(1, 2,true);
		graph.addEdge(1, 3,true);
		graph.addEdge(1, 4,true);
		graph.addEdge(2, 3,true);
		graph.addEdge(3, 4,true);
		
		graph.bfs(0);
	}	
}
