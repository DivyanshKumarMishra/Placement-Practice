package com.divyansh.collections;

import com.divyansh.collections.MyLinkedList.Node;

public class DoublyLinkedList<E> {

	static class Node<E>{
		
		private E data;
		private Node next;
		private Node previous;
		
		Node(E data){
			
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}
	
	Node head;
	Node tail;
	int size;
	
	public void size() {
			if(head==null) {
				size = 0;
			}
			else {
				while(tail!=null) {
					size++;
				}
			}
		}
	
	public void addFirst(E data) {
			
			Node<E> Newnode = new Node<E>(data);
			
			if(head==null) {
				head = Newnode;
				tail = Newnode;
			}
			else {
				Newnode.next = head;
				head = Newnode;
			}	
	}
	
	public void addLast(E data) {
			
			Node<E> Newnode = new Node<E>(data);
			
			if(head==null)
			{
				addFirst(data);
			}
			else {
				tail.next = Newnode;
				tail = Newnode;
			}
	}
	
	public void addPosition(int position,E data) {
		int i=1;
		Node<E> current = head;
		Node<E> Newnode = new Node<>(data);
		if(position<1 && position >size+1) {
			return;
		}
		else if(position==size+1) {
			addLast(data);
		}
		else if(position==1){
			addFirst(data);
		}
		else {
			while(i<position-1) {
				current = current.next;
				i++;
			}
			Newnode.previous = current;
			Newnode.next = current.next;
			current.next = Newnode;
			Newnode.next.previous = Newnode;
		}
	}
	
	public void removeFirst() {
		if(head == null) {
			return;
		}
		else if(size==1) {
			head = null;
			tail = null;
		}
		else{
			head = head.next;
			head.previous = null;
		}
	}
	
	public void removeLast() {
		
		if(head == null) {
			return;
		}
		else {
			tail = tail.previous;
			tail.next = null;
		}
	}
	
	void removePosition(int position) {
		Node<E> current = head;
		if(head == null) {
			return;
		}
		else if(position<1 || position>size)
			return;
		else if(position==1) {
			removeFirst();
		}
		else {
			int i=1;
			while(i<position) {
				current = current.next;
				i++;
			}
			current.previous.next  = current.next;
			current.next.previous = current.previous;
			current.previous = null;
			current.next = null;
		}
	}

	public void reverse() {
		Node<E> current = head;
		Node<E> nextnode;
		
		while(current!=null) {
			nextnode = current.next;
			current.next = current.previous;
			current.previous = nextnode;
			current = current.previous;
		}
	}
}
