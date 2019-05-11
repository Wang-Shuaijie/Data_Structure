package com.demo.offer;

public class Solution31 {
	/**
	 * �����������飨����������������

˼·������С��0����������Ϊ��ǰֵ������������͡�
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
