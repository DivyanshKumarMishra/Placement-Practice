package com.divyansh.TreesAndGraphs;

import java.util.Scanner;

public class MyBinarySearchTree {

	static class TreeNode<Integer>{
		
		int data;
		TreeNode<Integer> left;
		TreeNode<Integer> right;
		
		TreeNode(int data){
			this.data = data;
			this.left = null;
			this.right = null;		
		}
	}
	
	private static TreeNode<Integer> root;
	
	public void insert(int value) {
		root = insert(root,value);
	}
	
	public TreeNode insert(TreeNode<Integer> root, int value) {
		
		if(root == null) {
			root = new TreeNode<Integer>(value);
			return root;
		}
		else if(value<root.data) {
			root.left = insert(root.left,value);
		} 
		else {
			root.right = insert(root.right,value);
		}
		return root;
	}
	
	void preorder(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	void inorder(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	void postorder(TreeNode<Integer> root) {
		if(root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}
	
	public TreeNode<Integer> search(int value) {
		return search(root, value);
	}
	
	public TreeNode<Integer> search(TreeNode<Integer> root,int value) {
		if(root == null) {
			return root;
		}
		else if(value == root.data) {
			return root;
		}
		else if(value<root.data) {
			return search(root.left,value);
		}
		else {
			return search(root.right, value);
		}
	}
	
	public static void main(String[] args) {
		
		MyBinarySearchTree btree = new MyBinarySearchTree();
		btree.insert(15);
		btree.insert(20);
		btree.insert(11);
		btree.insert(7);
		btree.insert(12);
		btree.insert(17);
		btree.insert(18);

		btree.preorder(root);
		System.out.println();
		btree.inorder(root);
		System.out.println();
		btree.postorder(root);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nEnter the value you want to search: ");
		int searchvalue = sc.nextInt();
		
		btree.search(searchvalue);
		
		if(btree.search(searchvalue) != null) {
			System.out.println("Value found");
		}
		else {
			System.out.println("Value not found");
		}
	}
}
