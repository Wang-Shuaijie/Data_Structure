package com.demo.offer;

import java.util.Stack;

public class Solution27 {
	/**
	 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
比如将二元查找树
                                            10
                                          /    \
                                        6      14
                                      /   \   /   \
                                     4     8 12   16
前序遍历转换成双向链表
4=6=8=10=12=14=16。
思路：定义一个链表的尾节点，递归处理左右子树，最后返回链表的头节点
	 */
	public TreeNode convert(TreeNode root) {
		if(root==null) return null;
		if(root.left==null && root.right==null) return root;
		TreeNode left=convert(root.left);
		// 1.将左子树构造成双链表，并返回链表头节点
		TreeNode p=left;
		// 2.定位至左子树双链表最后一个节点
		while(p!=null && p.right!=null) {
			p=p.right;
		}
		// 3.如果左子树链表不为空的话，将当前root追加到左子树链表
		if(left!=null) {
			p.right=root;
			root.left=p;
		}
		// 4.将右子树构造成双链表，并返回链表头节点
		TreeNode right=convert(root.right);
		// 5.如果右子树链表不为空的话，将该链表追加到root节点之后
		if(right!=null) {
			root.right=right;
			right.left=root;
		}
		return left!=null?left:root;
	}
	
	//非递归
	public TreeNode ConvertBSTToBiList(TreeNode root) {
        if(root==null)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null;// 用于保存中序遍历序列的上一节点
        boolean isFirst = true;
        while(p!=null||!stack.isEmpty()){
            while(p!=null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            if(isFirst){
                root = p;// 将中序遍历序列中的第一个节点记为root
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
