package com.divyansh.collections;

public class MyStack<E> {

	static class Node<E>{
		
		private E data;
		private Node next;
		private Node previous;
		
		Node(E data){
			this.data = data;
			this.next = null;
			this.previous= null;
		}
	}
	
	Node head;
	Node tail;
	
	void push(E data) {
		
		Node newnode = new Node<E>(data);
		
		if(head == null) {
			head = newnode;
			tail = newnode;
		}
		else {
			tail.next = newnode;
			newnode.previous = tail;
			tail = newnode;
		}
	}
	
	E pop() {
		
		E popped = null;
		if(tail == null)
			System.out.println("Stack is empty");
		else if(head == tail) {
			popped = (E) tail.data;
		}
		else {
			Node temp = tail;
			popped = (E) tail.data;
			tail = tail.previous;
			tail.next = null;
			temp.previous = null;
		}
		return popped;
	}
}
