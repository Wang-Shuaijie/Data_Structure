package com.demo.LeetCode;

public class SearchInsertPosition {
	/**
	 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
	 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
	 * 你可以假设数组中无重复元素。
	 * 示例 1:
	 * 输入: [1,3,5,6], 5
	 * 输出: 2
	 */
	
	//直接遍历
	public static int searchInsert(int[] nums,int target) {
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>=target) {
				return i;
			}
		}
		return -1;
	}
	
	
	//二分法
	public static int searchInsert2(int[] nums,int target) {
		int start=0;
		int end=nums.length-1;
		while(start<=end) {
			int mid=(end-start)/2+start;
			if(nums[mid]==target) return target;
			if(nums[mid]<target) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		if(target <= nums[start]) {
			return start;
		}else if(target <= nums[end]) {
			return end;
		}else {
			return end+1;
		}
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {1,3,5,6};
		int target=2;
		System.out.println(searchInsert(nums, target));
	}
}
