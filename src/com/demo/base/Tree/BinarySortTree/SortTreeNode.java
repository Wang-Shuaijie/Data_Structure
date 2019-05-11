package com.demo.base.Tree.BinarySortTree;

import java.util.Stack;

public class SortTreeNode {
	int value;
	SortTreeNode left;
	SortTreeNode right;
	
	public SortTreeNode(int value) {
		this.value=value;
	}
	
	/**
	 * ��������ӽڵ�
	 * @param node
	 */
	public void add(SortTreeNode node) {
		if(node==null) {
			return;
		}
		//�ݹ���ӣ��жϴ���Ľڵ�ֵ�ȸ��ڵ����С
		if(node.value<this.value) {
			//�����ڵ�Ϊ��
			if(this.left==null) {
				this.left=node;
			}else {
				this.left.add(node);
			}
		}else {
			if(this.right==null) {
				this.right=node;
			}else {
				this.right.add(node);
			}
		}
	}
	/**
	 * ���ҽڵ�
	 * @param value
	 * @return
	 */
	public SortTreeNode search(int value){
		if(this.value==value) {
			return this;
		}
		else {
			if(this.value>value) {
				if(left==null) return null;
				return left.search(value);
			}else {
				if(right==null) return null;
				return right.search(value); 
			}
		}
	}
	/**
	 * ���Ҹ��ڵ�
	 * @param value
	 * @return
	 */
	public SortTreeNode searchParent(int value) {
		if((this.left!=null && this.left.value==value) || (this.right!=null && this.right.value==value)) {
			return this;
		}else {
			if(this.value>value) {
				if(this.left==null) return null;
				return this.left.searchParent(value);
			}else {
				if(this.right==null) return null;
				return this.right.searchParent(value);
			}
		}
	}
	
	
	/**
	 * �������
	 */
	public void inorder() {
		//�ݹ�д��
		/*if(left!=null) {
			left.inorder();
		}
		System.out.print(this.value+" ");
		if(right!=null) {
			right.inorder();
		}*/
		Stack<SortTreeNode> stack=new Stack<>();
		SortTreeNode root=this;
		while(root!=null || !stack.isEmpty()) {
			while(root!=null) {
				stack.push(root);
				root=root.left;
			}
			if(!stack.isEmpty()) {
				root=stack.pop();
				System.out.print(root.value);
				root=root.right;
			}
		}
	}

}
