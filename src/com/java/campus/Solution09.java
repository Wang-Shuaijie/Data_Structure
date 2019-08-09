package com.java.campus;
/**
 * 设计一个数据结构，实现LRU Cache的功能(Least Recently Used – 最近最少使用缓存)。它支持如下2个操作： get 和 put。
 
int get(int key) – 如果key已存在，则返回key对应的值value（始终大于0）；如果key不存在，则返回-1。
void put(int key, int value) – 如果key不存在，将value插入；如果key已存在，则使用value替换原先已经存在的值。如果容量达到了限制，LRU Cache需要在插入新元素之前，将最近最少使用的元素删除。
 
请特别注意“使用”的定义：新插入或获取key视为被使用一次；而将已经存在的值替换更新，不算被使用。
 
限制：请在O(1)的时间复杂度内完成上述2个操作。
Example:

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

 * @author WangShuaiJie
 *
 */

import java.util.HashMap;
import java.util.Map;

public class Solution09 {
	private Node head, tail;
	private Map<Integer, Node> map;
	private int size, capacity;

	public Solution09(int capacity) {
		head = new Node(0, 0);
		tail = new Node(0, 0);
		map = new HashMap<>();
		head.next = tail;
		tail.prev = head;
		this.capacity = capacity;
		size = 0;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			remove(key);
			addHead(key, node.val);
			return node.val;
		} else
			return -1;
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
		Node cur = map.get(key);
		Node prev = cur.prev;
		Node next = cur.next;
		prev.next = next;
		next.prev = prev;
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

	class Node {
		Node prev, next;
		int key, val;

		Node() {
		}

		Node(int key, int val) {
			key = this.key;
			this.val = val;
		}
	}

}
