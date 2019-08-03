package com.java.leetcode;

import java.util.Arrays;

public class SearchforaRange {
	/**
	 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
	 * 你的算法时间复杂度必须是 O(log n) 级别。
	 * 如果数组中不存在目标值，返回 [-1, -1]。
	 * 示例 1:
	 * 输入: nums = [5,7,7,8,8,10], target = 8
	 * 输出: [3,4]
	 * 
	 * 思路：二分查找
	 */
	public static int[] searchRange(int[] nums,int target) {
		if(nums==null || nums.length==0) return new int[] {-1,-1};
		int start=findFirst(nums, target);
		if(start==-1) return new int[] {-1,-1};
		int end=findLast(nums, target);
		return new int[] {start,end};
	}
	
	public static int findFirst(int[] nums,int target) {
		int left=0;
		int right=nums.length-1;
		int start=-1;
		while(left<=right) {
			int mid=(right-left)/2+left;
			if(nums[mid]==target) {
				start=mid;
				right=mid-1;
			}else if(nums[mid]>target) {
			    right=mid-1;
			}else {
				left=mid+1;
			}
		}

		return start;
	}
	
	public static int findLast(int[] nums,int target) {
		int left=0;
		int right=nums.length-1;
		int end=-1;
		while(left<=right) {
			int mid=(right-left)/2+left;
			if(nums[mid]==target) {
				end=mid;
				left=mid+1;
			}else if(nums[mid]>target) {
			    right=mid-1;
			}else {
				left=mid+1;
			}
		}

		return end;
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {5,7,7,8,8,8,10};
		int target=8;
		int[] res=searchRange(nums, target);
		System.out.println(Arrays.toString(res));
	}
}
