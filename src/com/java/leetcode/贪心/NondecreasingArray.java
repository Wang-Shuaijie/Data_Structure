package com.java.leetcode.贪心;
/**
 * Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
题目描述：判断一个数组是否能只修改一个数就成为非递减数组。
 * @author WangShuaiJie
 *
 */
public class NondecreasingArray {
	public boolean checkPossibility(int[] nums) {
		int cnt=0;
		for(int i=1;i<nums.length && cnt<2;i++) {
			if(nums[i]>=nums[i-1]) continue;
			cnt++;
			/*
			 * nums[i] < nums[i - 2]，修改 nums[i - 1] = nums[i] 不能使数组成为非递减数组，
			 * 只能修改 nums[i] = nums[i - 1]
			 */
			if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
	            nums[i] = nums[i - 1];
	        } else {
	            nums[i - 1] = nums[i];
	        }
		}
		return cnt<=1;
	}
}
