package com.demo.base.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
	//节点的权
	int value;
	//左节点
	TreeNode left;
	//右节点
	TreeNode right;
	
	public TreeNode(int value) {
		this.value=value;
	}
	
	//设置左节点
	public void setLeft(TreeNode left) {
		this.left = left;
	}

	//设置右节点
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	//前序遍历(中,左,右)
	public void frontShow() {
		//先遍历当前节点
		System.out.print(this.value);
		//左节点
		if(left!=null) {
			left.frontShow();
		}
		//右节点
		if(right!=null) {
			right.frontShow();
		}
	}
	
	//前序遍历(中,左,右)非递归
	public void frontShow2() {
		Stack<TreeNode> stack=new Stack<>();
		TreeNode root=this;
		while(root!=null || !stack.empty()) {
			while(root!=null) {
				System.out.print(root.value);
				stack.push(root);
				root=root.left;
			}
			if(!stack.isEmpty()) {
				root=stack.pop();
				root=root.right;
			}
		}
	}	
	
	//中序遍历(左,中,右)
	public void middleShow() {
		//先遍历左节点
		if(left!=null) {
			left.middleShow();
		}
		//当前节点
		System.out.print(this.value);
		//右节点
		if(right!=null) {
			right.middleShow();
		}
	}
	
	//中序遍历(左,中,右)(非递归)
	public void middleShow2() {
		Stack<TreeNode> stack=new Stack<>();
		TreeNode root=this;
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

	//后序遍历(左,右,中)
	public void afterShow() {
		//左节点
		if(left!=null) {
			left.afterShow();
		}
		//右节点
		if(right!=null) {
			right.afterShow();
		}
		
		//当前节点
		System.out.print(this.value);
		
	}
	
	//后序遍历(左,右,中)非递归
	public void afterShow2() {
		Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        TreeNode root=this;
        int i=1;
        while(root!=null || !stack1.isEmpty()) {
        	while(root!=null) {
        		stack1.push(root);
        		stack2.push(0);
        		root=root.left;
        	}
        	while(!stack1.empty() && stack2.peek() == i){
                stack2.pop();
                System.out.print(stack1.pop());
            }
        	if(!stack1.empty())
            {
                stack2.pop();
                stack2.push(1);
                root = stack1.peek();
                root = root.right;
            }
        }
	}
	//层次遍历
	public void levelOrder() {
		Queue<TreeNode> queue=new LinkedList<>();
		if(this==null) return;
		queue.offer(this);
		while(!queue.isEmpty()) {
			TreeNode temp=queue.poll();
			System.out.print(temp.value);
			if(temp.left!=null) {
				queue.offer(temp.left);
			}
			if(temp.right!=null) {
				queue.offer(temp.right);
			}
		}
		
	}
	
	//前序查找
	public TreeNode frontSearch(int i) {
		TreeNode target=null;
		//对比当前节点值
		if(this.value==i) {
			return this;
		}else {
			//查找左节点
			if(left!=null) {
				target=left.frontSearch(i);
			}
			//如果在左边找到，target就不为空
			if(target!=null) {
				return target;
			}
			//查找右节点
			if(right!=null) {
				target=right.frontSearch(i);
			}

		}
		return target;
	}

	//删除一个子树
	public void delete(int i) {
		TreeNode parent=this;
		//判断左子树
		if(parent.left!=null && parent.left.value==i) {
			parent.left=null;
			return;
		}
		//判断右子树
		if(parent.right!=null && parent.right.value==i) {
			parent.right=null;
			return;
		}
		//没找到,递归
		parent=left;
		if(parent!=null) {
			parent.delete(i);
		}
		parent=right;
		if(parent!=null) {
			parent.delete(i);
		}
	}

	//交换左右节点
	public void ChangeLeftandRight() {
		TreeNode root=this;
		if(root==null) return ;
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		
		root.left.ChangeLeftandRight();
		root.right.ChangeLeftandRight();
	}
	
	//交换左右节点（非递归）
	public void ChangeLeftandRight2() {
		TreeNode root=this;
		if(root==null) return ;
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		TreeNode node,temp;
		while(!queue.isEmpty()) {
			node=queue.poll();
			temp=node.left;
			node.left=node.right;
			node.right=temp;
			if(node.left!=null) {
				queue.add(node.left);
			}
			if(node.right!=null) {
				queue.add(node.right);
			}
		}
	}
	

}
