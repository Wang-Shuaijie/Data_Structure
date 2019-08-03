package com.java.leetcode;

import java.util.Arrays;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	/**
	 * ����һ��������������������������������

ע��:
����Լ�������û���ظ���Ԫ�ء�

���磬����

������� inorder = [9,3,15,20,7]
������� postorder = [9,15,7,20,3]

�������µĶ�������

    3
   / \
  9  20
    /  \
   15   7


	 */
	 public TreeNode buildTree(int[] inorder, int[] postorder) {
		 if(postorder.length!=inorder.length || postorder==null || postorder.length==0 || inorder==null || inorder.length==0) return null;
	        TreeNode root=new TreeNode(postorder[postorder.length-1]);
	        for(int i=0;i<inorder.length;i++) {
	        	if(inorder[i]==postorder[postorder.length-1]) {
	        		root.left=buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
	        		root.right=buildTree(Arrays.copyOfRange(inorder, i+1, inorder.length), Arrays.copyOfRange(postorder, i, postorder.length-1));
	        	}
	        }
	        return root;
	 }
}
