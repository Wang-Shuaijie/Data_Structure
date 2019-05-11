package com.demo.offer;

import java.util.ArrayList;
import java.util.List;

public class Solution25 {
	/**
	 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

思路：先保存根节点，然后分别递归在左右子树中找目标值，若找到即到达叶子节点，打印路径中的值
	 */
	public List<List<Integer>> findPath(TreeNode root, int target){
		List<List<Integer>> res=new ArrayList<>();
		if(root==null) return res;
		helper(res, new ArrayList<>(), root, target);
		return res;
	}
	
	private static void helper(List<List<Integer>> res, List<Integer> list, TreeNode root, int target) {
		if(target==0 && root.left == null && root.right==null) {
			res.add(new ArrayList<>(list));
			return ;
		}
		while(root!=null) {
			list.add(root.val);
			helper(res, list, root.left, target-root.val);
			helper(res, list, root.right, target-root.val);
			list.remove(list.size()-1);
		}
	}
	
/*	ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> list = new ArrayList<Integer>();
	public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
	    if(root == null)	return resultList;
	    list.add(root.val);
	    target -= root.val;
	    
	    if(target == 0 && root.left == null && root.right==null) {
	    	resultList.add(new ArrayList(list));	//不能对原list更改，要新建一个list
	    }
	    
	    findPath(root.left, target);
	    findPath(root.right, target);
	    list.remove(list.size() - 1);
	    return resultList;
	}
*/
	
	

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			x=val;
		}
	}
}
