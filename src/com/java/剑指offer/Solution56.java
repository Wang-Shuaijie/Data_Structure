package com.java.剑指offer;

public class Solution56 {
	/**
	 * 一个链表中包含环，请找出该链表的环的入口结点
	 */
	public ListNode detectCycle(ListNode head) {
		ListNode fast=head,slow=head;
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(slow==fast) break;
		}
		if(fast==null || fast.next==null) return null;
		slow=head;
		while(slow!=fast) {
			slow=slow.next;
			fast=fast.next;
		}
		return slow;
	}
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			x=val;
		}
	}
}
