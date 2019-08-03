package com.java.leetcode;

public class IntersectionofTwoLinkedLists {
	/**
	 * ��дһ�������ҵ������������ཻ����ʼ�ڵ㡣
	 * ���룺intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], 
	 * skipA = 2, skipB = 3
	 * �����Reference of the node with value = 8
	 * ������ͣ��ཻ�ڵ��ֵΪ 8 ��ע�⣬��������б��ཻ����Ϊ 0����
	 * �Ӹ��Եı�ͷ��ʼ�������� A Ϊ [4,1,8,4,5]������ B Ϊ [5,0,1,8,4,5]��
	 * �� A �У��ཻ�ڵ�ǰ�� 2 ���ڵ㣻�� B �У��ཻ�ڵ�ǰ�� 3 ���ڵ㡣
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        int lenA=len(headA);
        int lenB=len(headB);
        //������������ĳ�����ͬ
        if(lenA>lenB) {
        	while(lenA!=lenB) {
        		headA=headA.next;
        		lenA--;
        	}
        }else {
        	while(lenB!=lenA) {
        		headB=headB.next;
        		lenB--;
        	}
        }
        while(headA!=headB) {
        	headA=headA.next;
        	headB=headB.next;
        }
        return headA;
    }
	
	public int len(ListNode head) {
		int len=1;
		while(head!=null) {
			head=head.next;
			len++;
		}
		return len;
	}
	
	
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        /*
         * ��Ŀ��ǿ���������в����ڻ����������ǿ����û���˼��������
         * ��������������ֱ�Ӹ��ԵĿ�ͷ��ʼ���������������һ��������ĩβʱ��
         * ����������һ��������Ŀ�ͷ��������������ָ�����ջ���ȣ�����ֻ�����������
         * һ��������ڽ��㴦��������һ��������ڸ��Ե�ĩβ�Ŀսڵ㴦��ȡ�
         */
		if(headA==null || headB==null) return null;
		ListNode a=headA,b=headB;
		while(a!=b) {
			a=(a!=null)?a.next:headB;
			b=(b!=null)?b.next:headA;
		}
		return a;
    }
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			val=x;
		}
	}
}
