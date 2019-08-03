package com.java.base.Tree.BinaryTree;

public class TestBinaryTree {
	public static void main(String[] args) {
		//����һ����
		BinaryTree btree=new BinaryTree();
		//����һ�����ڵ�
		TreeNode root=new TreeNode(1);
		btree.setRoot(root);
		
		//���������ڵ�
		TreeNode rootL=new TreeNode(2);
		TreeNode rootR=new TreeNode(3);		
		//��Ϊ���ڵ����ڵ�
		root.setLeft(rootL);
		//��Ϊ���ڵ���ҽڵ�
		root.setRight(rootR);
		
		//Ϊ�ڶ�����ӽڵ�
		rootL.setLeft(new TreeNode(4));
		rootL.setRight(new TreeNode(5));
		rootR.setLeft(new TreeNode(6));
		rootR.setRight(new TreeNode(7));
		
		btree.levelOrder();
		System.out.println();
		//ǰ�����
		btree.frontShow();//1245367
		System.out.println();
		//�������
		btree.midShow();//4251637
		System.out.println();
		//�������
		btree.afterShow();//4526731
		System.out.println();
		//ǰ�����
		TreeNode res=btree.frontSearch(5);
		System.out.println(res);
		System.out.println();
		//ɾ��һ���ڵ�
		btree.delete(5);
		btree.frontShow();
		System.out.println();
	}
}
