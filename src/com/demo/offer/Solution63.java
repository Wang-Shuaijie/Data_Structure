package com.demo.offer;

import java.util.Stack;

public class Solution63 {
	/**
	 * ����һ�Ŷ��������������ҳ����еĵ�k��Ľ��
	 * �����������������������˳���ӡ�������þ�������õ�˳��
	 * ��k�������ǵ�K��Ľڵ㣬�ֱ�ݹ�������������ĵ�K���ڵ㣬
	 * ��ʹ�÷ǵݹ����ջ�ķ�ʽ���ң���count=kʱ���ظ��ڵ㡣
	 */
	
	public int kthlargest(TreeNode root, int k) {
		//��<��<��
		int count=0;
		Stack<TreeNode> stack=new Stack<>();
		TreeNode p=root;
		while(p!=null || !stack.isEmpty()) {
			while(p!=null) {
				stack.push(p);
				p=p.right;
			}
			p=stack.peek();
			stack.pop();
			count++;
			if(count==k) return p.val;
			p=p.left;
		}
		return 0;
	}
	
	//�ݹ�
	public int kthlargest2(TreeNode root, int k) {
		return kthlargestDFS(root, k);
	}
	private int kthlargestDFS(TreeNode root, int k) {
		if(root==null) return -1;
		int val=kthlargestDFS(root.right, k);
		if(k==0) return val;
		if(--k==0) return root.val;
		return kthlargestDFS(root.left, k);
	}
	
	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val=x;
		}
	}
	
}
