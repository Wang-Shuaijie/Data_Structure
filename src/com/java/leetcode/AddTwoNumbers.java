package com.java.leetcode;

public class AddTwoNumbers {
	/**
	 * 给出两个 非空 的链表用来表示两个非负的整数。
	 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
	 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
	 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
	 * 示例：
	 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)输出：7 -> 0 -> 8原因：342 + 465 = 807
	 * time:O(n)  space:O(n)
	 */
	
	public static ListNode addTwoNumbers(ListNode l1,ListNode l2) {
		//新建一个链表(dummy傀儡)
		ListNode dummy=new ListNode(0);
		int sum=0;
		ListNode cur=dummy;
		ListNode p1=l2,p2=l2;
		while(p1 != null || p2 != null) {
			if(p1 != null) {
				sum += p1.val;
				p1=p1.next;
			}
			if(p2 != null) {
				sum += p2.val;
				p2=p2.next;
			}
			cur.next=new ListNode(sum%10); //(4+6为0)
			//考虑进位问题
			sum /= 10;
			cur=cur.next;
		}
		//若多一位
		if(sum==1) {
			cur.next=new ListNode(1);
		}
		return dummy.next;
	}
	
}

//链表结构
class ListNode{
	int val;//定义val变量值，存储节点值
	ListNode next;//定义next指针，指向下一个结点，维持节点连接
	public ListNode(int x) {
		// TODO Auto-generated constructor stub
		val=x;
	}
}