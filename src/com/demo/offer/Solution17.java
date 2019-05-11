package com.demo.offer;

public class Solution17 {
	/**
	 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。

思路：递归与非递归求解，小数放在前面
	 */
	public ListNode mergeTwoList(ListNode l1, ListNode l2) {
		ListNode dummy=new ListNode(0);
		ListNode cur=dummy;
		while(l1!=null && l2!=null) {
			if(l1.val<l2.val) {
				cur.next=l1;
				l1=l1.next;
			}else {
				cur.next=l2;
				l2=l2.next;
			}
			cur=cur.next;
		}
		if(l1!=null) cur.next=l1;
		if(l2!=null) cur.next=l2;
		return dummy.next;
	}
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			x=val;
		}
	}
}
