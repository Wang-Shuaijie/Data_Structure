package com.java.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.

Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * @author WangShuaiJie
 *
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if(head==null || head.next==null) return ;
		ListNode slow=head;
		ListNode fast=head;
		//找到链表的一半
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}		
		
		//链表分成两段,将后半段进行链表翻转
		ListNode needReverser=slow.next;
		slow.next=null;
		needReverser=reverse(needReverser);
		
		//两条链表进行合并
		ListNode cur=head;
		while(cur!=null && needReverser !=null) {
			ListNode curSecond=needReverser;
			needReverser=needReverser.next;
			ListNode nextCur=cur.next;
			curSecond.next=cur.next;
			cur.next=curSecond;
			cur=nextCur;
		}
		
	}
	
	private ListNode reverse(ListNode head) {
		ListNode p1=null;
		ListNode p2=head;
		ListNode p3=p2;
		while(p2!=null) {
			p3=p2.next;
			p2.next=p1;
			p1=p2;
			p2=p3;
		}
		return p1;
	}
	
	
	
	
	
	
	
	public void reorderList2(ListNode head) {
		if(head==null || head.next==null) return ;
		Deque<ListNode> stack=new ArrayDeque<ListNode>();
		ListNode ptr=head;
		while(ptr!=null) {
			stack.push(ptr);
			ptr=ptr.next;
		}
		int cnt=(stack.size()-1)/2;
		ptr=head;
		while(cnt>0) {
			ListNode top=stack.pop();
			ListNode tmp=ptr.next;
			ptr.next=top;
			top.next=tmp;
			ptr=tmp;
			cnt--;
		}
		stack.pop().next=null;
	}
}
