package com.java.leetcode;

public class OddEvenLinkedList {
	/**
	 * ����һ�������������е������ڵ��ż���ڵ�ֱ�����һ����ע�⣬����������ڵ��ż���ڵ�ָ���ǽڵ��ŵ���ż�ԣ������ǽڵ��ֵ����ż�ԡ�

�볢��ʹ��ԭ���㷨��ɡ�����㷨�Ŀռ临�Ӷ�ӦΪ O(1)��ʱ�临�Ӷ�ӦΪ O(nodes)��nodes Ϊ�ڵ�������

ʾ�� 1:

����: 1->2->3->4->5->NULL
���: 1->3->5->2->4->NULL

ʾ�� 2:

����: 2->1->3->5->6->4->7->NULL 
���: 2->3->6->7->1->5->4->NULL

˵��:

    Ӧ�����������ڵ��ż���ڵ�����˳��
    ����ĵ�һ���ڵ���Ϊ�����ڵ㣬�ڶ����ڵ���Ϊż���ڵ㣬�Դ����ơ�


	 */
	public ListNode oddEvenList(ListNode head) {
		//preָ����ڵ㣬curָ��ż�ڵ㣬Ȼ���ż�ڵ�cur������Ǹ���ڵ���ǰ��pre�ĺ��棬Ȼ��pre��cur����ǰ��һ������ʱcur��ָ��ż�ڵ㣬preָ��ǰ��ڵ��ĩβ
		if(head==null || head.next==null) return head;
		ListNode pre=head,cur=head.next;
		while(cur!=null && cur.next!=null) {
			ListNode temp=pre.next;
			pre.next=cur.next;
			cur.next=cur.next.next;
			pre.next.next=temp;
			cur=cur.next;
			pre=pre.next;
		}
		return head;
	}
}
