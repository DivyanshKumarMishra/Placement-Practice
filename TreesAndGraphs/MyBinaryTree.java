package com.divyansh.TreesAndGraphs;
import java.util.Scanner;

public class MyBinaryTree {

	static class TreeNode<Integer>{
		
		Integer data;
		TreeNode<Integer> left;
		TreeNode<Integer> right;	
		
		TreeNode(Integer data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	static TreeNode<Integer> root;
	
	public static TreeNode<Integer> create(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice(Y or N): ");
		String choice = sc.next();
		if(choice.equals("N") || choice.equals("n")) {
			return null;
		}
		System.out.println("Enter data: ");
		int data = sc.nextInt();
		root = new TreeNode<Integer>(data);
		root.left = create();
		root.right = create();
		return root;
	}
	
	public static void main(String[] args) {
		
		TreeNode<Integer> root;
		root = create();
	}	
}
