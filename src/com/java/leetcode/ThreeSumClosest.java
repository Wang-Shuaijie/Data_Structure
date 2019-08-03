package com.java.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
	/*
	 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，
	 * 使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案
	 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
	 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
	 */
	
	public static int threeSumClosest(int[] nums, int target) {
        int res=nums[1]+nums[2]+nums[nums.length-1];
        Arrays.sort(nums);
        //i为第一个数(由于后面有第二，第三，所以-2)
        for(int i=0;i<nums.length-2;i++) {
        	//头指针，代表第二个数
        	int start=i+1;
        	//尾指针，代表第三个数
        	int end=nums.length-1;
        	while(start<end) {
        		int sum=nums[i]+nums[start]+nums[end];
        		if(sum<target) {
        			start++;
        		}else {
        			end--;
        		}
        		//Math.abs()返回绝对值
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
