package com.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
	/**
	 * For example:
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

 

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> res=new ArrayList<>();
		if(root==null) return res;
		Queue<TreeNode> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			List<Integer> list=new ArrayList<>(); 
			for(int i=queue.size();i>0;i--) {
				TreeNode temp=queue.poll();
				list.add(temp.val);
				if(temp.left!=null) queue.add(temp.left);
				if(temp.right!=null) queue.add(temp.right);
			}
			//每回都放在第一位
			res.add(0,list);
		}
		return res;
	}

	
	 public List<List<Integer>> levelOrderBottom2(TreeNode root) {
         List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
         levelMaker(wrapList, root, 0);
         return wrapList;
     }
     
     public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
         if(root == null) return;
         if(level >= list.size()) {
             list.add(0, new LinkedList<Integer>());
         }
         levelMaker(list, root.left, level+1);
         levelMaker(list, root.right, level+1);
         list.get(list.size()-level-1).add(root.val);
     }
}
