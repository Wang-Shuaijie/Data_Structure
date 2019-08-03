package com.java.��ָoffer;

public class Solution59 {
	/**
	 * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�
	 * ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
	 */
	public boolean isSymmetrical(TreeNode root) {
		/**
		 * ���õݹ�����жϣ��������������ӵ������������Һ��������������Һ��ӵ��������������ӣ�
		 * �������������ڵ��ֵ��ȣ����ǶԳƵġ�
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
	
	 
	//����Ȼ��Ƚ� 
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
