package com.demo.LeetCode;

import java.util.Stack;

public class PalindromeLinkedList {
	/**
	 * 请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false

示例 2:

输入: 1->2->2->1
输出: true

进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

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
		//可以在找到中点后，将后半段的链表翻转一下，这样我们就可以按照回文的顺序比较了
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
