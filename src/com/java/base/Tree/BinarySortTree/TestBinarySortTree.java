package com.java.base.Tree.BinarySortTree;

public class TestBinarySortTree {
	public static void main(String[] args) {
		int[] arr=new int[] {4,1,2,6,3,8,7,5};
		BinarySortTree btree=new BinarySortTree();
		for(int i:arr) {
			btree.add(new SortTreeNode(i));
		}
		btree.inorder();
		System.out.println();
		btree.delete(5);
		btree.inorder();
		System.out.println();
	}
}
