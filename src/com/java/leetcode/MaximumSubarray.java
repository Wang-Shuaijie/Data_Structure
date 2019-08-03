package com.java.leetcode;

public class MaximumSubarray {
	/**
	 * For example, given the array [2,1,3,4,1,2,1,5,4],
the contiguous subarray [4,1,2,1] has the largest sum = 6.
求连续子数组（包含负数）的最大和
思路：若和小�?0，则将最大和置为当前值，否则计算�?大和
	 */
	public int maxSubArray(int[] nums) {
		//dp解法，dp保存子数组的�?
		int[] dp=new int[nums.length];
		dp[0]=nums[0];
		int res=nums[0];
		for(int i=1;i<nums.length;i++) {
			dp[i]=nums[i]+(dp[i-1]<0?0:dp[i-1]);
			res=Math.max(res, dp[i]);
		}
		return res;
	}
	
	
	public int maxSubArray2(int[] nums) {
		int res=nums[0];
		int sum=nums[0];
		for(int i=1;i<nums.length;i++) {
			sum=Math.max(nums[i], sum+nums[i]);
			res=Math.max(res, sum);
		}
		return res;
	}
	
}
