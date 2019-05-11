package com.demo.LeetCode;

import java.util.Stack;

public class ValidateBinarySearchTree {
	/**
	 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

    节点的左子树只包含小于当前节点的数。
    节点的右子树只包含大于当前节点的数。
    所有左子树和右子树自身必须也是二叉搜索树。

示例 1:

输入:
    2
   / \
  1   3
输出: true

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
	
	//非递归
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
