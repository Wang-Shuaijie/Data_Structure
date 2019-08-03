package com.java.leetcode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
	/**
	 * �ϲ� k �������������غϲ������������������������㷨�ĸ��Ӷȡ�
	 * ʾ��:����:[1->4->5,1->3->4,2->6]
	 * 	       ���: 1->1->2->3->4->4->5->6
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null || lists.length==0) return null;
		return sort(lists, 0, lists.length-1);
	}
	
	public ListNode mergeKLists2(ListNode[] lists) {
		if(lists==null || lists.length==0) return null;
		/**
		 * ����ϲ�6��������ô���շ��η����������ȷֱ�ϲ�0��3��1��4��2��5��
		 * ������һ��ֻ��ϲ�3�����������ٺϲ�1��3������2�ϲ��Ϳ����ˡ�
		 * �����е�k��ͨ�� (n+1)/2 ����ģ�����ΪɶҪ��1�أ�
		 * ����Ϊ�˵�nΪ������ʱ��k��ʼ�մӺ��ο�ʼ��
		 * ���統n=5ʱ����ô��ʱk=3����0��3�ϲ���1��4�ϲ���
		 * ���м��2�ճ�������n��ż����ʱ�򣬼�1Ҳ������Ӱ�죬
		 * ���統n=4ʱ����ʱk=2����ô0��2�ϲ���1��3�ϲ�
		 */
		int n=lists.length;
		while(n>1) {
			int k=(n+1)/2;
			for(int i=0;i<n/2;i++) {
				lists[i]=mergeTwoSortedLists(lists[i], lists[i+k]);
			}
			n=k;
		}
		return lists[0];
	}
	
	//PriorityQueue<ListNode>�ⷨ
	public ListNode mergeKLists3(ListNode[] lists) {
		if(lists==null || lists.length==0) return null;
		//���׽ڵ��������
		PriorityQueue<ListNode> queue=new PriorityQueue<>(lists.length,(a,b)->a.val-b.val);
		ListNode dummy=new ListNode(0);
		ListNode cur=dummy;
		for(ListNode list:lists) {
			if(list!=null) {
				queue.add(list);
			}
		}
		while(!queue.isEmpty()) {
			cur.next=queue.poll();
			cur=cur.next;
			if(cur.next!=null) {
				queue.add(cur.next);
			}
		}
		return dummy.next;
	}
	
	public ListNode sort(ListNode[] lists,int low,int high) {
		if(low>=high) return lists[low];
		//�õݹ����޻��֣�2��2���Ľ��кϲ�
		int middle=(high-low)/2+low;//(high+low)/2 high+low����Խ��
		ListNode l1=sort(lists, low, middle);
		ListNode l2=sort(lists, middle+1, high);
		
		return merge(l1,l2);
	}
	
	public ListNode merge(ListNode l1,ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		if(l1.val<l2.val) {
			l1.next=merge(l1.next, l2);
			return l1;
		}else {
			l2.next=merge(l1,l2.next);
			return l2;
		}
	}
	
	public ListNode mergeTwoSortedLists(ListNode l1,ListNode l2) {
		ListNode dummy=new ListNode(0);
		ListNode cur=dummy;
		while(l1!=null && l2!=null) {
			if(l1.val<l2.val) {
				cur.next=l1;
				l1=l1.next;
			}else {
				cur.next=l2;
				l2=l2.next;
			}
			cur=cur.next;
		}
		if(l1!=null) cur.next=l1;
		if(l2!=null) cur.next=l2;
		
		return dummy.next;
	}
	
	
	
class ListNode{
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val=val;
	}
}
}
