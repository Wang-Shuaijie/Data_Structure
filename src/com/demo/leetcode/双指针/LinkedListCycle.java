package com.demo.leetcode.˫ָ��;
/**
 * �ж������Ƿ���ڻ�
 * @author WangShuaiJie
 *
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if(head==null) return false;
		ListNode l1=head, l2=head;
		while(l2!=null && l2.next!=null) {
			if(l1==l2) return true;
			l1=l1.next;
			l2=l2.next.next;
		}
		return false;
	}
	
	
	class ListNode{
		int val;
		ListNode next;
		
		public ListNode(int x) {
			val=x;
		}
	}
}
