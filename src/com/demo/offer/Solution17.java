package com.demo.offer;

import java.util.List;

public class Solution17 {
	/**
	 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������

˼·���ݹ���ǵݹ���⣬С������ǰ��
	 */
	public ListNode mergeTwoList(ListNode l1, ListNode l2) {
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
	
	//�ݹ�ⷨ
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		if(l1.val<l2.val) {
			l1.next=mergeTwoLists(l1.next, l2);
			return l1;
		}else {
			l2.next=mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
	
	//��չ��:�ϲ�K����������
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null || lists.length==0) return null;
		int n=lists.length;
		while(n>1) {
			int k=(n+1)/2;//�ճ��м��λ��
			for(int i=0;i<n/2;i++) {
				lists[i]=mergeTwoLists(lists[i], lists[i+k]);
			}
			n=k;
		}
		return lists[0];
	}
	
	
	
	
	
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			x=val;
		}
	}
}
