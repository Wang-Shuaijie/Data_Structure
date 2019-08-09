package com.java.campus;
/**
 * ���һ�����ݽṹ��ʵ��LRU Cache�Ĺ���(Least Recently Used �C �������ʹ�û���)����֧������2�������� get �� put��
 
int get(int key) �C ���key�Ѵ��ڣ��򷵻�key��Ӧ��ֵvalue��ʼ�մ���0�������key�����ڣ��򷵻�-1��
void put(int key, int value) �C ���key�����ڣ���value���룻���key�Ѵ��ڣ���ʹ��value�滻ԭ���Ѿ����ڵ�ֵ����������ﵽ�����ƣ�LRU Cache��Ҫ�ڲ�����Ԫ��֮ǰ�����������ʹ�õ�Ԫ��ɾ����
 
���ر�ע�⡰ʹ�á��Ķ��壺�²�����ȡkey��Ϊ��ʹ��һ�Σ������Ѿ����ڵ�ֵ�滻���£����㱻ʹ�á�
 
���ƣ�����O(1)��ʱ�临�Ӷ����������2��������
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
