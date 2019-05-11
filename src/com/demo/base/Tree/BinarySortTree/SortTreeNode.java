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
	 * 向子树添加节点
	 * @param node
	 */
	public void add(SortTreeNode node) {
		if(node==null) {
			return;
		}
		//递归添加，判断传入的节点值比根节点大还是小
		if(node.value<this.value) {
			//如果左节点为空
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
	 * 查找节点
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
	 * 查找父节点
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
	 * 中序遍历
	 */
	public void inorder() {
		//递归写法
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
