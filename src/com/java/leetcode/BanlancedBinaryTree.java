package com.java.leetcode;

public class BanlancedBinaryTree {
	/**
	 * Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7

Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4

Return false.
 

求二叉树是否平衡，根据题目中的定义，高度平衡二叉树是每一个结点的两个子树的深度差不能超过1
	 */
	
	//不够高效
	public boolean isBanlanced(TreeNode root) {
		if(root==null) return true;
		if(Math.abs(getDepth(root.left)-getDepth(root.right))>1) return false;
		return isBanlanced(root.left)&&isBanlanced(root.right);
	}
	
	private int getDepth(TreeNode root) {
		if(root==null) return 0;
		int left=getDepth(root.left)+1;
		int right=getDepth(root.right)+1;
		return Math.max(left, right);
	}
	
	public boolean isBanlanced2(TreeNode root) {
		if(checkDepth(root)==-1) return false;
		return true;
	}
	
	private int checkDepth(TreeNode root) {
		if(root==null) return 0;
		int left=checkDepth(root.left)+1;
		if(left==-1) return -1;
		int right=checkDepth(root.right)+1;
		if(right==-1) return -1;
		int diff=Math.abs(left-right);
		if(diff > 1) return -1;
		else return Math.max(left, right);
	}
}
