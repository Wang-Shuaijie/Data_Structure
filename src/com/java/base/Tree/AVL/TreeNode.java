package com.java.base.Tree.AVL;

/**
 * ����������ͨ����ת��Ϊƽ�������
 * ��ת��ԭ����⣬�����в���
 * @author WangShuaiJie
 *
 */
public class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int value) {
		this.value=value;
	}
	
	/**
	 * ��ѯ��ǰ�ڵ�߶�
	 * @return
	 */
	public int getHeight() {
		return Math.max(left==null?0:left.getHeight(), right==null?0:right.getHeight())+1;
	}
	public int leftHeight() {
		if(left==null) return 0;
		return left.getHeight();
	}
	public int rightHeight() {
		if(right==null) return 0;
		return right.getHeight();
	}
		
	
	/**
	 * ��������ӽڵ㣬��ʱ���ж��Ƿ�ƽ�⣨���������߶Ȳ����1��
	 * @param node
	 */
	public void add(TreeNode node) {
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
		
		//�ж��Ƿ�ƽ��
		if(leftHeight()-rightHeight()>1) {
			//˫��ת
			if(left!=null && left.leftHeight()<left.rightHeight()) {
				//������ת
				left.leftRotate();
				//������ת
				rightRotate();
			}else {
			//����ת	
				rightRotate();
			}
		}
		if(leftHeight()-rightHeight()<-1) {
			if(right!=null && right.rightHeight()<right.leftHeight()) {
				//��
				right.rightRotate();
				//��
				leftRotate();
			}
			leftRotate();
		}
		
	}
	/**
	 * ����ת
	 */
	public void rightRotate() {
		//����һ���½ڵ㣬ֵ���ڵ�ǰ�ڵ�ֵ
		TreeNode newNode=new TreeNode(this.value);
		//���½ڵ�����������óɵ�ǰ�ڵ��������
		newNode.right=this.right;
		//���½ڵ������������Ϊ��ǰ�ڵ���������������
		newNode.left=this.left.right;
		//�ѵ�ǰ�ڵ��ֵ��Ϊ���ӽڵ��ֵ
		this.value=this.left.value;
		this.left=this.left.left;
		//��ǰ�ڵ����������Ϊ�½ڵ�
		this.right=newNode;
	}
	/**
	 * ����ת
	 */
	public void leftRotate() {
		//����һ���½ڵ㣬ֵ���ڵ�ǰ�ڵ�ֵ
		TreeNode newNode=new TreeNode(this.value);
		newNode.left=this.left;
		newNode.right=this.right.left;
		this.value=this.right.value;
		this.right=this.right.right;
		this.left=newNode;
	}
	
	/**
	 * ���ҽڵ�
	 * @param value
	 * @return
	 */
	public TreeNode search(int value){
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
	public TreeNode searchParent(int value) {
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
		if(left!=null) {
			left.inorder();
		}
		System.out.print(this.value+" ");
		if(right!=null) {
			right.inorder();
		}
	}

}
