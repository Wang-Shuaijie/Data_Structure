package com.demo.leetcode;

public class LinkedListCycle {
	/**
	 * 给定一个链表，判断链表中是否有环。
	 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 
	 * 如果 pos 是 -1，则在该链表中没有环。
	 * 输入：head = [3,2,0,-4], pos = 1
	 * 输出：true
	 * 解释：链表中有一个环，其尾部连接到第二个节点。
	 */
	public boolean hasCycle(ListNode head) {
		//只需要设两个指针，一个每次走一步的慢指针和一个每次走两步的快指针，如果链表里有环的话，两个指针最终肯定会相遇
		if(head==null || head.next==null) return false;
		ListNode slow=head,fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) return true;
		}
		return false;
	}
}
