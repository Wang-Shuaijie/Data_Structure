package com.demo.offer;

import com.demo.offer.Solution05.ListNode;

public class Solution16 {
	/**
	 * ����һ��������ת�����������������Ԫ�ء�

��չ�⣺�����ת�������ͷ�ڵ㣬��������ָ�뷴�������

˼·����������ָ�룬�������
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
	
	//�ݹ鷨
	public ListNode reverseLinkedList2(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode nextNode=head.next;
		head.next=null;
		ListNode newHead=reverseLinkedList(nextNode);
		nextNode.next=head;
		return newHead;
	}
}
