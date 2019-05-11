package com.demo.LeetCode;

public class RemoveDuplicatiesFromSortedList {
	/**
	 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
	 * 示例 1:
	 * 输入: 1->1->2
	 * 输出: 1->2
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode cur=head;
		while(cur.next!=null) {
			if(cur.val==cur.next.val) {
				cur.next=cur.next.next;
			}else {
				cur=cur.next;
			}
		}
		return head;
	}
}
