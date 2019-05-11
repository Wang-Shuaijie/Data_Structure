package com.demo.LeetCode;

public class RemoveDuplicatiesFromSortedList {
	/**
	 * ����һ����������ɾ�������ظ���Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Ρ�
	 * ʾ�� 1:
	 * ����: 1->1->2
	 * ���: 1->2
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
