package com.java.base.Tree.BinaryTree;
/**
 * �����ʾһ��������(˳��洢�ṹ)
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
		//�ȱ�����ǰ�ڵ�����
		System.out.print(data[index]);
		//2*n+1(������)
		if(2*index+1<data.length) {
			frontShow(2*index+1);
		}
		//2*n+2(������)
		if(2*index+2<data.length) {
			frontShow(2*index+2);
		}
	}
}
