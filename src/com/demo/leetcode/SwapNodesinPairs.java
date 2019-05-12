package com.demo.leetcode;

public class SwapNodesinPairs {
	/**
	 * ����һ���������������������ڵĽڵ㣬�����ؽ����������
	 * �㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
	 * ʾ��:���� 1->2->3->4, ��Ӧ�÷��� 2->1->4->3.
	 */
	public ListNode swapPairs(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		//l1,l2������ָ��
		ListNode l1=dummy;
		ListNode l2=head;
	
		while(l2!=null&&l2.next!=null) {
			ListNode nextStart=l2.next.next;//����������ڵ�(�´ν�������ʼ�ڵ�)
			l1.next=l2.next;//0->2;l1.next�ĺ�һ���ڵ���l2.next
			l2.next.next=l2;//2->1 ��0->2->1;l2.next�ڵ�ĺ�һ���ڵ�
			l2.next=nextStart;
			l1=l2;//ָ��1
			l2=l2.next;//ָ��3
		}
		return dummy.next;
	}	
	
	//�ݹ�
	public ListNode swapPairs2(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode dummy=head.next;
		head.next=swapPairs2(head.next.next);
		dummy.next=head;
		return dummy;
	}
	
	//˼·����
	public ListNode swapPairs3(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		//l1,l2������ָ��
		ListNode pre=dummy;
		ListNode curr=head;
	
		while(curr!=null&&curr.next!=null) {//l2=1,l2.next=2
			pre.next=curr.next;//0->2  
			curr.next=pre.next.next;//curr.next=3
			pre.next.next=curr;//2->1
			pre=curr;//pre=1
			curr=curr.next;//curr=3;
		}
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
