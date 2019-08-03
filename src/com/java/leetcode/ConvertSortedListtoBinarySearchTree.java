package com.java.leetcode;

public class ConvertSortedListtoBinarySearchTree {
	/**
	 * Example:

Given the sorted linked list: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
	 */
	
	public TreeNode sortedListToBST(ListNode head) {
		//���ֲ��ҷ�ÿ����Ҫ�ҵ��е㣬������Ĳ����м�����ͨ������ָ������
		if(head==null) return null;
		if(head.next==null) return new TreeNode(head.val);
		ListNode slow=head, fast=head, last=slow;
		while(fast.next!=null && fast.next.next!=null) {
			last=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		fast=slow.next;
		//�ҵ��е��Ҫ���е��ֵ����һ�����ĸ��ڵ㣬Ȼ����Ҫ��ԭ����Ͽ�����Ϊǰ���������������ܰ���ԭ�нڵ㣬Ȼ���ٷֱ������������ݹ����ԭ�������ֱ����������ӽڵ㼴��
		last.next=null;
		TreeNode cur=new TreeNode(slow.val);
		if(head!=slow) cur.left=sortedListToBST(head);
		cur.right=sortedListToBST(fast);
		return cur;
		
	}
	
	
	
	
	public TreeNode sortedListToBST2(ListNode head) {
	    if(head==null) return null;
	    return toBST(head,null);
	}
	public TreeNode toBST(ListNode head, ListNode tail){
	    ListNode slow = head;
	    ListNode fast = head;
	    if(head==tail) return null;
	    
	    while(fast!=tail&&fast.next!=tail){
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    TreeNode thead = new TreeNode(slow.val);
	    thead.left = toBST(head,slow);
	    thead.right = toBST(slow.next,tail);
	    return thead;
	}
}
