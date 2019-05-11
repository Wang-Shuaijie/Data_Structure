package com.demo.LeetCode;

public class FlattenBinaryTreetoLinkedList {
	/**
	 * 给定一个二叉树，原地将它展开为链表。

例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6

将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6


	 */
	
	public void flatten(TreeNode root) {
		/*
		 * 先利用DFS的思路找到最左子节点，然后回到其父节点，把其父节点和右子节点断开，将原左子结点连上父节点的右子节点上，然后再把原右子节点连到新右子节点的右子节点上，然后再回到上一父节点做相同操作
		 */
		if(root==null) return ;
		if(root.left!=null) flatten(root.left);
		if(root.right!=null) flatten(root.right);
		TreeNode temp=root.right;
		root.right=root.left;
		root.left=null;
		while(root.right!=null) {
			root=root.right;
		}
		root.right=temp;
	}
	
	
	private TreeNode prev=null;
	public void flatten2(TreeNode root) {
		if(root==null) return;
		flatten2(root.right);
		flatten2(root.left);
		root.right=prev;
		root.left=null;
		prev=root;
	}
	
}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val=x;
	}
}
