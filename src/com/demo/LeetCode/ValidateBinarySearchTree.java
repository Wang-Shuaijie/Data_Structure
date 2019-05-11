package com.demo.LeetCode;

import java.util.Stack;

public class ValidateBinarySearchTree {
	/**
	 * ����һ�����������ж����Ƿ���һ����Ч�Ķ�����������

����һ��������������������������

    �ڵ��������ֻ����С�ڵ�ǰ�ڵ������
    �ڵ��������ֻ�������ڵ�ǰ�ڵ������
    �������������������������Ҳ�Ƕ�����������

ʾ�� 1:

����:
    2
   / \
  1   3
���: true

	 */
	public boolean isValidBST(TreeNode root) {
		if(root==null) return true;
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
	private boolean isValidBST(TreeNode root, long min, long max) {
		if(root==null) return true;
		else if(root.val<=min || root.val>=max)  return false;
		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
	}
	
	//�ǵݹ�
	public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode p = root, pre = null;
        while (p != null || !s.empty()) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            if (pre != null && p.val <= pre.val) return false;
            pre = p;
            p = p.right;
        }
        return true;
    }
}
