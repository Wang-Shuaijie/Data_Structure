package com.java.base.Tree.AVL;


/**
 * ƽ��������ֱ���ΪAVL������������һ�Ŷ�����������������־��������ص㣺
 * ����һ�ÿ����������������������ĸ߶Ȳ�ľ���ֵ������1��
 * ��������������������һ��ƽ���������
 * ��AVL�����κνڵ�����������ĸ߶������Ϊһ��������Ҳ����Ϊƽ���������
 * @author WangShuaiJie
 *
 */
public class BanlancedBinaryTree {
	TreeNode root;
	/**
	 * ��ӽڵ�
	 * @param node
	 */
	public void add(TreeNode node) {
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
	public TreeNode search(int value) {
		if(root==null) return null;
		return root.search(value);
	}
	/**
	 * ɾ���ڵ�
	 * @param value
	 */
	public void delete(int value) {
		if(root==null) return;
		TreeNode target=search(value);
		if(target==null) return;
		TreeNode parentNode=searchParent(value);
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
	private int deleteMin(TreeNode node) {
		TreeNode target=node;
		//������
		while(target.left!=null) {
			target=target.left;
		}
		//ɾ����С�Ľڵ�
		delete(target.value);
		return target.value;
	}
	//���Ҹ��ڵ�
	public TreeNode searchParent(int value) {
		if(root==null) return null;
		return root.searchParent(value);
	}
	//����
	public void inorder() {
		root.inorder();
	}
		
}
