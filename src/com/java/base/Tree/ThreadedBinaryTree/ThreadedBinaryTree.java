package com.java.base.Tree.ThreadedBinaryTree;
/**
 * 线索二叉树
 * @author WangShuaiJie
 *
 */
public class ThreadedBinaryTree {
	ThreadedNode root;
	//用于临时存储前驱结点
	ThreadedNode pre=null;
	
	public void setRoot(ThreadedNode root) {
		this.root = root;
	}
	
	public ThreadedNode getRoot() {
		return root;
	}
	
	//遍历线索二叉树
	public void threadIterate() {
		//用于临时存储当前遍历节点
		ThreadedNode node=root;
		while(node!=null) {
			//循环找到最开始的节点
			while(node.leftType==0) {
				node=node.leftNode;
			}
			System.out.print(node.value);
			//如果当前节点的右指针指向的是后继节点，可能后继结点还有后继节点
			while(node.rightType==1) {
				node=node.rightNode;
				System.out.print(node.value);
			}
			node=node.rightNode;
		}
	}
	
	
	//中序线索二叉树
	public void threadNodes() {
		threadNodes(root);
	}
	
	public void threadNodes(ThreadedNode node) {
		//当前节点为空
		if(node==null) {
			return ;
		}
		//处理左子树
		threadNodes(node.leftNode);
		//处理前驱节点
		if(node.leftNode==null) {
			//让当前节点的左指针指向前驱节点
			node.leftNode=pre;
			//改变当前节点左指针的类型
			node.leftType=1;
		}
		//如果前驱结点的右指针是null
		if(pre!=null && pre.rightNode==null) {
			//前驱结点的右指针指向当前节点
			pre.rightNode=node;
			//改变前驱结点的右指针类型
			pre.rightType=1;
		}
		//每处理一个节点，当前节点是下一个节点的前驱结点
		pre=node;
		//处理右子树
		threadNodes(node.rightNode);
	}
	
	//前序遍历
	public void frontShow() {
		if(root!=null) {
			root.frontShow();
		}
	}
}
