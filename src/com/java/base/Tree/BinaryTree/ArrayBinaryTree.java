package com.java.base.Tree.BinaryTree;
/**
 * 数组表示一个二叉树(顺序存储结构)
 * @author WangShuaiJie
 *
 */
public class ArrayBinaryTree {
	int[] data;
	
	public ArrayBinaryTree(int[] data) {
		this.data=data;
	}
	
	public void frontShow() {
		frontShow(0);
	}
	
	public void frontShow(int index) {
		if(data==null || data.length==0) {
			return;
		}
		//先遍历当前节点内容
		System.out.print(data[index]);
		//2*n+1(左子树)
		if(2*index+1<data.length) {
			frontShow(2*index+1);
		}
		//2*n+2(右子树)
		if(2*index+2<data.length) {
			frontShow(2*index+2);
		}
	}
}
