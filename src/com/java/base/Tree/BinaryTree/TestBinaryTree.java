package com.java.base.Tree.BinaryTree;

public class TestBinaryTree {
	public static void main(String[] args) {
		//创建一棵树
		BinaryTree btree=new BinaryTree();
		//创建一个根节点
		TreeNode root=new TreeNode(1);
		btree.setRoot(root);
		
		//创建两个节点
		TreeNode rootL=new TreeNode(2);
		TreeNode rootR=new TreeNode(3);		
		//作为根节点的左节点
		root.setLeft(rootL);
		//作为根节点的右节点
		root.setRight(rootR);
		
		//为第二层添加节点
		rootL.setLeft(new TreeNode(4));
		rootL.setRight(new TreeNode(5));
		rootR.setLeft(new TreeNode(6));
		rootR.setRight(new TreeNode(7));
		
		btree.levelOrder();
		System.out.println();
		//前序遍历
		btree.frontShow();//1245367
		System.out.println();
		//中序遍历
		btree.midShow();//4251637
		System.out.println();
		//后序遍历
		btree.afterShow();//4526731
		System.out.println();
		//前序查找
		TreeNode res=btree.frontSearch(5);
		System.out.println(res);
		System.out.println();
		//删除一个节点
		btree.delete(5);
		btree.frontShow();
		System.out.println();
	}
}
