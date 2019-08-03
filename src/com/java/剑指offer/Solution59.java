package com.java.剑指offer;

public class Solution59 {
	/**
	 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
	 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
	 */
	public boolean isSymmetrical(TreeNode root) {
		/**
		 * 利用递归进行判断，若左子树的左孩子等于右子树的右孩子且左子树的右孩子等于右子树的左孩子，
		 * 并且左右子树节点的值相等，则是对称的。
		 */
		if(root==null) return true;
		return symmetrical(root.left, root.right);
	}
	 public boolean symmetrical(TreeNode left, TreeNode right) {
		 if(left==null && right==null) return true;
		 if(left==null || right==null) return false;
		 if(left.val==right.val) {
			 return symmetrical(left.left,right.right) && symmetrical(left.right,right.left);
		 }
		 return false;
	 }
	
	 
	//求镜像然后比较 
	public boolean isSymmetrical2(TreeNode root) {
		return root==mirror(root);
	}
	
	private TreeNode mirror(TreeNode root) {
		if(root==null) return root;
		TreeNode temp=root.left;
		root.left=mirror(root.right);
		root.right=mirror(temp);
		return root;
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
