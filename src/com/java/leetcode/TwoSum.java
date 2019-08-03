package com.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
	/**
	 * 1.两数之和
	 * 2.给定一个整数数组 nums 和一个目标值 target，
	 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
	 * 3.例给定 nums = [2, 7, 11, 15], target = 9
	 * 因为 nums[0] + nums[1] = 2 + 7 = 9所以返回 [0, 1]
	 */
	//time:O(n) space:O(n)
	
	public static int[] twoSum(int[] nums,int target) {
		//思路：利用hashmap key保存数组元素，value保存下标
		if(nums==null || nums.length<2) {
			return new int[] {-1,-1};
		}
		
		int[] res=new int[] {-1,1};
		HashMap<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			//每一次遍历都要看(taget-当前遍历的值)是否包含，如果有则输出
			if(map.containsKey(target-nums[i])) {
				res[0]=map.get(target-nums[i]);
				res[1]=i;
			}
			map.put(nums[i], i);
		}
		return res;
	}
	
	public static int[] twoSum2(int[] nums,int target) {
		if(nums==null || nums.length<2) {
			return new int[] {-1,-1};
		}
		
		int[] res=new int[] {-1,1};
		//头指针
		int i=0;
		//尾指针
		int j=nums.length-1;
		//nums必须是有序数组
		while(i<j) {
			int sum=nums[i]+nums[j];
			if(sum == target) {
				res[0]=i;
				res[1]=j;
			}else if(sum < target) {
				i++;
			}else {
				j++;
			}
		}

		return res;
	}
	
	
	
	public static void main(String[] args) {
		int[] nums=new int[] {2,7,11,15};
		int target=9;
		System.out.println(Arrays.toString(twoSum(nums, target)));
	}
}
