package com.divyansh.TreesAndGraphs;

public class BinaryTreeRecursiveTraversals {
 
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
	
	static void preorder(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data);
		preorder(root.left);
		preorder(root.right);
	}
	
	static void inorder(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data);
		inorder(root.right);
	}
	
	static void postorder(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data);
	}
	
	public static void main(String[] args) {
	
		TreeNode<Integer> first = new TreeNode<Integer>(4);
		TreeNode<Integer> second = new TreeNode<Integer>(5);
		TreeNode<Integer> third = new TreeNode<Integer>(6);
		TreeNode<Integer> four = new TreeNode<Integer>(7);
		TreeNode<Integer> fifth = new TreeNode<Integer>(8);
		
		first.left = second;
		first.right = third;
		second.left = four;
		third.right = fifth;
		
		TreeNode<Integer> root = first;
		
		preorder(root);
		System.out.println();
		inorder(root);
		System.out.println();
		postorder(root);
	}
}
