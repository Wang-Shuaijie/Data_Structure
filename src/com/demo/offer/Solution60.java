package com.demo.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution60 {
	/**
	 * ��ʵ��һ����������֮���δ�ӡ��������
	 * ��һ�а��մ����ҵ�˳���ӡ��
	 * �ڶ��㰴�մ��������˳���ӡ��
	 * �����а��մ����ҵ�˳���ӡ���������ơ�
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
