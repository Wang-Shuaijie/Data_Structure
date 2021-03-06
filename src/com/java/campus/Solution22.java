package com.java.campus;

/**
 *  对于一个链表 L: L0→L1→…→Ln-1→Ln,
将其翻转成 L0→Ln→L1→Ln-1→L2→Ln-2→…

输入是一串数字，请将其转换成单链表格式之后，再进行操作 
 * @author WangShuaiJie
 *
 */
public class Solution22 {
	
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
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			x=val;
		}
	}
}
