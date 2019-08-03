package com.java.leetcode;

public class MergeTwoSortedLists {
	/**
	 * 链表经典题型
	 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
	 * 示例：输入：1->2->4, 1->3->4   输出：1->1->2->3->4->4
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy=new ListNode(0);
		ListNode cur=dummy;
		while(l1!=null && l2!=null) {
			if(l1.val<l2.val) {
				cur.next=new ListNode(l1.val);
				l1=l1.next;
			}else {
				cur.next=new ListNode(l2.val);
				l2=l2.next;
			}
			cur=cur.next;
		}
		if(l1!=null) {
			cur.next=l1;
		}else {
			cur.next=l2;
		}
		return cur.next;
	}
	
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		if(l1.val<l2.val) {
			l1.next=mergeTwoLists2(l1.next, l2);
			return l1;
		}else {
			l2.next=mergeTwoLists2(l1, l2.next);
			return l2;
		}
	}
	
class ListNode{
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val=val;
	}
}

}
