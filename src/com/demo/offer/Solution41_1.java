package com.demo.offer;

import java.util.Arrays;

public class Solution41_1 {
	/**
	 * ����һ����������������һ������S���������в������������ǵ����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С��
	 *�����ܶ࣬����hash�������ƽ⣬����д��һ�֣���������ָ�룬�ֱ��ǰ��ͺ�����б��������ԽԶ�˻�ԽС�����������ȳ��ֵ��������˻���С
	 */
	public int[] findNumberWithSum(int[] nums, int target) {
		Arrays.sort(nums);
		int[] res=new int[] {-1,-1};
		if(nums==null || nums.length==0) return res;
		int start=0;
		int end=nums.length-1;
		while(start<=end) {
			int sum=nums[start]+nums[end];
			if(sum==target) {
				res[0]=nums[start];
				res[1]=nums[end];
			}else if(sum>target) {
				end--;
			}else {
				start++;
			}
		}
		return res;
	}
}
