package com.demo.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.demo.base.Tree.BinaryTree.TreeNode;

public class BinaryTreeRightSideView {
	/**
	 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:

输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---


	 */
	public List<Integer> rightSideView(TreeNode root){
		//树层次遍历的应用
		Queue<TreeNode> queue=new LinkedList<>();
		List<Integer> res=new ArrayList<>();
		queue.offer(root);
		if(root==null) return res;
		while(!queue.isEmpty()) {
			int size=queue.size();
			res.add(queue.peek().val);
			for(int i=0;i<size;i++) {
				TreeNode temp=queue.poll();
				//134
				if(temp.right!=null) {
					queue.offer(root.right);
				}
				if(temp.left!=null) {
					queue.offer(root.left);
				}
				/*
				 * 125
				if(temp.left!=null) {
					queue.offer(temp.left);
				}
				if(temp.right!=null) {
					queue.offer(temp.right);
				}
				*/
			}
		}
		return res;
		/*
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
		*/
	}
	
	
	
//引申：层序遍历二叉树
	/*
	 *     3
   / \
  9  20
    /  \
   15   7

 

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
	 */
	
	public List<List<Integer>> levelOrder(TreeNode root){
		Queue<TreeNode> queue=new LinkedList<>();
		List<List<Integer>> wrapList=new LinkedList<>();
		
		if(root==null) return wrapList;
		queue.offer(root);
		while(!queue.isEmpty()) {
			int levelNum=queue.size();
			List<Integer> subList=new LinkedList<>();
			for(int i=0;i<levelNum;i++) {
				if(queue.peek().left!=null) queue.offer(queue.peek().left);
				if(queue.peek().right!=null) queue.offer(queue.peek().right);
				subList.add(queue.poll().val);
			}
			wrapList.add(subList);
		}
		return wrapList;
	}
	
	//DFS解法
	public List<List<Integer>> levelOrder1(TreeNode root){
		List<List<Integer>> res=new ArrayList<>();
		if(root==null) return res;
		levelhelper(res,root,0);
		return res;		
	}
	
	private void levelhelper(List<List<Integer>> res, TreeNode root, int height) {
		if(root==null) return ;
		if(height>=res.size()) {
			res.add(new LinkedList<>());
		}
		res.get(height).add(root.val);
		levelhelper(res, root.left, height+1);
		levelhelper(res, root.right, height+1);
	}
	
	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}	
	
}


