package com.demo.LeetCode;

public class RemoveNthFromEnd {
	/**
	 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
	 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
	 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
	 */
	public ListNode removeNthFromEnd(ListNode head,int n) {
		
		ListNode dummy=new ListNode(0);
		ListNode slow=dummy;
		ListNode fast=dummy;
		//新建链表的后继为原链表的头结点
		dummy.next=head;
		/* head 1-2-3-4-5
		 * dummy0-1-2-3-4-5
		 * fast 0-1-2-3-4-5
		 * slow 0-1-2-3-4-5
		 * 
		 */
		//0-1 1-2 2-3
		for(int i=0;i<=n;i++) {
			fast=fast.next;
		}
		//3-4 4-5 5-null 也是3步
		//slow 0-1 1-2 2-3 slow走到3
		while(fast!=null) {
			fast=fast.next;
			slow=slow.next;
		}
		slow.next=slow.next.next;
		return dummy.next;
	}
	
	public ListNode removeNthFromEnd2(ListNode head,int n) {
		//head 1 2 3 4 5  n=2
		ListNode cur=head,pre=head;
		//1-2 2-3
		for(int i=0;i<n;i++) {
			pre=pre.next;
		}
		//n=5时 移除首节点，此时pre.next为空 即此时pre=1 2 3 4 5
		if(pre.next==null) return head.next;
		//3-4 4-5  2步
		//slow 1-2 2-3 cur走到3
		while(pre.next!=null) {
			pre=pre.next;
			cur=cur.next;
		}
		cur.next=cur.next.next;
				
		return head;
	}
	
class ListNode{
	int data;
	ListNode next;
	
	public ListNode(int data) {
		this.data=data;
	}
}
}

