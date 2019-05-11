package com.demo.offer;

import java.util.Arrays;

public class Solution29 {
	/**
	 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ��������
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
	
	
	//�����ⷨ��ʹ�� cnt ��ͳ��һ��Ԫ�س��ֵĴ���������������Ԫ�غ�ͳ��Ԫ�����ʱ���� cnt++�������� cnt--��
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
