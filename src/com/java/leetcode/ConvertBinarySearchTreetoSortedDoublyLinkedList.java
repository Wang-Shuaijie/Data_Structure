package com.java.leetcode;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
	/**
	 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
比如将二元查找树
                                            10
                                          /    \
                                        6      14
                                      /   \   /   \
                                     4     8 12   16
转换成双向链表
4=6=8=10=12=14=16。
	 */
	public TreeNode treeToDoublyList(TreeNode root) {
		if(root==null) return null;
		TreeNode head=null, pre=null;
		inorder(root,pre,head);
		pre.right=head;
		head.left=pre;
		return head;
	}

	private void inorder(TreeNode root, TreeNode pre, TreeNode head) {
		if(root==null) return ;
		inorder(root.left, pre, head);
		if(head==null) {
			head=root;
			pre=root;
		}else {
			pre.right=root;
			root.left=pre;
			pre=root;
		}
		inorder(root.right, pre, head);
	}
}
