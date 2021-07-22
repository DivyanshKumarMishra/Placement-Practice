package com.divyansh.GreedyAlgorithms;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanCoding {
	
	static class HuffmanNode implements Comparable<HuffmanNode>{
		
		int freq;
		char c;
		HuffmanNode left;
		HuffmanNode right;
		
		HuffmanNode(){
			
		}		
		HuffmanNode(int freq, char c){
			this.freq = freq;
			this.c = c;
			this.left = null;
			this.right = null;
		}
		
		public int compareTo(HuffmanNode node) {
			return freq - node.freq;
		}
	}
	
	static HashMap<Character, String> codes = new HashMap<>();
	
	public static HuffmanNode buildTree(HashMap<Character,Integer> freq) {
		
		//set characters in PRIORITY QUEUE
		PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(freq.size());
		for(Character ch:freq.keySet()) {
			HuffmanNode hn = new HuffmanNode(freq.get(ch),ch);  
			pq.add(hn);
		}	
		//build a huffman tree from PRIORITY QUEUE by adding characters with minimum 
		//frequency and adding the sum of characters to PRIORITY QUEUE
		
		HuffmanNode root = new HuffmanNode();
		while(pq.size()>1) {
			HuffmanNode x = pq.peek();
			pq.poll();
			HuffmanNode y = pq.peek();
			pq.poll();			
			HuffmanNode sum = new HuffmanNode();			
			sum.freq = x.freq+y.freq;
			sum.c = ' ';
			sum.left = x;
			sum.right = y;
			root = sum;
			
			pq.add(sum);
		}
		return root;
	}

	private static void setCodes(HuffmanNode root, String code) {

		if (root != null) {
			if (root.left == null && root.right == null) {
				codes.put(root.c,code);
				return;
			} 
			else {
				setCodes(root.left, code + '0');
		        setCodes(root.right, code + '1');
			}
		}		
	}

	public static void encode(String s) {
		
		//calculate frequency of every character
		HashMap<Character, Integer> freq = new HashMap<>();
		char[] c = s.toCharArray();
		int count=1;
		for(int i=0;i<c.length;i++) {
			if(!freq.containsKey(c[i])) {
				freq.put(c[i],count);
			}else {
				freq.replace(c[i], freq.get(c[i])+1);
			}			
		}	
		System.out.println("Character Frequency Map = " + freq);
		HuffmanNode root = buildTree(freq);
		setCodes(root, "");
		
		System.out.println("Character Prefix Map = " + codes);
	}
	
	public static void main(String [] args) {
		
		String s = "abbcccdddd";
		System.out.println("Text:" + s);
		encode(s);
		
		String encoded = "";
		
		for(Character c:codes.keySet()) {
			encoded  = encoded + codes.get(c);
		}
		System.out.println("encoded text: " + encoded);
	}
}
