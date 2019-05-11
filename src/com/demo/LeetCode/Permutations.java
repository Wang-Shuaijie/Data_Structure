package com.demo.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	/**
	 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

	 */
	public static List<List<Integer>> permute(int[] nums){
		List<List<Integer>> res=new ArrayList<>();
		if(nums==null || nums.length==0) return res;
		helper(res, new ArrayList<>(), nums);
		return res;
	}
	
	public static void helper(List<List<Integer>> res,List<Integer> list,int[] nums) {
		if(list.size()==nums.length) {
			res.add(new ArrayList<>(list));
			return;
		}
		for(int i=0;i<nums.length;i++) {
			if(list.contains(nums[i])) continue;
			list.add(nums[i]);
			helper(res,list,nums);
			list.remove(list.size()-1);
		}
	}
	
	public static List<List<Integer>> permute2(int[] nums){
		List<List<Integer>> res=new ArrayList<>();
		if(nums==null || nums.length==0) return res;
		helper2(res, 0, nums);
		return res;
	}
	
	public static void helper2(List<List<Integer>> res,int start,int[] nums) {
		if(start==nums.length) {
			List<Integer> list=new ArrayList<>();
			for(int num:nums) {
				list.add(num);
			}
			res.add(new ArrayList<>(list));
			return;
		}
		for(int i=start;i<nums.length;i++) {
			swap(nums, start, i);
			helper2(res, start+1, nums);
			swap(nums, start, i);
		}
	}
	public static void swap(int[] nums,int i,int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {1,2,3};
		List<List<Integer>> res=permute2(nums);
		System.out.println(res.toString());
	}
}
