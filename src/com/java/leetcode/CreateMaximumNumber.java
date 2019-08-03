package com.java.leetcode;

import java.util.Arrays;

public class CreateMaximumNumber {
	/**
	 * 给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。

求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。

说明: 请尽可能地优化你算法的时间和空间复杂度。

示例 1:

输入:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
输出:
[9, 8, 6, 5, 3]
	 */
	
	public static int[] maxNumber(int[] nums1,int[] nums2,int k) {
		/*
		 * 从nums1中挑出i个数, 从nums2中挑出k-i个数合并组成最大的数.
		 * 那么就可以分成两个小问题了. 
		 * 第一个是如何从一个数组中挑出i个数, 使表示的数字最大.
		 * 第二个是完全合并两个数组使表达数字最大.
		 * 先看第一个问题, 挑出i个数使合成的数字最大. 利用stack, 若是剩下的数字个数还足够, 看stack顶部若是比当前数字小可以替换掉. 由于stack的size是固定的, 可以用array表示.
第二个问题是两个数组nums1, nums2, 完全合并成新的数组size为k = num1.length+nums2.length如何做到最大. 挑选nums1, nums2当前位置较大的数. 但若是相等的就要看后面的位.
最后挨个试i, 也就是从nums1中挑出数字的个数. 看组成的candidate是否更大, 维护res.
		 */
		if (nums1 == null || nums2 == null || k < 1) return new int[0];
		if (nums1.length + nums2.length < k) return new int[0];
		int[] res=new int[k];
		for(int i=Math.max(0, k-nums2.length);i<=nums1.length && i<k;i++) {
			int[] candidate=merge(maxArray(nums1, i),maxArray(nums2, k-i) , k);
			if(greater(candidate, 0, res, 0)) {
				res=candidate;
			}
			
		}
		return res;
	}
	
	private static int[] merge(int[] nums1, int[] nums2, int k) {
		int[] res=new int[k];
		for(int i=0,j=0,r=0;r<k;r++) {
			res[r]=greater(nums1, i, nums2, j)?nums1[i++]:nums2[j++];
		}
		return res;
	}
	
	private static boolean greater(int[] nums1,int i,int[] nums2,int j) {
		while(i<nums1.length && j<nums2.length && nums1[i]==nums2[j]) {
			i++;
			j++;
		}
		return j==nums2.length || (i<nums1.length && nums1[i]>nums2[j]);
	}
	
	private static int[] maxArray(int[] nums,int k) {
		int len=nums.length;
		int[] res=new int[k];
		for(int i=0,po=0;i<len;i++) {
			while(len-i>k-po && po>0 && res[po-1]<nums[i]) {
				po--;
			}
			if(po<k) {
				res[po++]=nums[i];
			}
		}
		return res;
	}
	
	//最简单的方法，合并数组并排需，取k个最大数(错解)
	//忽略了从同一个数组中取出的数字保持其在原数组中的相对顺序的条件，下面为错误答案
	public static int[] maxNumber2(int[] nums1,int[] nums2,int k) {
		int[] nums=new int[nums1.length+nums2.length];
		int j=0;
		for(int i=0;i<nums1.length;i++) {
			nums[j++]=nums1[i];
		}
		for(int i=0;i<nums2.length;i++) {
			nums[j++]=nums2[i];
		}
		Arrays.sort(nums);
		j=j-1;
		int[] res=new int[k]; 
		for(int i=0;i<k;i++) {
			res[i]=nums[j--];
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		int[] nums1=new int[] {3,4,6,5};
		int[] nums2=new int[] {9,1,2,5,8,3};
		int k=5;
		int[] res=maxNumber(nums1, nums2, k);
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]);
		}
	}
}
