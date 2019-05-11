package com.demo.LeetCode;

import java.util.Stack;

public class SymmetricTree {
	/**
	 * 给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3

	 */
	public boolean isSymmetric(TreeNode root) {
		//比较n1的左子节点的值和n2的右子节点的值是否相等，同时还要比较n1的右子节点的值和n2的左子结点的值是否相等
		if(root==null) return true;
		return isSymmetric(root.left,root.right);
	}
	
	private boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left==null && right==null) return true;
		if((left==null && right!=null) || (left!=null && right==null) || (left.val!=right.val)) return false;
		return isSymmetric(left.left,right.right) && isSymmetric(left.right, right.left);
	}
	
	
	//非递归
	public boolean isSymmetric2(TreeNode root) {
		if(root==null)  return true;
	    
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    TreeNode left, right;
	    if(root.left!=null){
	        if(root.right==null) return false;
	        stack.push(root.left);
	        stack.push(root.right);
	    }
	    else if(root.right!=null){
	        return false;
	    }
	        
	    while(!stack.empty()){
	        if(stack.size()%2!=0)   return false;
	        right = stack.pop();
	        left = stack.pop();
	        if(right.val!=left.val) return false;
	        
	        if(left.left!=null){
	            if(right.right==null)   return false;
	            stack.push(left.left);
	            stack.push(right.right);
	        }
	        else if(right.right!=null){
	            return false;
	        }
	            
	        if(left.right!=null){
	            if(right.left==null)   return false;
	            stack.push(left.right);
	            stack.push(right.left);
	        }
	        else if(right.left!=null){
	            return false;
	        }
	    }
	    
	    return true;
	}
}
