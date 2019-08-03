package com.java.leetcode;

public class ReverseNodesinKGroup {
	/**
	 * ����һ������ÿ k ���ڵ�һ����з�ת�������ط�ת�������
	 * k ��һ��������������ֵС�ڻ��������ĳ��ȡ�����ڵ��������� k ������������ô�����ʣ��ڵ㱣��ԭ��˳��
	 * ʾ�� :�����������1->2->3->4->5
	 * �� k = 2 ʱ��Ӧ������: 2->1->4->3->5
	 * �� k = 3 ʱ��Ӧ������: 3->2->1->4->5
	 */
	public ListNode reverseKGroup(ListNode head,int k) {
		if(head==null || head.next==null) return head;
		int count=0;
		ListNode cur=head;
		/*
		 * 1->2->3-4->5
		 * count=0;cur=1
		 * count=2;cur=3
		 * 		3->4->5
		 * 			count=2 cur=5 
		 */
		while(cur!=null && count!=k) {
			cur=cur.next;
			count++;
		}
		if(count==k) {
			cur=reverseKGroup(cur, k);
			while(count-- >0) {
				//��ת����
				ListNode temp=head.next;
				head.next=cur;
				cur=head;
				head=temp;
			}
			head=cur;
		}
		return head;
	}	
	
	public ListNode reverseKGroup2(ListNode head,int k) {
		return head;
	}
		
	
	//����:��ת����
	public ListNode reverseList(ListNode head) {
		if(head.next==null) return head;
		//��¼current�Ľڵ�Ϊhead����һ���ڵ�
		ListNode current=head.next;
		//�ж�head.nextָ��current(��ǰhead��Ϊ�����β������head.next=null)
		head.next=null;
		while(current!=null) {
			//��¼currentNext�Ľڵ���currentNext�����һ���ڵ㡣
			ListNode currentNext=current.next;
			//current.next������ָ����ǰ�Ľڵ�
			current.next=head;
			//head������Ϊͷ���
			head=current;
			//�ƶ�ָ��
			current=currentNext;
			
		}
		return head;
	}
	
	//��ת����
	public ListNode reverseLinklist(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode dummy=null;
		if(head.next!=null) {
			ListNode nextNode=head.next;
			head.next=dummy;
			dummy=head;
			head=nextNode;
			
		}
		return dummy;
	}
	
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int val) {
			this.val=val;
		}
	}
}
