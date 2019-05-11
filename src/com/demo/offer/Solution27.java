package com.demo.offer;

public class Solution27 {
	/**
	 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
比如将二元查找树
                                            10
                                          /    \
                                        6      14
                                      /   \   /   \
                                     4     8 12   16
前序遍历转换成双向链表
4=6=8=10=12=14=16。
思路：定义一个链表的尾节点，递归处理左右子树，最后返回链表的头节点
	 */
	public TreeNode convert(TreeNode root) {
		if(root==null) return null;
		TreeNode head=null, pre=null;
		inorder(root,pre,head);
		pre.right=head;
		head.left=pre;
		return head;
	}
	private void inorder(TreeNode node, TreeNode pre, TreeNode head) {
		if(node==null) return ;
		inorder(node.left, pre, head);
		if(head==null) {
			head=node;
			pre=node;
		}else {
			pre.right=node;
			node.left=pre;
			//后移
			pre=node;
		}
		inorder(node.right, pre, head);
	}
	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			x=val;
		}
	}
}
