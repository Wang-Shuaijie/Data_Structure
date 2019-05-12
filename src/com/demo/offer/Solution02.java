package com.demo.offer;

public class Solution02 {
	/**
	 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，
	 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
	 * Input:
{2, 3, 1, 0, 2, 5}

Output:
2

对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
以 (2, 3, 1, 0, 2, 5) 为例，遍历到位置 4 时，该位置上的数为 2，但是第 2 个位置上已经有一个 2 的值了，因此可以知道 2 重复：
0 1 2 3 2 5
0 1 2 3 4 5
	 */
	public boolean duplicate(int[] nums, int length, int[] duplication) {
		if(nums==null || nums.length==0) return false;
		for(int i=0;i<nums.length;i++) {
			while(nums[i]!=i){
				if(nums[i]==nums[nums[i]]) {
					duplication[0]=nums[i];
					return true;
				}
				swap(nums,i,nums[i]);
			}
		}
		return false;
	}
	
	private void swap(int[] nums, int i, int j) {
	    int t = nums[i];
	    nums[i] = nums[j];
	    nums[j] = t;
	}
}
