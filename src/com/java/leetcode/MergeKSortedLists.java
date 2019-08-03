package com.java.leetcode;

import java.util.PriorityQueue;

public class MergeKSortedLists {
	/**
	 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
	 * 示例:输入:[1->4->5,1->3->4,2->6]
	 * 	       输出: 1->1->2->3->4->4->5->6
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null || lists.length==0) return null;
		return sort(lists, 0, lists.length-1);
	}
	
	public ListNode mergeKLists2(ListNode[] lists) {
		if(lists==null || lists.length==0) return null;
		/**
		 * 比如合并6个链表，那么按照分治法，我们首先分别合并0和3，1和4，2和5。
		 * 这样下一次只需合并3个链表，我们再合并1和3，最后和2合并就可以了。
		 * 代码中的k是通过 (n+1)/2 计算的，这里为啥要加1呢，
		 * 这是为了当n为奇数的时候，k能始终从后半段开始，
		 * 比如当n=5时，那么此时k=3，则0和3合并，1和4合并，
		 * 最中间的2空出来。当n是偶数的时候，加1也不会有影响，
		 * 比如当n=4时，此时k=2，那么0和2合并，1和3合并
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
	
	//PriorityQueue<ListNode>解法
	public ListNode mergeKLists3(ListNode[] lists) {
		if(lists==null || lists.length==0) return null;
		//按首节点进行排序
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
		//用递归无限划分，2个2个的进行合并
		int middle=(high-low)/2+low;//(high+low)/2 high+low可能越界
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
