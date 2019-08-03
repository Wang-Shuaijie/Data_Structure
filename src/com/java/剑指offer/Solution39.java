package com.java.剑指offer;

public class Solution39 {
	/**
	 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
	 */
	public int getDepth(TreeNode root) {
		if(root==null) return 0;
		int left=getDepth(root.left)+1;
		int right=getDepth(root.right)+1;
		return Math.max(left, right);
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
