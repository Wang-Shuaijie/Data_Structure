package com.demo.LeetCode;

public class LinkedListCycleII {
	/**
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
说明：不允许修改给定的链表。
(这个求单链表中的环的起始点)
示例 1：
输入：head = [3,2,0,-4], pos = 1
输出：tail connects to node index 1
解释：链表中有一个环，其尾部连接到第二个节点。
	 */
	public ListNode detectCycle(ListNode head) {
		/**
		 * 这个求单链表中的环的起始点是之前那个判断单链表中是否有环的延伸，
		 * 可参之前那道Linked List Cycle。这里还是要设快慢指针，
		 * 不过这次要记录两个指针相遇的位置，当两个指针相遇了后，
		 * 让其中一个指针从链表头开始,此时再相遇的位置就是链表中环的起始位置
		 * 因为快指针每次走2，慢指针每次走1，快指针走的距离是慢指针的两倍。
		 * 而快指针又比慢指针多走了一圈。
		 * 所以head到环的起点+环的起点到他们相遇的点的距离 与 环一圈的距离相等
		 * 现在重新开始，head运行到环起点 和 相遇点到环起点 的距离也是相等的，
		 * 相当于他们同时减掉了 环的起点到他们相遇的点的距离。
		 */
		ListNode slow=head,fast=head;
		while(fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast) break;
		}
		if(fast==null || fast.next==null) return null;
		slow=head;
		while(slow!=fast) {
			slow=slow.next;
			fast=fast.next;
		}
		return fast;
	}
}
