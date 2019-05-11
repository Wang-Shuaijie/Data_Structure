package com.demo.offer;

import java.util.Stack;

public class Solution63 {
	/**
	 * 给定一颗二叉搜索树，请找出其中的第k大的结点
	 * 二叉搜索树按照中序遍历的顺序打印出来正好就是排序好的顺序，
	 * 第k个结点就是第K大的节点，分别递归查找左右子树的第K个节点，
	 * 或使用非递归借用栈的方式查找，当count=k时返回根节点。
	 */
	
	public int kthlargest(TreeNode root, int k) {
		//左<根<右
		int count=0;
		Stack<TreeNode> stack=new Stack<>();
		TreeNode p=root;
		while(p!=null || !stack.isEmpty()) {
			while(p!=null) {
				stack.push(p);
				p=p.right;
			}
			p=stack.peek();
			stack.pop();
			count++;
			if(count==k) return p.val;
			p=p.left;
		}
		return 0;
	}
	
	//递归
	public int kthlargest2(TreeNode root, int k) {
		return kthlargestDFS(root, k);
	}
	private int kthlargestDFS(TreeNode root, int k) {
		if(root==null) return -1;
		int val=kthlargestDFS(root.right, k);
		if(k==0) return val;
		if(--k==0) return root.val;
		return kthlargestDFS(root.left, k);
	}
	
	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val=x;
		}
	}
	
}
