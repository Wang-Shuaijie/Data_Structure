package com.demo.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
	/**
	 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9

to

     4
   /   \
  7     2
 / \   / \
9   6 3   1
	 * 
	 */
	//�ݹ�
	public TreeNode invertTree(TreeNode root) {
		if(root==null) return root;
		TreeNode temp=root.left;
		root.left=invertTree(root.right);
		root.right=invertTree(temp);
		return root;
	}
	
	//�ǵݹ�
	public TreeNode invertTree2(TreeNode root) {
		if(root==null) return root;
		//�������Ĳ������һ������Ҫ��queue���������ȰѸ��ڵ���������У�Ȼ��Ӷ���ȡ���������������ҽڵ㣬���������ֱ����ҽڵ�����������У��Դ�����ֱ��������ľ�нڵ���ֹͣѭ��������root����
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode node=queue.poll();
			TreeNode temp=node.left;
			node.left=node.right;
			node.right=temp;
			if(node.left!=null) queue.add(node.left);
			if(node.right!=null) queue.add(node.right);
		}
		return root;
	}
}
