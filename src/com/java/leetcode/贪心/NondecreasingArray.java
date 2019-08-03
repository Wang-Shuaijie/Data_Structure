package com.java.leetcode.̰��;
/**
 * Input: [4,2,3]
Output: True
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
��Ŀ�������ж�һ�������Ƿ���ֻ�޸�һ�����ͳ�Ϊ�ǵݼ����顣
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
			 * nums[i] < nums[i - 2]���޸� nums[i - 1] = nums[i] ����ʹ�����Ϊ�ǵݼ����飬
			 * ֻ���޸� nums[i] = nums[i - 1]
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
