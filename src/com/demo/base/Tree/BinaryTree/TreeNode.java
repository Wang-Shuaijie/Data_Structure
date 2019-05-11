package com.demo.base.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
	//�ڵ��Ȩ
	int value;
	//��ڵ�
	TreeNode left;
	//�ҽڵ�
	TreeNode right;
	
	public TreeNode(int value) {
		this.value=value;
	}
	
	//������ڵ�
	public void setLeft(TreeNode left) {
		this.left = left;
	}

	//�����ҽڵ�
	public void setRight(TreeNode right) {
		this.right = right;
	}
	
	//ǰ�����(��,��,��)
	public void frontShow() {
		//�ȱ�����ǰ�ڵ�
		System.out.print(this.value);
		//��ڵ�
		if(left!=null) {
			left.frontShow();
		}
		//�ҽڵ�
		if(right!=null) {
			right.frontShow();
		}
	}
	
	//ǰ�����(��,��,��)�ǵݹ�
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
	
	//�������(��,��,��)
	public void middleShow() {
		//�ȱ�����ڵ�
		if(left!=null) {
			left.middleShow();
		}
		//��ǰ�ڵ�
		System.out.print(this.value);
		//�ҽڵ�
		if(right!=null) {
			right.middleShow();
		}
	}
	
	//�������(��,��,��)(�ǵݹ�)
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

	//�������(��,��,��)
	public void afterShow() {
		//��ڵ�
		if(left!=null) {
			left.afterShow();
		}
		//�ҽڵ�
		if(right!=null) {
			right.afterShow();
		}
		
		//��ǰ�ڵ�
		System.out.print(this.value);
		
	}
	
	//�������(��,��,��)�ǵݹ�
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
	//��α���
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
	
	//ǰ�����
	public TreeNode frontSearch(int i) {
		TreeNode target=null;
		//�Աȵ�ǰ�ڵ�ֵ
		if(this.value==i) {
			return this;
		}else {
			//������ڵ�
			if(left!=null) {
				target=left.frontSearch(i);
			}
			//���������ҵ���target�Ͳ�Ϊ��
			if(target!=null) {
				return target;
			}
			//�����ҽڵ�
			if(right!=null) {
				target=right.frontSearch(i);
			}

		}
		return target;
	}

	//ɾ��һ������
	public void delete(int i) {
		TreeNode parent=this;
		//�ж�������
		if(parent.left!=null && parent.left.value==i) {
			parent.left=null;
			return;
		}
		//�ж�������
		if(parent.right!=null && parent.right.value==i) {
			parent.right=null;
			return;
		}
		//û�ҵ�,�ݹ�
		parent=left;
		if(parent!=null) {
			parent.delete(i);
		}
		parent=right;
		if(parent!=null) {
			parent.delete(i);
		}
	}

	//�������ҽڵ�
	public void ChangeLeftandRight() {
		TreeNode root=this;
		if(root==null) return ;
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		
		root.left.ChangeLeftandRight();
		root.right.ChangeLeftandRight();
	}
	
	//�������ҽڵ㣨�ǵݹ飩
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
