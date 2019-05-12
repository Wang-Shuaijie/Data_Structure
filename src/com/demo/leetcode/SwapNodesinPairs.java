package com.demo.leetcode;

public class SwapNodesinPairs {
	/**
	 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
	 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
	 * 示例:给定 1->2->3->4, 你应该返回 2->1->4->3.
	 */
	public ListNode swapPairs(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		//l1,l2都属于指针
		ListNode l1=dummy;
		ListNode l2=head;
	
		while(l2!=null&&l2.next!=null) {
			ListNode nextStart=l2.next.next;//保存第三个节点(下次交换的起始节点)
			l1.next=l2.next;//0->2;l1.next的后一个节点是l2.next
			l2.next.next=l2;//2->1 即0->2->1;l2.next节点的后一个节点
			l2.next=nextStart;
			l1=l2;//指向1
			l2=l2.next;//指向3
		}
		return dummy.next;
	}	
	
	//递归
	public ListNode swapPairs2(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode dummy=head.next;
		head.next=swapPairs2(head.next.next);
		dummy.next=head;
		return dummy;
	}
	
	//思路清晰
	public ListNode swapPairs3(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		//l1,l2都属于指针
		ListNode pre=dummy;
		ListNode curr=head;
	
		while(curr!=null&&curr.next!=null) {//l2=1,l2.next=2
			pre.next=curr.next;//0->2  
			curr.next=pre.next.next;//curr.next=3
			pre.next.next=curr;//2->1
			pre=curr;//pre=1
			curr=curr.next;//curr=3;
		}
		return dummy.next;
	}	
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val=val;
		}
	}
}
