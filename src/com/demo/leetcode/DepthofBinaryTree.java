package com.demo.leetcode;

public class DepthofBinaryTree {
	/**
	 * ����һ�����������ҳ��������ȡ�

�����������Ϊ���ڵ㵽��ԶҶ�ӽڵ���·���ϵĽڵ�����

˵��: Ҷ�ӽڵ���ָû���ӽڵ�Ľڵ㡣

ʾ����
���������� [3,9,20,null,null,15,7]��

    3
   / \
  9  20
    /  \
   15   7

�������������� 3 ��

	 */
	//������
	public int maxDepth(TreeNode root) {
		if(root==null) return 0;
		if(root.left==null && root.right==null) return 1;
		int left=maxDepth(root.left)+1;
		int right=maxDepth(root.right)+1;
		return Math.max(left, right);
	}
	
	//��С���
	public int minDepth(TreeNode root) {
		if(root==null) return 0;
		if(root.left==null && root.right==null) return 1;
		int left=minDepth(root.left)+1;
		int right=minDepth(root.right)+1;
		if(left == 1)          //����1˵��û������������������Ϊ������Ž��������Ϊһ�������
	        left = Integer.MAX_VALUE;
	    if(right == 1)         //����1˵��û������������������Ϊ������Ž��������Ϊһ�������
	        right = Integer.MAX_VALUE;
	    return Math.min(left, right);
	}
}
