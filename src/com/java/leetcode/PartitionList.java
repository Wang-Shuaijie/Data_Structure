package com.java.leetcode;

public class PartitionList {
	/**
	 * ����һ�������һ���ض�ֵ x����������зָ���ʹ������С�� x �Ľڵ㶼�ڴ��ڻ���� x �Ľڵ�֮ǰ��
	 * ��Ӧ����������������ÿ���ڵ�ĳ�ʼ���λ�á�
	 * ʾ��:
	 * ����: head = 1->4->3->2->5->2, x = 3
	 * ���: 1->2->2->4->3->5
	 */
	public ListNode partition(ListNode head,int x) {
		/*
		 * �����Ҫ�����ǻ�������������С�ڸ���ֵ�Ľڵ㶼�Ƶ�ǰ�棬���ڸ�ֵ�Ľڵ�˳�򲻱䣬
		 * �൱��һ���ֲ���������⡣��ô�����뵽��һ�ֽⷨ�������ҵ���һ�����ڻ���ڸ���ֵ�Ľڵ㣬
		 * ����Ŀ�и���������˵�������ҵ�4��Ȼ������С��3��ֵ��
		 * ÿ�ҵ�һ���ͽ���ȡ������4֮ǰ����
		 * 1 -> 4 -> 3 -> 2 -> 5 -> 2 
		 * 1 -> 2 -> 4 -> 3 -> 5 -> 2 
		 * 1 -> 2 -> 2 -> 4 -> 3 -> 5
		 */
		ListNode dummy=new ListNode(-1);
		dummy.next=head;
		ListNode pre=dummy,cur=head;
		while(pre.next!=null && pre.next.val<x) {
			pre=pre.next;
		}
		cur=pre;
		while(cur.next!=null) {
			if(cur.next.val<x) {
				ListNode temp=cur.next;//2
				cur.next=temp.next;//3->5
				temp.next=pre.next;//2->4
				pre.next=temp;
				pre=pre.next;
			}else {
				cur=cur.next;
			}
		}
		return dummy.next;
	}
	
	public ListNode partition2(ListNode head,int x) {
		/*
		 * ���⻹��һ�ֽⷨ�����ǽ�����С�ڸ���ֵ�Ľڵ�ȡ�����һ���µ�����
		 * ��ʱԭ������ʣ��Ľڵ��ֵ�����ڻ���ڸ���ֵ��ֻҪ��ԭ����ֱ�ӽ���������󼴿�
		 * ���ֽⷨ����仯˳��Ϊ��
		 * Original: 1 -> 4 -> 3 -> 2 -> 5 -> 2 
		 * New:
		 * Original: 4 -> 3 -> 2 -> 5 -> 2 
		 * New:��  1 
		 * Original: 4 -> 3 -> 5 -> 2 
		 * New:��  1 -> 2
		 * Original: 4 -> 3 -> 5 
		 * New:��  1 -> 2 -> 2
		 * Original: 
		 * New:��  1 -> 2 -> 2 -> 4 -> 3 -> 5 
		 */
		if(head==null) return null;
		ListNode dummy=new ListNode(0);
		ListNode newDummy=new ListNode(0);
		dummy.next=head;
		ListNode cur=dummy,p=newDummy;
		while(cur.next!=null) {
			if(cur.next.val<x) {
				p.next=cur.next;
				p=p.next;
				cur.next=cur.next.next;
				//p.next=null;
			}else {
				cur=cur.next;
			}
		}
		p.next=dummy.next;
		return newDummy.next;
	}
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			val=x;
		}
	}
}
