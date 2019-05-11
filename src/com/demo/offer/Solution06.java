package com.demo.offer;

import java.util.Arrays;

public class Solution06 {
	/**
	 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
	 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
	 * 				1
	 * 			  /	  \
	 *           2     3
	 *          /     / \
	 *         4     5   6
	 *          \       /   
	 *           7     8
	 * 思路：先找出根节点，用递归构造二叉树
	 */
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if(pre.length==0 || in.length==0 || pre==null || in==null || pre.length!=in.length) return null;
		TreeNode root=new TreeNode(pre[0]);
		for(int i=0;i<pre.length;i++) {
			//在中序找到根节点
			if(pre[0]==in[i]) {
				//Arrays.copyOfRange(arr,from,to) 复制数组从from到to，不包括to
				root.left=reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
				root.right=reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
			}
		}
		return root;
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
