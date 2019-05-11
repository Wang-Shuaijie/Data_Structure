package com.demo.offer;

import java.util.Arrays;

public class Solution06 {
	/**
	 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
	 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
	 * 				1
	 * 			  /	  \
	 *           2     3
	 *          /     / \
	 *         4     5   6
	 *          \       /   
	 *           7     8
	 * ˼·�����ҳ����ڵ㣬�õݹ鹹�������
	 */
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if(pre.length==0 || in.length==0 || pre==null || in==null || pre.length!=in.length) return null;
		TreeNode root=new TreeNode(pre[0]);
		for(int i=0;i<pre.length;i++) {
			//�������ҵ����ڵ�
			if(pre[0]==in[i]) {
				//Arrays.copyOfRange(arr,from,to) ���������from��to��������to
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
