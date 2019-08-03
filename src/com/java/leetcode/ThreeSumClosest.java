package com.java.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
	/*
	 * ����һ������ n ������������ nums �� һ��Ŀ��ֵ target���ҳ� nums �е�����������
	 * ʹ�����ǵĺ��� target ��ӽ����������������ĺ͡��ٶ�ÿ������ֻ����Ψһ��
	 * ���磬�������� nums = [-1��2��1��-4], �� target = 1.
	 * �� target ��ӽ����������ĺ�Ϊ 2. (-1 + 2 + 1 = 2).
	 */
	
	public static int threeSumClosest(int[] nums, int target) {
        int res=nums[1]+nums[2]+nums[nums.length-1];
        Arrays.sort(nums);
        //iΪ��һ����(���ں����еڶ�������������-2)
        for(int i=0;i<nums.length-2;i++) {
        	//ͷָ�룬����ڶ�����
        	int start=i+1;
        	//βָ�룬�����������
        	int end=nums.length-1;
        	while(start<end) {
        		int sum=nums[i]+nums[start]+nums[end];
        		if(sum<target) {
        			start++;
        		}else {
        			end--;
        		}
        		//Math.abs()���ؾ���ֵ
        		if(Math.abs(sum-target)<Math.abs(res-target)) {
        			res=sum;
        		}
        	}
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums=new int[] {-1,2,1,-4};
		int target=1;
		System.out.println(threeSumClosest(nums, target));
		
	}
}
