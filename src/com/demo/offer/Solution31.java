package com.demo.offer;

public class Solution31 {
	/**
	 * 求连续子数组（包含负数）的最大和

思路：若和小于0，则将最大和置为当前值，否则计算最大和。
	 */
	public int findmaxSubArray(int[] nums) {
		if(nums==null || nums.length==0) return 0;
		int res=nums[0];
		int sum=nums[0];
		for(int i=0;i<nums.length;i++) {
			sum=Math.max(nums[i], sum+nums[i]);
			res=Math.max(res, sum);
		}
		return res;
	}
}
