package com.java.base.LinkedList;

public class TestListNode {
	public static void main(String[] args) {
		//创建节点
		ListNode n1=new ListNode(1);
		ListNode n2=new ListNode(2);
		ListNode n3=new ListNode(3);
		ListNode test=new ListNode(9);
		ListNode dummy=new ListNode(0);
		ListNode cur=dummy;
		//改变cur,dummy也会改变
		cur.append(test);
		cur.show();
		System.out.println();
		dummy.show();
		System.out.println();
		//繁琐,舍弃
		//n1.append(n2);
		//n2.append(n3);
		n1.append(n2).append(n3);
		//System.out.println(n1.next().next().getData());
		n1.show();
		System.out.println();
		n1.removeNode();
		n1.show();
		System.out.println();
		ListNode n4=new ListNode(4);
		n1.insertNode(n4);
		n1.show();
	}
}
