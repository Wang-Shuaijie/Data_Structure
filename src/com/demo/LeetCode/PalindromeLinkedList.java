package com.demo.LeetCode;

import java.util.Stack;

public class PalindromeLinkedList {
	/**
	 * ���ж�һ�������Ƿ�Ϊ��������

ʾ�� 1:

����: 1->2
���: false

ʾ�� 2:

����: 1->2->2->1
���: true

���ף�
���ܷ��� O(n) ʱ�临�ӶȺ� O(1) �ռ临�ӶȽ�����⣿

	 */
	public boolean isPalindrome(ListNode head) {
		ListNode p=head;
		Stack<ListNode> s=new Stack<>();
		while(p!=null) {
			s.push(p);
			p=p.next;
		}
		while(!s.isEmpty()) {
			if(head.val!=s.pop().val) {
				return false;
			}
			head=head.next;
		}
		return true;
	}
	
	public boolean isPalindrome2(ListNode head) {
		//�������ҵ��е�󣬽����ε�����תһ�£��������ǾͿ��԰��ջ��ĵ�˳��Ƚ���
		if(head==null || head.next==null) return true;
		ListNode cur, pre;
		cur=head;
		int length=0;
		while(cur!=null) {
			length++;
			cur=cur.next;
		}
		cur=head.next;
		pre=head;
		head.next=null;
		for(int i=0;i<length/2;i++) {
			ListNode temp=cur.next;
			cur.next=pre;
			pre=cur;
			cur=temp;
		}
		if(length%2==1) pre=pre.next;
		while(cur!=null) {
			if(cur.val!=pre.val) return false;
			cur=cur.next;
			pre=pre.next;
		}
		return true;
		
	}
}
