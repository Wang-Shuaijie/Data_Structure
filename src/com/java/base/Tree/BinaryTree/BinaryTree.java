package com.java.base.Tree.BinaryTree;

public class BinaryTree {
	//根节点
	TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	//前序遍历
	public void frontShow() {
		if(root!=null) {
			root.frontShow();
		}
	}
	
	//中序遍历
	public void midShow() {
		if(root!=null) { 
			root.middleShow();
		}
	}
	
	//后序遍历
	public void afterShow() {
		if(root!=null) {
			root.afterShow();
		}
		
	}
	
	//层次遍历
	public void levelOrder() {
		if(root!=null) {
			root.levelOrder();
		}
	}

	public TreeNode frontSearch(int i) {		
		return root.frontSearch(i);
	}

	public void delete(int i) {
		if(root.value==i) {
			root=null;
		}else {
			root.delete(i);
		}
		
	}
	
	//交换左右节点
	public void ChangeLeftandRight() {
		root.ChangeLeftandRight();
	}
}
