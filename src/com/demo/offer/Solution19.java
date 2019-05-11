package com.demo.offer;

import java.util.Stack;

public class Solution19 {
	/**
	 * ���������Ķ�����������任ΪԴ�������ľ���

˼·��ʹ�õݹ��ǵݹ鷽ʽ����ÿ���ڵ����������λ�á�
	 */
	public TreeNode mirror(TreeNode root) {
		if(root!=null) return root;
		TreeNode temp=root.left;
		root.left=mirror(root.right);
		root.right=mirror(temp);
		return root;
	}
	
	//�Ƚ��������ĵݹ�
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
	
	//�ǵݹ�
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
