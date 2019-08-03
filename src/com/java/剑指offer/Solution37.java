package com.java.剑指offer;

public class Solution37 {
	/**
	 * 输入两个链表，找出它们的第一个公共结点。
	 */
	public ListNode findFirstCommonNode(ListNode headA, ListNode headB) {
		int lenA=getLen(headA);
		int lenB=getLen(headB);
		while(lenA!=lenB) {
			if(lenA>lenB) {
				headA=headA.next;
				lenA--;
			}else {
				headB=headB.next;
				lenB--;
			}
		}
		while(headA!=headB) {
			headA=headA.next;
			headB=headB.next;
		}
		return headA;
	}
	
	private int getLen(ListNode head) {
		int count=0;
		while(head!=null) {
			count++;
			head=head.next;
		}
		return count;
	}
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			val=x;
		}
	}
}
