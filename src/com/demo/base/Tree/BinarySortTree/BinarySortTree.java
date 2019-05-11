package com.demo.base.Tree.BinarySortTree;

import java.util.Stack;

/**
 * 二叉排序树
 * 数值上：左<根<右
 * 中序遍历一定是从小到大的顺序结构
 * @author WangShuaiJie
 *
 */
public class BinarySortTree {
	SortTreeNode root;
	/**
	 * 添加节点
	 * @param node
	 */
	public void add(SortTreeNode node) {
		if(root==null) {
			root=node;
		}else {
			root.add(node);
		}
	}
	/**
	 * 查找
	 * @param value
	 * @return
	 */
	public SortTreeNode search(int value) {
		if(root==null) return null;
		return root.search(value);
	}
	/**
	 * 删除节点
	 * @param value
	 */
	public void delete(int value) {
		if(root==null) return;
		SortTreeNode target=search(value);
		if(target==null) return;
		SortTreeNode parentNode=searchParent(value);
		//要删除的是叶子节点
		if(target.left==null && target.right==null) {
			if(parentNode.left.value==value) {
				parentNode.left=null;
			}else {
				parentNode.right=null;
			}
		//要删除的节点有两个字点
		}else if(target.left!=null && target.right!=null) {
			//删除右子树中值最小的节点
			int min=deleteMin(target.right);
			//替换目标节点值
			target.value=min;		
		}else {
		//要删除节点有一个左子节点或右子节点
			if(target.left!=null) {
				if(parentNode.left.value==value) {
					parentNode.left=target.left;
				}else {
					parentNode.right=target.left;
				}
			}else {
				if(parentNode.left.value==value) {
					parentNode.left=target.right;
				}else {
					parentNode.right=target.right;
				}
			}
		}
	}
	//删除最小节点
	private int deleteMin(SortTreeNode node) {
		SortTreeNode target=node;
		//向左找
		while(target.left!=null) {
			target=target.left;
		}
		//删除最小的节点
		delete(target.value);
		return target.value;
	}
	//查找父节点
	public SortTreeNode searchParent(int value) {
		if(root==null) return null;
		return root.searchParent(value);
	}
	//遍历
	public void inorder() {
		root.inorder();
	}
		
}
