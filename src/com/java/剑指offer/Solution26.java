package com.java.��ָoffer;

import java.util.HashMap;
import java.util.Map;

public class Solution26 {
	/**
	 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�

˼·���ȸ��������next�ڵ㣬�����ƺ�Ľڵ����ԭ�ڵ��Ȼ���������Ľڵ㣬���ȡż��λ�õĽڵ㣨���ƺ�Ľڵ㣩��
	 */
	public Node copyRandomListNode(Node head) {
		//����һ��HashMap�����洢ÿһ������Ľڵ㣬<key, value> �ֱ�Ϊԭ����ڵ㡢������ڵ㣬���ƵĹ��̻��Ƿ�������ɣ���һ������˳��next���θ��ƣ��ڶ������Ǹ���randomָ�룬���ԭ����randomָ�벻Ϊ�����map��ȡ������Ȼ�����ö�Ӧ������Ľڵ㣬�����ռ临�Ӷ�ΪO(n)�� ʱ�临�Ӷ�ΪO(n)��
		if(head==null) return head;
		Node p=head;
		Node dummy=new Node(-1);
		Node q=dummy;
		Map<Node,Node> map=new HashMap<>();
		//�ȸ���next�ڵ�
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
				Node randomNode=map.get(p.random);
				value.random=randomNode;
			}
			p=p.next;
		}
		return dummy.next;
	}
	
	
	//hash��Ȼ������⣬��Ч�ʲ���
	public Node clone(Node head) {
	    if (head == null)
	        return null;
	    // �����½ڵ�
	    Node cur = head;
	    while (cur != null) {
	        Node newHead = new Node(cur.val);
	        newHead.next = cur.next;
	        cur.next = newHead;
	        cur = newHead.next;
	    }
	    // ���� random ����
	    cur = head;
	    while (cur != null) {
	        Node newHead = cur.next;
	        if (cur.random != null)
	            newHead.random = cur.random.next;
	        cur = newHead.next;
	    }
	    // ���
	    cur = head;
	    Node pCloneHead = head.next;
	    while (cur.next != null) {
	        Node next = cur.next;
	        cur.next = next.next;
	        cur = next;
	    }
	    return pCloneHead;
	}
	
	
	
	
	
	
	
	class Node{
		int val;
		Node next;
		Node random;
		public Node(int x) {
			x=val;
		}
	}
	
}
