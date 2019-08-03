package com.java.剑指offer;

public class Solution13 {
	/**
	 * O(1)时间删除链表节点
	 */
	public void deleteNode(ListNode head, ListNode node) {
		if(head==null) return;
		//删除该节点的下一个节点
		node.val=node.next.val;
		node.next=node.next.next;
	}
	
	
	//更为严谨一点需要判断是否是尾节点
	public ListNode deleteNode2(ListNode head, ListNode node) {
		if(head==null) return null;
		//node节点不是尾节点
		if(node.next!=null) {
			//删除该节点的下一个节点
			node.val=node.next.val;
			node.next=node.next.next;
		}else {
			//只有一个节点
			if(head==node) {
				head=null;
			}else {
				//node是尾节点
				ListNode cur=head;
				while(cur!=node) {
					cur=cur.next;
				}
				cur.next=null;
			}
		}
		return head;
	}
	
	
	
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			x=val;
		}
	}
}
