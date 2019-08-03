package com.java.leetcode;

public class ReverseNodesinKGroup {
	/**
	 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
	 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
	 * 示例 :给定这个链表：1->2->3->4->5
	 * 当 k = 2 时，应当返回: 2->1->4->3->5
	 * 当 k = 3 时，应当返回: 3->2->1->4->5
	 */
	public ListNode reverseKGroup(ListNode head,int k) {
		if(head==null || head.next==null) return head;
		int count=0;
		ListNode cur=head;
		/*
		 * 1->2->3-4->5
		 * count=0;cur=1
		 * count=2;cur=3
		 * 		3->4->5
		 * 			count=2 cur=5 
		 */
		while(cur!=null && count!=k) {
			cur=cur.next;
			count++;
		}
		if(count==k) {
			cur=reverseKGroup(cur, k);
			while(count-- >0) {
				//翻转链表
				ListNode temp=head.next;
				head.next=cur;
				cur=head;
				head=temp;
			}
			head=cur;
		}
		return head;
	}	
	
	public ListNode reverseKGroup2(ListNode head,int k) {
		return head;
	}
		
	
	//补充:翻转链表
	public ListNode reverseList(ListNode head) {
		if(head.next==null) return head;
		//记录current的节点为head的下一个节点
		ListNode current=head.next;
		//切断head.next指向current(当前head变为链表的尾，所以head.next=null)
		head.next=null;
		while(current!=null) {
			//记录currentNext的节点是currentNext大的下一个节点。
			ListNode currentNext=current.next;
			//current.next反方向指向以前的节点
			current.next=head;
			//head重新作为头结点
			head=current;
			//移动指针
			current=currentNext;
			
		}
		return head;
	}
	
	//翻转链表
	public ListNode reverseLinklist(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode dummy=null;
		if(head.next!=null) {
			ListNode nextNode=head.next;
			head.next=dummy;
			dummy=head;
			head=nextNode;
			
		}
		return dummy;
	}
	
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val=val;
		}
	}
}
