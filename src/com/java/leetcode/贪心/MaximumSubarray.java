package com.java.leetcode.Ì°ÐÄ;
/**
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6
 * @author WangShuaiJie
 *
 */
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int preSum=nums[0];
		int maxSum=preSum;
		for(int i=0;i<nums.length;i++) {
			preSum=preSum>0?preSum+nums[i]:nums[i];
			maxSum=Math.max(preSum, maxSum);
		}
		return maxSum;
	}
}
