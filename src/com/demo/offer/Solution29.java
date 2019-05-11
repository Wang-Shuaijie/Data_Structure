package com.demo.offer;

import java.util.Arrays;

public class Solution29 {
	/**
	 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字
	 */
	public int majorityElement(int[] nums) {
		if(nums==null || nums.length==0) return -1;
		Arrays.sort(nums);
		int mid=nums[nums.length/2];
		if(nums[0]==mid) {
			return nums[0];
		}else if(nums[nums.length-1]==mid) {
			return nums[nums.length-1];
		}else {
			return mid;
		}
	}
	
	
	//其他解法：使用 cnt 来统计一个元素出现的次数，当遍历到的元素和统计元素相等时，令 cnt++，否则令 cnt--。
	public int moreThanHalfNum_Solution(int[] nums) {
	    int majority = nums[0];
	    for (int i = 1, cnt = 1; i < nums.length; i++) {
	        cnt = nums[i] == majority ? cnt + 1 : cnt - 1;
	        if (cnt == 0) {
	            majority = nums[i];
	            cnt = 1;
	        }
	    }
	    int cnt = 0;
	    for (int val : nums)
	        if (val == majority)
	            cnt++;
	    return cnt > nums.length / 2 ? majority : 0;
	}
}
