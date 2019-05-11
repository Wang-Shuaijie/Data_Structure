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
	//递归
	public TreeNode invertTree(TreeNode root) {
		if(root==null) return root;
		TreeNode temp=root.left;
		root.left=invertTree(root.right);
		root.right=invertTree(temp);
		return root;
	}
	
	//非递归
	public TreeNode invertTree2(TreeNode root) {
		if(root==null) return root;
		//二叉树的层序遍历一样，需要用queue来辅助，先把根节点排入队列中，然后从队中取出来，交换其左右节点，如果存在则分别将左右节点在排入队列中，以此类推直到队列中木有节点了停止循环，返回root即可
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
