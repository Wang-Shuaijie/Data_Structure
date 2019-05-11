package com.demo.LeetCode;

public class FlattenBinaryTreetoLinkedList {
	/**
	 * ����һ����������ԭ�ؽ���չ��Ϊ����

���磬����������

    1
   / \
  2   5
 / \   \
3   4   6

����չ��Ϊ��

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6


	 */
	
	public void flatten(TreeNode root) {
		/*
		 * ������DFS��˼·�ҵ������ӽڵ㣬Ȼ��ص��丸�ڵ㣬���丸�ڵ�����ӽڵ�Ͽ�����ԭ���ӽ�����ϸ��ڵ�����ӽڵ��ϣ�Ȼ���ٰ�ԭ���ӽڵ����������ӽڵ�����ӽڵ��ϣ�Ȼ���ٻص���һ���ڵ�����ͬ����
		 */
		if(root==null) return ;
		if(root.left!=null) flatten(root.left);
		if(root.right!=null) flatten(root.right);
		TreeNode temp=root.right;
		root.right=root.left;
		root.left=null;
		while(root.right!=null) {
			root=root.right;
		}
		root.right=temp;
	}
	
	
	private TreeNode prev=null;
	public void flatten2(TreeNode root) {
		if(root==null) return;
		flatten2(root.right);
		flatten2(root.left);
		root.right=prev;
		root.left=null;
		prev=root;
	}
	
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val=x;
	}
}
