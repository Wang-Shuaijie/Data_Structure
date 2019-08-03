package com.java.剑指offer;


public class Solution57 {
	/**
	 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
	 * 1->2->2->3->3->4
	 * 1->4
	 */
	public ListNode deleteDuplication(ListNode head) {
		//由于链表开头可能会有重复项，被删掉的话头指针会改变，而最终却还需要返回链表的头指针。
		//所以需要定义一个新的节点，然后链上原链表，
		//然后定义一个前驱指针和一个现指针
		if(head==null || head.next==null) return head;
		ListNode dummy=new ListNode(-1);
		ListNode pre=dummy;
		dummy.next=head;
		while(pre.next!=null) {
			ListNode cur=pre.next;
			while(cur.next!=null && cur.val==cur.next.val) {
				cur=cur.next;
			}
			if(cur!=pre.next) {
				pre.next=cur.next;
			}else {
				pre=pre.next;
			}
		}
		return dummy.next;
	}
	
	//递归解法
	public ListNode deleteDuplication2(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode nextNode=head.next;
		if(head.val==nextNode.val) {
			while(nextNode!=null && head.val==nextNode.val) {
				nextNode=nextNode.next;
			}
			return deleteDuplication2(nextNode);
		}else {
			head.next=deleteDuplication2(head.next);
			return head;
		}
	}
	
	/**
	 * 相似题目
	 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
	 * 示例 1:
	 * 输入: 1->1->2
	 * 输出: 1->2
	 */
	public ListNode deleteDuplicationII(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode cur=head;
		while(cur.next!=null) {
			if(cur.next.val==cur.val) {
				cur.next=cur.next.next;
			}else {
				cur=cur.next;
			}
		}
		return head;
	}
	
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			val=x;
		}
	}
}
