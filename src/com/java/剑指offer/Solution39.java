package com.java.��ָoffer;

public class Solution39 {
	/**
	 * ����һ�ö����������������ȡ��Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
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
