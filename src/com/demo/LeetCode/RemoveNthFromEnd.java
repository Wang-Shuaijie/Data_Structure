package com.demo.LeetCode;

public class RemoveNthFromEnd {
	/**
	 * ����һ������ɾ������ĵ����� n ���ڵ㣬���ҷ��������ͷ��㡣
	 * ����һ������: 1->2->3->4->5, �� n = 2.
	 * ��ɾ���˵����ڶ����ڵ�������Ϊ 1->2->3->5.
	 */
	public ListNode removeNthFromEnd(ListNode head,int n) {
		
		ListNode dummy=new ListNode(0);
		ListNode slow=dummy;
		ListNode fast=dummy;
		//�½�����ĺ��Ϊԭ�����ͷ���
		dummy.next=head;
		/* head 1-2-3-4-5
		 * dummy0-1-2-3-4-5
		 * fast 0-1-2-3-4-5
		 * slow 0-1-2-3-4-5
		 * 
		 */
		//0-1 1-2 2-3
		for(int i=0;i<=n;i++) {
			fast=fast.next;
		}
		//3-4 4-5 5-null Ҳ��3��
		//slow 0-1 1-2 2-3 slow�ߵ�3
		while(fast!=null) {
			fast=fast.next;
			slow=slow.next;
		}
		slow.next=slow.next.next;
		return dummy.next;
	}
	
	public ListNode removeNthFromEnd2(ListNode head,int n) {
		//head 1 2 3 4 5  n=2
		ListNode cur=head,pre=head;
		//1-2 2-3
		for(int i=0;i<n;i++) {
			pre=pre.next;
		}
		//n=5ʱ �Ƴ��׽ڵ㣬��ʱpre.nextΪ�� ����ʱpre=1 2 3 4 5
		if(pre.next==null) return head.next;
		//3-4 4-5  2��
		//slow 1-2 2-3 cur�ߵ�3
		while(pre.next!=null) {
			pre=pre.next;
			cur=cur.next;
		}
		cur.next=cur.next.next;
				
		return head;
	}
	
class ListNode{
	int data;
	ListNode next;
	
	public ListNode(int data) {
		this.data=data;
	}
}
}

