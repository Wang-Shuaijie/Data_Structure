package com.java.leetcode.Á´±í;
/**
 * Á´±í·­×ª
 * @author WangShuaiJie
 *
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode dummy=null;
		while(head!=null) {
			ListNode tmp=head.next;
			head.next=dummy;
			head=tmp;
			dummy=head;
		}
		return dummy;
	}
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			val=x;
		}
	}
}
