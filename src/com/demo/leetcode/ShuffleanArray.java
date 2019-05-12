package com.demo.leetcode;

import java.util.Random;

public class ShuffleanArray {
	/**
	 * 打乱一个没有重复元素的数组。

示例:

// 以数字集合 1, 2 和 3 初始化数组。
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
solution.shuffle();

// 重设数组到它的初始状态[1,2,3]。
solution.reset();

// 随机返回数组[1,2,3]打乱后的结果。
solution.shuffle();


	 */
	private int[] nums;
	private Random random;
	
	public ShuffleanArray(int[] nums) {
		this.nums=nums;
		random=new Random();
	}
	
	public int[] reset() {
		return this.nums;
	}
	
	public int[] shuffle() {
		int[] arr=nums.clone();
		for(int i=0;i<arr.length;i++) {
			int j=random.nextInt(i+1);
			swap(arr, i, j);
		}
		return arr;
	}
	
	private void swap(int [] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
