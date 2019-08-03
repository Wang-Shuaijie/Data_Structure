package com.java.leetcode;

public class AddTwoNumbers {
	/**
	 * �������� �ǿ� ������������ʾ�����Ǹ���������
	 * ���У����Ǹ��Ե�λ���ǰ��� ���� �ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ�ܴ洢 һλ ���֡�
	 * ��������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�
	 * �����Լ���������� 0 ֮�⣬���������������� 0 ��ͷ��
	 * ʾ����
	 * ���룺(2 -> 4 -> 3) + (5 -> 6 -> 4)�����7 -> 0 -> 8ԭ��342 + 465 = 807
	 * time:O(n)  space:O(n)
	 */
	
	public static ListNode addTwoNumbers(ListNode l1,ListNode l2) {
		//�½�һ������(dummy����)
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
			cur.next=new ListNode(sum%10); //(4+6Ϊ0)
			//���ǽ�λ����
			sum /= 10;
			cur=cur.next;
		}
		//����һλ
		if(sum==1) {
			cur.next=new ListNode(1);
		}
		return dummy.next;
	}
	
}

//����ṹ
class ListNode{
	int val;//����val����ֵ���洢�ڵ�ֵ
	ListNode next;//����nextָ�룬ָ����һ����㣬ά�ֽڵ�����
	public ListNode(int x) {
		// TODO Auto-generated constructor stub
		val=x;
	}
}