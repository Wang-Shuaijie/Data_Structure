package com.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	/**
	 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
	 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
	 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
	 * 满足要求的四元组集合为：[
	 * 							[-1,  0, 0, 1],
	 * 							[-2, -1, 1, 2],
	 * 							[-2,  0, 0, 2]
	 * 						  ]
	 */
	 public static List<List<Integer>> fourSum(int[] nums, int target) {
	        List<List<Integer>> res=new ArrayList<>();
	        Arrays.sort(nums);
	        for(int i=0;i<nums.length-3;i++) {
	        	//去重
	        	if(i>0 && nums[i]==nums[i-1]) continue;
	        	for(int j=i+1;j<nums.length-2;j++) {
	        		if(j>i+1 && nums[j]==nums[j-1]) continue;
	        			
	        		int start=j+1,end=nums.length-1,sum=target-nums[i]-nums[j];
	        		while(start<end) {
	        			if(nums[start]+nums[end]==sum) {
	        				res.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
	        				//去重
	        				while(start<end && nums[start]==nums[start+1]) start++;
	        				while(start<end && nums[end]==nums[end-1]) end--;
	        				
	        				start++;
	        				end--;
	        			}else if(nums[start]+nums[end]<sum) {
	        				start++;
	        			}else {
	        				end--;
	        			}
	        		}
	        			
	        			
	        	}
	        }
	       return res;
	 }
	 
	 public static void main(String[] args) {
		int[] nums=new int[] {1, 0, -1, 0, -2, 2};
		System.out.println(fourSum(nums, 0));
	}
	 
}
