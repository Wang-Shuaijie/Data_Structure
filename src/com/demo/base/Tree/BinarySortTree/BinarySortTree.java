package com.demo.base.Tree.BinarySortTree;

import java.util.Stack;

/**
 * ����������
 * ��ֵ�ϣ���<��<��
 * �������һ���Ǵ�С�����˳��ṹ
 * @author WangShuaiJie
 *
 */
public class BinarySortTree {
	SortTreeNode root;
	/**
	 * ��ӽڵ�
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
	 * ����
	 * @param value
	 * @return
	 */
	public SortTreeNode search(int value) {
		if(root==null) return null;
		return root.search(value);
	}
	/**
	 * ɾ���ڵ�
	 * @param value
	 */
	public void delete(int value) {
		if(root==null) return;
		SortTreeNode target=search(value);
		if(target==null) return;
		SortTreeNode parentNode=searchParent(value);
		//Ҫɾ������Ҷ�ӽڵ�
		if(target.left==null && target.right==null) {
			if(parentNode.left.value==value) {
				parentNode.left=null;
			}else {
				parentNode.right=null;
			}
		//Ҫɾ���Ľڵ��������ֵ�
		}else if(target.left!=null && target.right!=null) {
			//ɾ����������ֵ��С�Ľڵ�
			int min=deleteMin(target.right);
			//�滻Ŀ��ڵ�ֵ
			target.value=min;		
		}else {
		//Ҫɾ���ڵ���һ�����ӽڵ�����ӽڵ�
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
	//ɾ����С�ڵ�
	private int deleteMin(SortTreeNode node) {
		SortTreeNode target=node;
		//������
		while(target.left!=null) {
			target=target.left;
		}
		//ɾ����С�Ľڵ�
		delete(target.value);
		return target.value;
	}
	//���Ҹ��ڵ�
	public SortTreeNode searchParent(int value) {
		if(root==null) return null;
		return root.searchParent(value);
	}
	//����
	public void inorder() {
		root.inorder();
	}
		
}
