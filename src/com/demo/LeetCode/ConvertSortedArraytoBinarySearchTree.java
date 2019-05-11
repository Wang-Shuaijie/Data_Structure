package com.demo.LeetCode;

import java.util.Arrays;

public class ConvertSortedArraytoBinarySearchTree {
	/**
	 * ��һ�������������е��������飬ת��Ϊһ�ø߶�ƽ�������������

�����У�һ���߶�ƽ���������ָһ��������ÿ���ڵ� ���������������ĸ߶Ȳ�ľ���ֵ������ 1��

ʾ��:

������������: [-10,-3,0,5,9],

һ�����ܵĴ��ǣ�[0,-3,9,-10,null,5]�������Ա�ʾ��������߶�ƽ�������������

      0
     / \
   -3   9
   /   /
 -10  5


	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		/*
		 * ��ν��������������һ��ʼ��������<��<�ҵ����ԣ��������������������������Ļ����õ��ľ���һ�����������ˡ�
		 * ��ô�����������ǿ��Ե�֪�����ڵ�Ӧ��������������м�㣬���м��ֿ�Ϊ���������������飬
		 * �ڷֱ��ҳ����м����Ϊԭ�м������������ӽڵ�
		 */
		Arrays.sort(nums);
		return helper(nums, 0, nums.length-1);
	}
	private TreeNode helper(int[] nums, int left, int right) {
		if(left>right) return null;
		int mid=(right-left)/2+left;
		TreeNode cur=new TreeNode(nums[mid]);
		cur.left=helper(nums, left, mid-1);
		cur.right=helper(nums, mid+1, right);
		return cur;
	}
}
