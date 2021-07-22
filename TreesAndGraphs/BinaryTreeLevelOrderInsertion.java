package com.divyansh.TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrderInsertion {

	static class Node{
		
		int data;
		Node left;
		Node right;
		
		Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}		
	}
	
	static Node root;
	
	public static void inorder() {
		inorder(root);
	}
	
	private static void inorder(Node root)
    {
        if (root == null)
            return;
 
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

	public static void insert(int value) {
		
		if(root==null) {
			root = new Node(value);
			return;
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node temp;
			temp = q.peek();
			q.remove();
			
			if(temp.left==null) {
				temp.left = new Node(value);
				break;
			}
			else {
				 q.add(temp.left);
			}
			
			if(temp.right==null) {
				temp.right = new Node(value);
				break;
			}
			else {
				 q.add(temp.right);
			}
		}
	}
	
	public static void main(String args[]){
		
		BinaryTreeLevelOrderInsertion btree = new BinaryTreeLevelOrderInsertion();
		
		btree.insert(10);
		btree.insert(11);
		btree.insert(7);
		btree.insert(9);
		btree.insert(15);
		btree.insert(8);
		btree.insert(12);
		
		//{10,11,7,9,15,8,12}
 
        System.out.print(
            "Inorder traversal:");
        inorder();
    }
}
