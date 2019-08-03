package com.java.base.Tree.ThreadedBinaryTree;

public class ThreadedNode {
	//�ڵ��Ȩ
	int value;
	//�����
	ThreadedNode leftNode;
	//�Ҷ���
	ThreadedNode rightNode;
	//��ʶָ������
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
	
	//ǰ�����
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
