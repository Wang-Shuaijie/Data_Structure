package com.java.��ָoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution23 {
	/**
	 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
	 * ��α���������
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
