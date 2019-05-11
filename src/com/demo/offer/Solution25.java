package com.demo.offer;

import java.util.ArrayList;
import java.util.List;

public class Solution25 {
	/**
	 * ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����

˼·���ȱ�����ڵ㣬Ȼ��ֱ�ݹ���������������Ŀ��ֵ�����ҵ�������Ҷ�ӽڵ㣬��ӡ·���е�ֵ
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
	    	resultList.add(new ArrayList(list));	//���ܶ�ԭlist���ģ�Ҫ�½�һ��list
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
