package com.java.leetcode;

import java.util.Arrays;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	/**
	 * ����һ������ǰ�������������������������

ע��:
����Լ�������û���ظ���Ԫ�ء�

���磬����

ǰ����� preorder = [3,9,20,15,7]
������� inorder = [9,3,15,20,7]

�������µĶ�������

    3
   / \
  9  20
    /  \
   15   7


	 */
	 public TreeNode buildTree(int[] preorder, int[] inorder) {
	        if(preorder.length!=inorder.length || preorder==null || preorder.length==0 || inorder==null || inorder.length==0) return null;
	        TreeNode root=new TreeNode(preorder[0]);
	        for(int i=0;i<preorder.length;i++){
	            if(inorder[i]==preorder[0]){
	                root.left=buildTree(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
	                root.right=buildTree(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
	            }
	        }
	        return root;
	    }
}
