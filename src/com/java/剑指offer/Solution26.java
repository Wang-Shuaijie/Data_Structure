package com.java.剑指offer;

import java.util.HashMap;
import java.util.Map;

public class Solution26 {
	/**
	 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

思路：先复制链表的next节点，将复制后的节点接在原节点后，然后复制其它的节点，最后取偶数位置的节点（复制后的节点）。
	 */
	public Node copyRandomListNode(Node head) {
		//设置一个HashMap用来存储每一个链表的节点，<key, value> 分别为原链表节点、新链表节点，复制的过程还是分两步完成，第一步就是顺着next依次复制，第二步就是复制random指针，如果原链表random指针不为空则从map中取出来，然后设置对应新链表的节点，这样空间复杂度为O(n)， 时间复杂度为O(n)。
		if(head==null) return head;
		Node p=head;
		Node dummy=new Node(-1);
		Node q=dummy;
		Map<Node,Node> map=new HashMap<>();
		//先复制next节点
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
	
	
	//hash虽然容易理解，但效率不高
	public Node clone(Node head) {
	    if (head == null)
	        return null;
	    // 插入新节点
	    Node cur = head;
	    while (cur != null) {
	        Node newHead = new Node(cur.val);
	        newHead.next = cur.next;
	        cur.next = newHead;
	        cur = newHead.next;
	    }
	    // 建立 random 链接
	    cur = head;
	    while (cur != null) {
	        Node newHead = cur.next;
	        if (cur.random != null)
	            newHead.random = cur.random.next;
	        cur = newHead.next;
	    }
	    // 拆分
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
