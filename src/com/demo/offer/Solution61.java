package com.demo.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution61 {
	/**
	 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。

思路：利用辅助空间链表或队列来存储节点，每层输出。
	 */
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> res=new ArrayList<>();
		if(root==null) return res;
		Queue<TreeNode> q1=new LinkedList<>();
		Queue<TreeNode> q2=new LinkedList<>();
		q1.add(root);
		while(!q1.isEmpty()) {
			List<Integer> list=new ArrayList<>();
			for(int i=q1.size();i>0;i--) {
				TreeNode temp=q1.poll();
				list.add(temp.val);
				if(temp.left!=null) q1.add(temp.left);
				if(temp.right!=null) q1.add(temp.right);
			}
			res.add(list);
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
