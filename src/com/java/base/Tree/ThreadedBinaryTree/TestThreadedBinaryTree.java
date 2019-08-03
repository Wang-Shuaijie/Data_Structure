package com.java.base.Tree.ThreadedBinaryTree;

public class TestThreadedBinaryTree {
	public static void main(String[] args) {
		ThreadedBinaryTree binTree=new ThreadedBinaryTree();
		ThreadedNode root=new ThreadedNode(1);
		binTree.setRoot(root);
		ThreadedNode rootL=new ThreadedNode(2);
		ThreadedNode rootR=new ThreadedNode(3);
		root.setLeftNode(rootL);
		root.setRightNode(rootR);
		
		rootL.setLeftNode(new ThreadedNode(4));
		rootL.setRightNode(new ThreadedNode(5));
		rootR.setLeftNode(new ThreadedNode(6));
		rootR.setRightNode(new ThreadedNode(7));
		
		binTree.frontShow();
		System.out.println();
		binTree.threadNodes();
		binTree.threadIterate();
	}
}
