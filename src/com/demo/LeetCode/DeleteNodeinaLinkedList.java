package com.demo.LeetCode;

public class DeleteNodeinaLinkedList {
	/**
	 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。

现有一个链表 -- head = [4,5,1,9]，它可以表示为:

 4->5->1->9

示例 1:

输入: head = [4,5,1,9], node = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.

	 */
	public void deleteNode(ListNode node) {
		//和通常不同的是，没有给我们链表的起点，只给我们了一个要删的节点，跟我们以前遇到的情况不太一样，我们之前要删除一个节点的方法是要有其前一个节点的位置，然后将其前一个节点的next连向要删节点的下一个，然后delete掉要删的节点即可
		//这道题的处理方法是先把当前节点的值用下一个节点的值覆盖了，然后我们删除下一个节点即可
		node.val=node.next.val;
		node.next=node.next.next;
	}
}
