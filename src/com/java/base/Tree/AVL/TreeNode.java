package com.java.base.Tree.AVL;

/**
 * 二叉排序树通过旋转变为平衡二叉树
 * 旋转的原理详解，请自行查阅
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
	 * 查询当前节点高度
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
	 * 向子树添加节点，并时刻判断是否平衡（左右子树高度差不大于1）
	 * @param node
	 */
	public void add(TreeNode node) {
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
		
		//判断是否平衡
		if(leftHeight()-rightHeight()>1) {
			//双旋转
			if(left!=null && left.leftHeight()<left.rightHeight()) {
				//先左旋转
				left.leftRotate();
				//再右旋转
				rightRotate();
			}else {
			//右旋转	
				rightRotate();
			}
		}
		if(leftHeight()-rightHeight()<-1) {
			if(right!=null && right.rightHeight()<right.leftHeight()) {
				//右
				right.rightRotate();
				//左
				leftRotate();
			}
			leftRotate();
		}
		
	}
	/**
	 * 右旋转
	 */
	public void rightRotate() {
		//创建一个新节点，值等于当前节点值
		TreeNode newNode=new TreeNode(this.value);
		//把新节点的右子树设置成当前节点的右子树
		newNode.right=this.right;
		//把新节点的左子树设置为当前节点左子树的右子树
		newNode.left=this.left.right;
		//把当前节点的值换为左子节点的值
		this.value=this.left.value;
		this.left=this.left.left;
		//当前节点的右子树设为新节点
		this.right=newNode;
	}
	/**
	 * 左旋转
	 */
	public void leftRotate() {
		//创建一个新节点，值等于当前节点值
		TreeNode newNode=new TreeNode(this.value);
		newNode.left=this.left;
		newNode.right=this.right.left;
		this.value=this.right.value;
		this.right=this.right.right;
		this.left=newNode;
	}
	
	/**
	 * 查找节点
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
	 * 查找父节点
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
	 * 中序遍历
	 */
	public void inorder() {
		//递归写法
		if(left!=null) {
			left.inorder();
		}
		System.out.print(this.value+" ");
		if(right!=null) {
			right.inorder();
		}
	}

}
