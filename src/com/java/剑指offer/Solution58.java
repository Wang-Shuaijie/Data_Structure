package com.java.剑指offer;

public class Solution58 {
	/**
	 * 二叉树的下一个节点
	 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
	 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
	 */
	public TreeLinkNode getNext(TreeLinkNode node) {
		if(node==null) return null;
		if(node.right!=null) {
			node=node.right;
			while(node.left!=null) {
				node=node.left;
			}
			return node;
		}
		while(node.next!=null) {
			// 找第一个当前节点是父节点左孩子 的节点
			TreeLinkNode parent=node.next;
			if(parent.left==node) {
				return parent;
			}
			node=node.next;
		}
		return null;
	}
	
	class TreeLinkNode{
		int val;
		TreeLinkNode left;
		TreeLinkNode right;
        // next指向父结点，题目中给定的
		TreeLinkNode next;
		public TreeLinkNode(int x) {
			val=x;
		}
	}
}
