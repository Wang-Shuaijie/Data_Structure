package com.demo.offer;

public class Solution18 {
	/**
	 * 输入两棵二叉树A，B，判断B是不是A的子结构。

思路：若根节点相等，利用递归比较他们的子树是否相等，若根节点不相等，则利用递归分别在左右子树中查找。
	 */
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if(root1==null || root2==null) return false;
		return isSubtree(root1, root2)||isSubtree(root1.left, root2)||isSubtree(root1.right, root2);
	}
	
	private boolean isSubtree(TreeNode root1, TreeNode root2) {
		//顺序不能颠倒
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
