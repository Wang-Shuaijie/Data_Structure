package com.demo.LeetCode;

import java.util.HashMap;

public class CopyListwithRandomPointer {
	/**
	 * ����һ������ÿ���ڵ����һ���������ӵ����ָ�룬��ָ�����ָ�������е��κνڵ��սڵ㡣
	 * Ҫ�󷵻�������������� 
	 * ʾ����
���룺
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
���ͣ�
�ڵ� 1 ��ֵ�� 1��������һ��ָ������ָ�붼ָ��ڵ� 2 ��
�ڵ� 2 ��ֵ�� 2��������һ��ָ��ָ�� null�����ָ��ָ�����Լ���
	 */
	public Node copyRandomList(Node head) {
		/*
1. ��ԭ�����ÿ���ڵ���濽����һ���µĽڵ�
2. ���θ��µĽڵ�����ָ�븳ֵ�����������ֵ�ǳ����� cur->next->random = cur->random->next
3. �Ͽ�����ɵõ���ȿ������������
		 */
		if(head==null) return head;
		Node cur=head;
		while(cur!=null) {
			Node node=new Node(cur.val);
			node.next=cur.next;
			cur.next=node;
			cur=node.next;
		}
		cur=head;
		while(cur!=null) {
			if(cur.random!=null) {
				cur.next.random=cur.random.next;
			}
			cur=cur.next.next;
		}
		cur=head;
		Node res=head.next;
		while(cur!=null) {
			Node temp=cur.next;
			cur.next=temp.next;
			if(temp.next!=null) {
				temp.next=temp.next.next;
			}
			cur=cur.next;
		}
		return res;
	}
	
	
	public Node copyRandomList2(Node head) {
		//����һ��HashMap�����洢ÿһ������Ľڵ㣬<key, value> �ֱ�Ϊԭ����ڵ㡢������ڵ㣬���ƵĹ��̻��Ƿ�������ɣ���һ������˳��next���θ��ƣ��ڶ������Ǹ���randomָ�룬���ԭ����randomָ�벻Ϊ�����map��ȡ������Ȼ�����ö�Ӧ������Ľڵ㣬�����ռ临�Ӷ�ΪO(n)�� ʱ�临�Ӷ�ΪO(n)��
		HashMap<Node, Node> map=new HashMap<>();
		Node dummy=new Node(-1);
		Node p=head, q=dummy;
		while(p!=null) {
			Node temp=new Node(p.val);
			map.put(p, temp);
			q.next=temp;
			
			p=p.next;
			q=q.next;
		}
		p=head;
		while(p!=null) {
			if(p.random!=null) {
				Node value=map.get(p);
				Node randomNode=new Node(p.random.val);
				value.random=randomNode;
			}
			p=p.next;
		}
		return dummy.next;
	}
}

class Node{
	int val;
	Node next;
	Node random;
		
	public Node(int x) {
		this.val=x;	
	}
		
}