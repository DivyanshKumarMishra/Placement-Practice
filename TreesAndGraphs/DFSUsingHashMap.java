package com.divyansh.TreesAndGraphs;

import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

class MyGraphUsingHashMap<E>{
		
	private Map<E,List<E>> map;
	
	MyGraphUsingHashMap(){
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

		Map<E, Boolean> visited = new HashMap<>(map.size()); 
		
		for(E key: map.keySet()) {
			visited.put(key,false);
		}
		
		dfs_helper(src, visited);
	}
	
	public void dfs_helper(E src, Map<E,Boolean> visited) {
		
		System.out.print("->" + src);
		visited.replace(src, true);
		
		for(int i=0;i<map.get(src).size();i++) {
			E n = map.get(src).get(i);
			if(visited.get(n) == false) {
				dfs_helper(n,visited);
			}
		}
	}
}

public class DFSUsingHashMap{
		
	public static void main(String[] args) {
	
		MyGraphUsingHashMap<Integer> graph = new MyGraphUsingHashMap<>();
		
		graph.addEdge(0,1,true);
		graph.addEdge(0,2,true);
		graph.addEdge(1,2,true);
		graph.addEdge(2,0,true);
		graph.addEdge(2,3,true);
		graph.addEdge(3,3,true);
		
		graph.dfs(2);
		System.out.println();
		graph.dfs(0);
	}
}
	
