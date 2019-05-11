package com.demo.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution05 {
	/**
	 * 输入一个链表，从尾到头打印链表每个节点的值。
	 * 思路：使用栈
	 */
	public List<Integer> printListFromTailtoHead(ListNode head){
		List<Integer> res=new ArrayList<>();
		Stack<ListNode> s=new Stack<>();
		if(head==null) return res;
		while(head!=null) {
			s.push(head);
			head=head.next;
		}
		while(!s.isEmpty()) {
			res.add(s.pop().val);
		}
		return res;
	}
	
	//递归写法
	public ArrayList<Integer> printListFromTailtoHead2(ListNode head){
		ArrayList<Integer> res=new ArrayList<>();
		if(head!=null) {
			res.addAll(printListFromTailtoHead2(head.next));
			res.add(head.val);
		}
		return res;
	}
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			x=val;
		}
	}
}
