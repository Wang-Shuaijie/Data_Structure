package com.java.��ָoffer;

import java.util.Arrays;

public class Solution29 {
	/**
	 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ��������
	 */
	
	//���ַ�����Ȼ������⣬�������漰������sort����ʱ�临�Ӷ�ΪO(NlogN)�������ţ� 
	//��������������һ�����ڵ����
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
	
	public int moreThanHalfNum(int[] nums) {
		//���������������������������ڣ���һ���������м��Ǹ����������磺1��2��2��2��3����2��2��2��3��4����2��3��4��4��4�ȵȣ�
		if(nums==null || nums.length==0) return -1;
		Arrays.sort(nums);
		int mid=nums[nums.length/2];
		int cnt=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==mid) cnt++;
		}
		return cnt>nums.length/2?mid:0;
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
