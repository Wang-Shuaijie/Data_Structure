package com.demo.offer;

import java.util.Stack;

public class Solution27 {
	/**
	 * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
���罫��Ԫ������
                                            10
                                          /    \
                                        6      14
                                      /   \   /   \
                                     4     8 12   16
ǰ�����ת����˫������
4=6=8=10=12=14=16��
˼·������һ�������β�ڵ㣬�ݹ鴦��������������󷵻������ͷ�ڵ�
	 */
	public TreeNode convert(TreeNode root) {
		if(root==null) return null;
		if(root.left==null && root.right==null) return root;
		TreeNode left=convert(root.left);
		// 1.�������������˫��������������ͷ�ڵ�
		TreeNode p=left;
		// 2.��λ��������˫�������һ���ڵ�
		while(p!=null && p.right!=null) {
			p=p.right;
		}
		// 3.�������������Ϊ�յĻ�������ǰroot׷�ӵ�����������
		if(left!=null) {
			p.right=root;
			root.left=p;
		}
		// 4.�������������˫��������������ͷ�ڵ�
		TreeNode right=convert(root.right);
		// 5.�������������Ϊ�յĻ�����������׷�ӵ�root�ڵ�֮��
		if(right!=null) {
			root.right=right;
			right.left=root;
		}
		return left!=null?left:root;
	}
	
	//�ǵݹ�
	public TreeNode ConvertBSTToBiList(TreeNode root) {
        if(root==null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;// ���ڱ�������������е���һ�ڵ�
        boolean isFirst = true;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                root = p;// ��������������еĵ�һ���ڵ��Ϊroot
                pre = root;
                isFirst = false;
            }else{
                pre.right = p;
                p.left = pre;
                pre = p;
            }      
            p = p.right;
        }
        return root;
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
