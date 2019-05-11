package com.demo.offer;

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
		int start=0;
		int end=nums.length-1;
		while(start<=end) {
			int mid=(end-start)/2+start;
			if(nums[mid]<target) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		if(nums[start]==target) return start;
		if(nums[end]==target) return end;
		return -1;
	}
	
	public static int findEnd(int[] nums,int target) {
		int start=0;
		int end=nums.length-1;
		while(start<=end) {
			int mid=(end-start)/2+start;
			if(nums[mid]>target) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		if(nums[start]==target) return start;
		if(nums[end]==target) return end;
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {5,7,7,8,8,10};
		int target=8;
		System.out.println(getCount_target(nums, target));
	}
	
}
