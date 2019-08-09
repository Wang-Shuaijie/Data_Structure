package com.java.leetcode.����;
/**
 * ��������ʾ���� A �� B ���������ཻ�� c1��

A:          a1 �� a2
                                            �K
                      c1 �� c2 �� c3
                                            �J
B:    b1 �� b2 �� b3
 * @author WangShuaiJie
 *
 */
public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA=getLen(headA);
		int lenB=getLen(headB);
		while(lenA!=lenB) {
			if(lenA>lenB) {
				lenA--;
				headA=headA.next;
			}else {
				lenB--;
				headB=headB.next;
			}
		}
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}
	
	private int getLen(ListNode head) {
		if(head==null) return 0;
		int res=0;
		while(head!=null) {
			res++;
			head=head.next;
		}
		return res;
	}
	
	class ListNode{
		int val;
		ListNode next;
		public ListNode(int x) {
			val=x;
		}
	}
}
