package com.demo.LeetCode;

import java.util.Arrays;

public class ConvertSortedArraytoBinarySearchTree {
	/**
	 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5


	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		/*
		 * 所谓二叉搜索树，是一种始终满足左<根<右的特性，如果将二叉搜索树按中序遍历的话，得到的就是一个有序数组了。
		 * 那么反过来，我们可以得知，根节点应该是有序数组的中间点，从中间点分开为左右两个有序数组，
		 * 在分别找出其中间点作为原中间点的左右两个子节点
		 */
		Arrays.sort(nums);
		return helper(nums, 0, nums.length-1);
	}
	private TreeNode helper(int[] nums, int left, int right) {
		if(left>right) return null;
		int mid=(right-left)/2+left;
		TreeNode cur=new TreeNode(nums[mid]);
		cur.left=helper(nums, left, mid-1);
		cur.right=helper(nums, mid+1, right);
		return cur;
	}
}
