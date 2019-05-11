package com.demo.offer;

public class Solution40 {
	/**
	 * ����һ�ö��������жϸö������Ƿ���ƽ�������
	 */
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
	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			x=val;
		}
	}
}
