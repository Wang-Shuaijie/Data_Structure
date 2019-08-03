package com.java.剑指offer;

import java.util.Arrays;

public class Solution38 {
	/**
	 * 统计一个数字在排序数组中出现的次数
	 * 思路：利用二分法找到第一次出现的位置和最后一次出现的位置
	 */
	public static int getCount_target(int[] nums, int target) {
		if(nums.length==0 || nums==null) return 0;
		int start=findFirst(nums, target);
		//System.out.println(start);
		if(start==-1) return 0;
		int end=findEnd(nums, target);
		//System.out.println(end);
		return (end-start)+1;
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
	
	public static int findEnd(int[] nums,int target) {
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
		int[] nums=new int[] {1,2,3,3,3,3};
		int target=3;
		System.out.println(getCount_target(nums, target));
	}
	
}
