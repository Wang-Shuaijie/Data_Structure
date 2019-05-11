package com.demo.LeetCode;

public class LinkedListCycleII {
	/**
����һ��������������ʼ�뻷�ĵ�һ���ڵ㡣 ��������޻����򷵻� null��
Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л���
˵�����������޸ĸ���������
(����������еĻ�����ʼ��)
ʾ�� 1��
���룺head = [3,2,0,-4], pos = 1
�����tail connects to node index 1
���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
	 */
	public ListNode detectCycle(ListNode head) {
		/**
		 * ����������еĻ�����ʼ����֮ǰ�Ǹ��жϵ��������Ƿ��л������죬
		 * �ɲ�֮ǰ�ǵ�Linked List Cycle�����ﻹ��Ҫ�����ָ�룬
		 * �������Ҫ��¼����ָ��������λ�ã�������ָ�������˺�
		 * ������һ��ָ�������ͷ��ʼ,��ʱ��������λ�þ��������л�����ʼλ��
		 * ��Ϊ��ָ��ÿ����2����ָ��ÿ����1����ָ���ߵľ�������ָ���������
		 * ����ָ���ֱ���ָ�������һȦ��
		 * ����head���������+������㵽���������ĵ�ľ��� �� ��һȦ�ľ������
		 * �������¿�ʼ��head���е������ �� �����㵽����� �ľ���Ҳ����ȵģ�
		 * �൱������ͬʱ������ ������㵽���������ĵ�ľ��롣
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
