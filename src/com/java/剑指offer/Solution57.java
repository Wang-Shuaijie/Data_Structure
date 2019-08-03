package com.java.��ָoffer;


public class Solution57 {
	/**
	 * ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
	 * 1->2->2->3->3->4
	 * 1->4
	 */
	public ListNode deleteDuplication(ListNode head) {
		//��������ͷ���ܻ����ظ����ɾ���Ļ�ͷָ���ı䣬������ȴ����Ҫ���������ͷָ�롣
		//������Ҫ����һ���µĽڵ㣬Ȼ������ԭ����
		//Ȼ����һ��ǰ��ָ���һ����ָ��
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
	
	//�ݹ�ⷨ
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
	 * ������Ŀ
	 * ����һ����������ɾ�������ظ���Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Ρ�
	 * ʾ�� 1:
	 * ����: 1->1->2
	 * ���: 1->2
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
