package com.divyansh.TreesAndGraphs;

public class MyAVLTree {

	static class AVLnode<Integer>{
		
		int data;
		int height;
		AVLnode<Integer> left;
		AVLnode<Integer> right;
		
		AVLnode(int data){
			this.data = data;
			this.height = 1;
		}
	}
	
	AVLnode<Integer> root;
	
	public static int height(AVLnode<Integer> node) {
		if(node == null)
			return 0;
		else
			return node.height;
	}
	
	public static int BalancingFactor(AVLnode<Integer> node) {
		if(node == null) {
			return 0;
		}
		return height(node.left) - height(node.right);
	}
	
	public void insert(int value) {
		root = insert(root,value);
	}
	
	public AVLnode<Integer> insert(AVLnode<Integer> root, int value) {
			
			if(root == null) {
				root = new AVLnode<Integer>(value);
				return root;
			}
			else if(value == root.data)
				return root;
			
			else if(value<root.data) {
				root.left = insert(root.left,value);
			} 
			else {
				root.right = insert(root.right,value);
			}
			
			//height update of root
			root.height = Math.max(height(root.left), height(root.right)) + 1;
			
			//calculating balancing factor of every node in upward traversal
			int bf = BalancingFactor(root); 
			
			//Left-left case so right-rotate
			if(bf>1 && value < root.left.data) {
				return rightRotate(root);
			}
			
			//right-right case so left-rotate
			if(bf<-1 && value > root.right.data) {
				return leftRotate(root);
			}
			
			//left-right case so first left-rotate then right-rotate
			if(bf>1 && value > root.left.data) {
				root.left = leftRotate(root.left);
				return rightRotate(root);
			}
			
			//right-left case so first right-rotate then left-rotate
			if(bf<-1 && value < root.right.data) {
				root.right = rightRotate(root.right);
				return leftRotate(root);
			}		
			
			return root;
	}
	
	//Left-Left case so right-rotate
	public static AVLnode<Integer> rightRotate(AVLnode<Integer> c) {
		
		AVLnode<Integer> b = c.left;
		AVLnode<Integer> T3 = b.right;
		
		b.right = c;
		c.left = T3;
		
		//height update
		c.height = Math.max(height(c.left),height(c.right)) + 1;
		b.height = Math.max(height(b.left),height(b.right)) + 1;
		
		return b;
	}
	
	//right-right case so left-rotate
	public static AVLnode<Integer> leftRotate(AVLnode<Integer> c) {
			
			AVLnode<Integer> b = c.right;
			AVLnode<Integer> T3 = b.left;
			
			b.left = c;
			c.right = T3;
			
			//height update
			c.height = Math.max(height(c.left),height(c.right)) + 1;
			b.height = Math.max(height(b.left),height(b.right)) + 1;
			
			return b;
		}
	
	public void preorder() {
		preorder(root);
	}
	
	void preorder(AVLnode<Integer> root) {
		if(root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public void inorder() {
		inorder(root);
	}
	
	void inorder(AVLnode<Integer> root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	public void postorder() {
		postorder(root);
	}
	
	void postorder(AVLnode<Integer> root) {
		if(root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}
	
	public static void main(String[] args) {
		
		MyAVLTree tree = new MyAVLTree();
		
		tree.insert(20);
		tree.insert(25);
		tree.insert(30);
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(27);
		tree.insert(19);
		tree.insert(16);

		tree.preorder();
		System.out.println();
		tree.inorder();
		System.out.println();
		tree.postorder();
	}
}
