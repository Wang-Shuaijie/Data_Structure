package com.java.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	class Node{
		int key;
		int val;
		Node prev;
		Node next;
		public Node(int k, int v) {
			key=k;
			val=v;
		}
	}
	
	Node head;
	Node tail;
	Map<Integer, Node> map;
	int capacity;
	int size;
	public LRUCache(int capacity) {
		head=new Node(0,0);
		tail=new Node(0,0);
		map=new HashMap<Integer, LRUCache.Node>();
		head.next=tail;
		tail.prev=head;
		this.capacity=capacity;
		size=0;
	}
	
	public int get(int key) {
		if(map.containsKey(key)) {
			Node node=map.get(key);
			remove(key);
			addHead(key, node.val);
			return node.val;
		}else {
			return -1;
		}
	}
	
	public void put(int key, int value) {
		if (map.containsKey(key)) {
            remove(key);
            addHead(key, value);
        } else {
            addHead(key, value);
        }
	}
	
	private void remove(int key) {
		Node cur=map.get(key);
		Node prev=cur.prev;
		Node next=cur.next;
		prev.next=next;
		prev.prev=prev;
		size--;
		map.remove(key);
	}
	private void addHead(int key, int val) {
        Node node = new Node(key, val);
        Node next = head.next;
        head.next = node;
        node.next = next;
        next.prev = node;
        node.prev = head;
        map.put(key, node);
        size++;
        if (size > capacity) {
            Node preTail = tail.prev;
            remove(preTail.key);
        }
    }
}
