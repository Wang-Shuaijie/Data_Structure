package com.java.base.Tree.BinaryTree;

public class BinaryTree {
	//���ڵ�
	TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	//ǰ�����
	public void frontShow() {
		if(root!=null) {
			root.frontShow();
		}
	}
	
	//�������
	public void midShow() {
		if(root!=null) { 
			root.middleShow();
		}
	}
	
	//�������
	public void afterShow() {
		if(root!=null) {
			root.afterShow();
		}
		
	}
	
	//��α���
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
	
	//�������ҽڵ�
	public void ChangeLeftandRight() {
		root.ChangeLeftandRight();
	}
}
