package com.demo.LeetCode;

public class ReverseLinkedListII {
	/*
	 * ��ת��λ�� m �� n ��������ʹ��һ��ɨ����ɷ�ת��
˵��:
1 �� m �� n �� �����ȡ�
ʾ��:
����: 1->2->3->4->5->NULL, m = 2, n = 4
���: 1->4->3->2->5->NULL
	 */
	public ListNode reverseBetween(ListNode head,int m,int n) {
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode pre=dummy;
		for(int i=0;i<m-1;i++) {
			pre=pre.next;
		}
		ListNode cur=pre.next;//2
		/*
		 * n=2,m=4 ����2�η�ת
		 * 3->4->2
		 * 4->3->2
		 */
		for(int j=m-1;j<n-1;j++) {
			ListNode temp=cur.next;//3
			cur.next=temp.next;//3->4
			temp.next=pre.next;//4->2
			pre.next=temp;//3			
		}
		return dummy.next;
	}
	
	public ListNode reverseBetween2(ListNode head,int m,int n) {
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode pre=dummy;
		ListNode cur=dummy.next;
		for(int i=1;i<m;i++) {
			cur=cur.next;//2
			pre=pre.next;//1
		}
		for(int i=0;i<n-m;i++) {
			ListNode temp=cur.next;
			cur.next=temp.next;
			temp.next=pre.next;
			pre.next=temp;
		}
		return dummy.next;
	}
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			val=x;
		}
	}
}
