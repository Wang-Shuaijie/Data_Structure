package com.java.��ָoffer;

public class Solution13 {
	/**
	 * O(1)ʱ��ɾ������ڵ�
	 */
	public void deleteNode(ListNode head, ListNode node) {
		if(head==null) return;
		//ɾ���ýڵ����һ���ڵ�
		node.val=node.next.val;
		node.next=node.next.next;
	}
	
	
	//��Ϊ�Ͻ�һ����Ҫ�ж��Ƿ���β�ڵ�
	public ListNode deleteNode2(ListNode head, ListNode node) {
		if(head==null) return null;
		//node�ڵ㲻��β�ڵ�
		if(node.next!=null) {
			//ɾ���ýڵ����һ���ڵ�
			node.val=node.next.val;
			node.next=node.next.next;
		}else {
			//ֻ��һ���ڵ�
			if(head==node) {
				head=null;
			}else {
				//node��β�ڵ�
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
