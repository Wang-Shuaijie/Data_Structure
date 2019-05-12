package com.demo.leetcode;

public class DepthofBinaryTree {
	/**
	 * 给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7

返回它的最大深度 3 。

	 */
	//最大深度
	public int maxDepth(TreeNode root) {
		if(root==null) return 0;
		if(root.left==null && root.right==null) return 1;
		int left=maxDepth(root.left)+1;
		int right=maxDepth(root.right)+1;
		return Math.max(left, right);
	}
	
	//最小深度
	public int minDepth(TreeNode root) {
		if(root==null) return 0;
		if(root.left==null && root.right==null) return 1;
		int left=minDepth(root.left)+1;
		int right=minDepth(root.right)+1;
		if(left == 1)          //等于1说明没有左子树有右子树，为避免干扰结果，另其为一个最大数
	        left = Integer.MAX_VALUE;
	    if(right == 1)         //等于1说明没有右子树有左子树，为避免干扰结果，另其为一个最大数
	        right = Integer.MAX_VALUE;
	    return Math.min(left, right);
	}
}
