package com.demo.LeetCode;

public class ReverseLinkedListI {
	/**
	 * ��תһ��������
	 * ʾ��:
	 * ����: 1->2->3->4->5->NULL
	 * ���: 5->4->3->2->1->NULL
	 */
	public ListNode reverseList(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode dummy=null;
		while(head!=null) {
			ListNode temp=head.next;
			head.next=dummy;
			dummy=head;
			head=temp;
		}
		return dummy;
	}
	
	
	//�ݹ�д��
	public ListNode reverseList2(ListNode head) {
		ListNode newHead=reverseList2(head.next);
		head.next.next=head;
		head.next=null;
		return newHead;
	}
}
