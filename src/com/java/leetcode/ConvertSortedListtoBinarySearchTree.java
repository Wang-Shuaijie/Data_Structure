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
		//二分查找法每次需要找到中点，而链表的查找中间点可以通过快慢指针来操
		if(head==null) return null;
		if(head.next==null) return new TreeNode(head.val);
		ListNode slow=head, fast=head, last=slow;
		while(fast.next!=null && fast.next.next!=null) {
			last=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		fast=slow.next;
		//找到中点后，要以中点的值建立一个数的根节点，然后需要把原链表断开，分为前后两个链表，都不能包含原中节点，然后再分别对这两个链表递归调用原函数，分别连上左右子节点即可
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
