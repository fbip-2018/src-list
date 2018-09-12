package com.src.list;

public class LinkedList {

	private static Node head;
	
	public static void main(String[] args) {
	
		LinkedList list = new LinkedList("ABC");
		list.addAtHead("XYZ");
		list.addAtTail("PQR");
		list.addAtIndex("LKM", 2);
		list.removeAtIndex(-1);
		list.removeTail();
		list.removeHead();
		
		list.printList();

	}

	public LinkedList(Object input){
		
		head = new Node(input);
	}
	
	public void addAtHead(Object input){
		Node current = new Node(input);
		current.next = head;
		head = current;
	}
	
	public void addAtTail(Object input){
		
		Node node = head;
		while(node.next != null){
			node = node.next;
		}
		node.next = new Node(input);
	}
	
	public void addAtIndex(Object input, int index){
		
		if(index < 0)
			return;
		if(index == 0)
			addAtHead(input);
		else{
			Node temp = head;
			int count = 0;
			while(temp.next != null && count < index -1){
				count++;
				temp = temp.next;
			}
			
			Node holder = temp.next;
			temp.next = new Node(input);
			temp.next.next = holder;
		}
	}
	
	public void removeAtIndex(int index){
		
		if(index < 0)
			return;
		
		if(index == 0)
			head = head.next;
		
		else{
			Node temp = head;
			int count = 0;
			while(temp.next != null && count < index-1){
				count++;
				temp = temp.next;
			}
			temp.next = temp.next.next;
		}
		
	}
	
	public void removeTail(){
		
		Node temp = head;
		
		while(temp.next.next != null){
			temp = temp.next;
		}
		
		temp.next = null;
	}
	
	
	public void removeHead(){
		
		head = head.next;
		
	}
	
	public int find(Node n){
		
		Node temp = head;
		int current = 0;
		while(temp != n && temp.next != null){
			current++;
			temp = temp.next;
		}
		
		if(temp == n)
			return current;
		else
			return -1;
	}
	
	public void printList(){
		Node node = head;
		System.out.println(node.getData());
		while(node.next != null){
			System.out.println(node.next.getData());
			node = node.next;
		}
	}
		
	
	class Node{
		
		private Object data;
		private Node next;
		
		public Node(Object dat){
			data = dat;
		}
		
		public Object getData(){
			return data;
		}
		
	}
}
