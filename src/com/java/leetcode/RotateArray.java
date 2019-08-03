package com.java.leetcode;

import java.util.Arrays;

public class RotateArray {
	/**
	 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]

	 */
	public static void rotate(int[] nums, int k) {
		//复制一个数组
		//映射i-->>(i+k)%n
		//int[] res=nums;nums和res指向的是一个数组，修改一个=都修改
		int[] res=new int[nums.length];
		System.arraycopy(nums, 0, res, 0, nums.length);
		for(int i=0;i<res.length;i++) {
			nums[(i+k)%nums.length]=res[i];
		}
	}
	
	
	public static void rotate2(int[] nums, int k) {
		k%=nums.length;
		reverse(nums, 0, nums.length-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
	}
	private static void reverse(int[] nums, int start, int end) {
		while(start<end) {
			int temp=nums[start];
			nums[start]=nums[end];
			nums[end]=temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {1,2,3,4,5,6,7};
		rotate(nums, 3);
	}
}
