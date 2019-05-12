package com.demo.leetcode;

import java.util.Stack;

public class KthSmallestElementinaBST {
	/**
	 * ����һ����������������дһ������ kthSmallest ���������е� k ����С��Ԫ�ء�

˵����
����Լ��� k ������Ч�ģ�1 �� k �� ����������Ԫ�ظ�����

ʾ�� 1:

����: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
���: 1
	 */
	public int kthSmallest(TreeNode root, int k) {
		//��<��<��
		int count=0;
		Stack<TreeNode> stack=new Stack<>();
		TreeNode p=root;
		while(p!=null || !stack.isEmpty()) {
			while(p!=null) {
				stack.push(p);
				p=p.left;
			}
			p=stack.peek();
			stack.pop();
			count++;
			if(count==k) return p.val;
			p=p.right;
		}
		return 0;
	}
	
	
	//�ݹ�
	public int kthSmallest2(TreeNode root, int k) {
		return kthSmallestDFS(root, k);
	}
	private int kthSmallestDFS(TreeNode root, int k) {
		if(root==null) return -1;
		int val=kthSmallestDFS(root.left, k);
		if(k==0) return val;
		if(--k==0) return root.val;
		return kthSmallestDFS(root.right, k);
	}
}
