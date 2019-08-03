package com.java.base.Tree.ThreadedBinaryTree;

public class ThreadedNode {
	//节点的权
	int value;
	//左儿子
	ThreadedNode leftNode;
	//右儿子
	ThreadedNode rightNode;
	//标识指针类型
	int leftType;
	int rightType;
	
	public ThreadedNode(int value) {
		this.value=value;
	}
	
	public void setLeftNode(ThreadedNode leftNode) {
		this.leftNode = leftNode;
	}
	
	public void setRightNode(ThreadedNode rightNode) {
		this.rightNode = rightNode;
	}
	
	//前序遍历
	public void frontShow() {
		System.out.print(this.value);
		if(this.leftNode!=null) {
			leftNode.frontShow();
		}
		if(this.rightNode!=null) {
			rightNode.frontShow();
		}
	}
}
