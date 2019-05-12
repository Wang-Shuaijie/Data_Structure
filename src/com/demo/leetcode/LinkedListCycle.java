package com.demo.leetcode;

public class LinkedListCycle {
	/**
	 * ����һ�������ж��������Ƿ��л���
	 * Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� 
	 * ��� pos �� -1�����ڸ�������û�л���
	 * ���룺head = [3,2,0,-4], pos = 1
	 * �����true
	 * ���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
	 */
	public boolean hasCycle(ListNode head) {
		//ֻ��Ҫ������ָ�룬һ��ÿ����һ������ָ���һ��ÿ���������Ŀ�ָ�룬����������л��Ļ�������ָ�����տ϶�������
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
