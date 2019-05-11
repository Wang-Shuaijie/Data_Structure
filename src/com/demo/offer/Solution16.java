package com.demo.offer;

import com.demo.offer.Solution05.ListNode;

public class Solution16 {
	/**
	 * 输入一个链表，反转链表后，输出链表的所有元素。

扩展题：输出反转后链表的头节点，定义三个指针反向输出。

思路：定义两个指针，反向输出
	 */
	public ListNode reverseLinkedList(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode dummy=null;
		while(head!=null) {
			ListNode temp=head.next;
			head.next=dummy;
			dummy=head;
			head=temp;
		}
		return dummy;
	}
	
	//递归法
	public ListNode reverseLinkedList2(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode nextNode=head.next;
		head.next=null;
		ListNode newHead=reverseLinkedList(nextNode);
		nextNode.next=head;
		return newHead;
	}
}
