package com.demo.offer;

public class Solution15 {
	/**
	 * ����һ����������������е�����k����㡣
	 * �����ñʻ�һ�����������
	 */
	public ListNode FindKthToTail(ListNode head, int k) {
		if(head==null) return head;
		ListNode dummy=new ListNode(0);
		ListNode fast=dummy, slow=dummy;
		dummy.next=head;
		for(int i=0;i<=k;i++) {
			fast=fast.next;
		}
		while(fast!=null) {
			fast=fast.next;
			slow=slow.next;
		}
		return slow.next;
	}
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			x=val;
		}
	}
}
