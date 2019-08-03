package com.java.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution23 {
	/**
	 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
	 * 层次遍历二叉树
	 */
	public List<Integer> levelOrder(TreeNode root){
		List<Integer> res=new ArrayList<>();
		if(root==null) return  res;
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode temp=queue.poll();
			res.add(temp.val);
			if(temp.left!=null) queue.add(temp.left);
			if(temp.right!=null) queue.add(temp.right);
		}
		return res;
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
