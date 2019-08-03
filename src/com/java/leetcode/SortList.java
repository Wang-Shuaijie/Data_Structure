package com.java.leetcode;

public class SortList {
	/**
	 * Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4

Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5
	 */
	
	//这里题目限定了时间必须为O(nlgn)，符合要求只有快速排序，归并排序，堆排序，而根据单链表的特点，最适于用归并排序。
	public ListNode sortList(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode slow=head, fast=head, pre=head;
		while(fast!=null && fast.next !=null) {
			pre=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		pre.next=null;
		return merge(sortList(head),sortList(slow));
	}
	
	
	public ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy=new ListNode(-1);
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
	
	
	
	
	//引申：链表的插入排序
	public ListNode insertSort(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode dummy=new ListNode(-1);
		ListNode cur=dummy;
		while(head!=null) {
			ListNode temp=head.next;
			cur=dummy;
			while(cur.next!=null && cur.next.val<=head.val) {
				cur=cur.next;
			}
			head.next=cur.next;
			cur.next=head;
			head=temp;
		}
		return dummy.next;
	}
}
