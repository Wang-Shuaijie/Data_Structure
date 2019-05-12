package com.demo.leetcode;

import java.util.Stack;

public class KthSmallestElementinaBST {
	/**
	 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
	 */
	public int kthSmallest(TreeNode root, int k) {
		//左<根<右
		int count=0;
		Stack<TreeNode> stack=new Stack<>();
		TreeNode p=root;
		while(p!=null || !stack.isEmpty()) {
			while(p!=null) {
				stack.push(p);
				p=p.left;
			}
			p=stack.peek();
			stack.pop();
			count++;
			if(count==k) return p.val;
			p=p.right;
		}
		return 0;
	}
	
	
	//递归
	public int kthSmallest2(TreeNode root, int k) {
		return kthSmallestDFS(root, k);
	}
	private int kthSmallestDFS(TreeNode root, int k) {
		if(root==null) return -1;
		int val=kthSmallestDFS(root.left, k);
		if(k==0) return val;
		if(--k==0) return root.val;
		return kthSmallestDFS(root.right, k);
	}
}
