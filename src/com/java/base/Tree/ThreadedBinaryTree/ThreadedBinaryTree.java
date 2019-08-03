package com.java.base.Tree.ThreadedBinaryTree;
/**
 * ����������
 * @author WangShuaiJie
 *
 */
public class ThreadedBinaryTree {
	ThreadedNode root;
	//������ʱ�洢ǰ�����
	ThreadedNode pre=null;
	
	public void setRoot(ThreadedNode root) {
		this.root = root;
	}
	
	public ThreadedNode getRoot() {
		return root;
	}
	
	//��������������
	public void threadIterate() {
		//������ʱ�洢��ǰ�����ڵ�
		ThreadedNode node=root;
		while(node!=null) {
			//ѭ���ҵ��ʼ�Ľڵ�
			while(node.leftType==0) {
				node=node.leftNode;
			}
			System.out.print(node.value);
			//�����ǰ�ڵ����ָ��ָ����Ǻ�̽ڵ㣬���ܺ�̽�㻹�к�̽ڵ�
			while(node.rightType==1) {
				node=node.rightNode;
				System.out.print(node.value);
			}
			node=node.rightNode;
		}
	}
	
	
	//��������������
	public void threadNodes() {
		threadNodes(root);
	}
	
	public void threadNodes(ThreadedNode node) {
		//��ǰ�ڵ�Ϊ��
		if(node==null) {
			return ;
		}
		//����������
		threadNodes(node.leftNode);
		//����ǰ���ڵ�
		if(node.leftNode==null) {
			//�õ�ǰ�ڵ����ָ��ָ��ǰ���ڵ�
			node.leftNode=pre;
			//�ı䵱ǰ�ڵ���ָ�������
			node.leftType=1;
		}
		//���ǰ��������ָ����null
		if(pre!=null && pre.rightNode==null) {
			//ǰ��������ָ��ָ��ǰ�ڵ�
			pre.rightNode=node;
			//�ı�ǰ��������ָ������
			pre.rightType=1;
		}
		//ÿ����һ���ڵ㣬��ǰ�ڵ�����һ���ڵ��ǰ�����
		pre=node;
		//����������
		threadNodes(node.rightNode);
	}
	
	//ǰ�����
	public void frontShow() {
		if(root!=null) {
			root.frontShow();
		}
	}
}
