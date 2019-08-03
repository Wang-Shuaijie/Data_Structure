package com.java.��ָoffer;

public class Solution50 {
	/**
	 * �����������ڵ����͹�������
	 */
	
	public TreeNode getLowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		//���Ƕ���������
		if(root==null) return null;
		if(root.val>Math.max(p.val, q.val)) {
			return getLowestCommonAncestor(root.left, p, q);
		}else if(root.val<Math.min(p.val, q.val)) {
			return getLowestCommonAncestor(root.right, p, q);
		}else {
			return root;
		}
	}
	
	public TreeNode getLowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		//������ͨ��
		if(root==null || p==root ||q==root) return root;
		TreeNode left=getLowestCommonAncestor2(root.left, p, q);
		TreeNode right=getLowestCommonAncestor2(root.right, p, q);
		return left==null?right:right==null?left:root;
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
