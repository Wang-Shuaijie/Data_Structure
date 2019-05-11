package com.demo.LeetCode;

import java.util.HashMap;

public class CopyListwithRandomPointer {
	/**
	 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
	 * 要求返回这个链表的深拷贝。 
	 * 示例：
输入：
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}
解释：
节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
	 */
	public Node copyRandomList(Node head) {
		/*
1. 在原链表的每个节点后面拷贝出一个新的节点
2. 依次给新的节点的随机指针赋值，而且这个赋值非常容易 cur->next->random = cur->random->next
3. 断开链表可得到深度拷贝后的新链表
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
		//设置一个HashMap用来存储每一个链表的节点，<key, value> 分别为原链表节点、新链表节点，复制的过程还是分两步完成，第一步就是顺着next依次复制，第二步就是复制random指针，如果原链表random指针不为空则从map中取出来，然后设置对应新链表的节点，这样空间复杂度为O(n)， 时间复杂度为O(n)。
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