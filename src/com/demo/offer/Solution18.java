package com.demo.offer;

public class Solution18 {
	/**
	 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ��

˼·�������ڵ���ȣ����õݹ�Ƚ����ǵ������Ƿ���ȣ������ڵ㲻��ȣ������õݹ�ֱ������������в��ҡ�
	 */
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if(root1==null || root2==null) return false;
		return isSubtree(root1, root2)||isSubtree(root1.left, root2)||isSubtree(root1.right, root2);
	}
	
	private boolean isSubtree(TreeNode root1, TreeNode root2) {
		//˳���ܵߵ�
		if(root2==null) return true;
		if(root1==null) return false;
		if(root1.val==root2.val) {
			return isSubtree(root1.left, root2.left)&&isSubtree(root1.right, root2.right);
		}
		return false;
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
