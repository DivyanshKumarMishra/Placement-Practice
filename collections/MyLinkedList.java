package com.divyansh.collections;

public class MyLinkedList<E> {
	
	static class Node<E> {
		private E data;
		private Node next;
		
		Node(E data){
			this.data = data;
			this.next = null;
		}
	}
	
	Node<E> head;
	
	void addFirst(E data) {
		
		Node<E> Newnode = new Node<E>(data);
		
		if(head==null) {
			head = Newnode;
		}
		else {
			Newnode.next = head;
			head = Newnode;
		}	
	}
	
	void addLast(E data) {
		
		Node<E> temp = head;
		
		Node<E> Newnode = new Node<E>(data);
		
		while(temp.next!=null) {
			temp = temp.next;
		}
		temp.next = Newnode;
	}
	
	void addPosition(int position,E data) {
		int i=1;
		Node<E> temp = head;
		Node<E> Newnode = new Node<>(data);
		while(i<position-1) {
			temp = temp.next;
			i++;
		}
		Newnode.next = temp.next;
		temp.next = Newnode;	
	}
	
	public void removeFirst() {
		if(head == null) {
			return;
		}
		else {
			Node<E> current = head;
			head = current.next;
		}
	}
	
	public void removeLast() {
		
		if(head == null) {
			return;
		}
		else {
			Node<E> current = head;
			Node<E> previous = head;
			while(current.next!= null) {
				previous = current;
				current = current.next;
			}
			if(current == head) {
				head = null;
			}
			else {
				previous.next = null;
			}
		}
	}
	
	void removePosition(int position) {
		Node<E> current = head;
		Node<E> nextnode = null;
		if(head == null) {
			return;
		}
		else {
			int i=1;
			while(i<position-1) {
				current = current.next;
				i++;
			}
			nextnode = current.next;
			current.next = nextnode.next;
		}
	}
	
	void get() {
		Node<E> temp = head;
		while(temp!= null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	void reverse() {
		Node<E> previous = null;
		Node<E> current = head;
		Node<E> nextnode = null;
		if(head==null) {
			return;
		}
		while(current!=null) {
			nextnode = current.next;
			current.next = previous;
			previous = current;
			current = nextnode;
		}
		head = previous;
	}
	
	public static void main(String[] args) {
		
		MyLinkedList<Integer> ll = new MyLinkedList<>();
		ll.addFirst(23);
		ll.addFirst(44);
		ll.addLast(52);
		ll.addLast(78);
		ll.addPosition(4,72);
		ll.addPosition(4,66);
		ll.addPosition(4,60);
		ll.get();
		ll.removeFirst();
		ll.removeLast();
		System.out.println();
		ll.get();
		ll.removePosition(2);
		System.out.println();
		ll.get();
		ll.reverse();
		System.out.println();
		ll.get();
	}
}
