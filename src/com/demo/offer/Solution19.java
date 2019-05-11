package com.demo.offer;

import java.util.Stack;

public class Solution19 {
	/**
	 * 操作给定的二叉树，将其变换为源二叉树的镜像。

思路：使用递归或非递归方式交换每个节点的左右子树位置。
	 */
	public TreeNode mirror(TreeNode root) {
		if(root!=null) return root;
		TreeNode temp=root.left;
		root.left=mirror(root.right);
		root.right=mirror(temp);
		return root;
	}
	
	//比较容易理解的递归
	public void mirror2(TreeNode root) {
	    if (root == null)
	        return;
	    swap(root);
	    Mirror(root.left);
	    Mirror(root.right);
	}

	private void swap(TreeNode root) {
	    TreeNode t = root.left;
	    root.left = root.right;
	    root.right = t;
	}
	
	//非递归
	public void Mirror(TreeNode root) { 
		if (root == null)  return;  
		Stack<TreeNode> stack = new Stack<>(); 
		while (root != null || !stack.isEmpty()) { 
			while (root != null) { 
				TreeNode temp = root.left; 
				root.left = root.right; 
				root.right = temp; 
				stack.push(root); 
				root = root.left; 
			} 
			if (!stack.isEmpty()) { 
				root = stack.pop(); 
				root = root.right; 
			} 
		} 
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
