package com.java.leetcode;

public class InsertionSortList {
	/**
	 * Á´±íµÄ²åÈëÅÅÐò
	 * Example 1:

Input: 4->2->1->3
Output: 1->2->3->4

Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
	 */
	public ListNode insertionSortList(ListNode head) {
		if(head==null) return head;
		ListNode dummy=new ListNode(0);
		ListNode cur=head, pre=dummy;
		ListNode next=null;
		while(cur!=null) {
			next=cur.next;
			while(pre.next!=null && pre.next.val<cur.val) {
				pre=pre.next;
			}
			cur.next=pre.next;
			pre.next=cur;
			pre=dummy;
			cur=next;
		}
		return dummy.next;
	}
}
