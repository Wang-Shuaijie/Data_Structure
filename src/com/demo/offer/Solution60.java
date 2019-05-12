package com.demo.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution60 {
	/**
	 * 请实现一个函数按照之字形打印二叉树，
	 * 第一行按照从左到右的顺序打印，
	 * 第二层按照从右至左的顺序打印，
	 * 第三行按照从左到右的顺序打印，依此类推。
	 */
	public List<List<Integer>> print(TreeNode root){
		List<List<Integer>> res=new ArrayList<>();
		if(root==null) return res;
		Queue<TreeNode> q1=new LinkedList<>();
		q1.add(root);
		int level=1;
		while(!q1.isEmpty()) {
			List<Integer> list=new ArrayList<>();
			for(int i=q1.size();i>0;i--) {
				TreeNode temp=q1.poll();
				list.add(temp.val);
				if(level%2==0) {
					if(temp.left!=null) q1.add(temp.left);
					if(temp.right!=null) q1.add(temp.right);
				}else {
					if(temp.right!=null) q1.add(temp.right);
					if(temp.left!=null) q1.add(temp.left);
				}
			}
			res.add(list);
			level++;
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
