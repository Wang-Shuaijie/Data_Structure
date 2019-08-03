package com.java.leetcode;

public class IntersectionofTwoLinkedLists {
	/**
	 * 编写一个程序，找到两个单链表相交的起始节点。
	 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], 
	 * skipA = 2, skipB = 3
	 * 输出：Reference of the node with value = 8
	 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
	 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
	 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        int lenA=len(headA);
        int lenB=len(headB);
        //先让两个链表的长度相同
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
         * 题目中强调了链表中不存在环，但是我们可以用环的思想来做，
         * 我们让两条链表分别从各自的开头开始往后遍历，当其中一条遍历到末尾时，
         * 我们跳到另一个条链表的开头继续遍历。两个指针最终会相等，而且只有两种情况，
         * 一种情况是在交点处相遇，另一种情况是在各自的末尾的空节点处相等。
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
