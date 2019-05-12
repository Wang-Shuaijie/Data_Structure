package com.demo.leetcode;

import java.util.Arrays;

public class SearchinRotatedSortedArrayII {
	/**
	 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

示例 1:

输入: nums = [2,5,6,0,0,1,2], target = 0
输出: true

	 */
	public boolean search(int[] nums, int target) {
		if(nums==null || nums.length==0) return false;
		//对数组排序（不需要）
		//Arrays.sort(nums);
		int start=0;
		int end=nums.length-1;
		while(start<end) {
			int mid=(end-start)/2+start;
			if(nums[mid]==target) {
				return true;
			}
			//右边有序
			else if(nums[mid]<nums[end]) {
				
				if(nums[mid]<=target && target<=nums[end]) {
					start=mid+1;
				}else {
					end=mid-1;
				}
			//左边有序
			}else {
				if(nums[start]<=target && target<=nums[mid]) {
					end=mid-1;
				}else {
					start=mid+1;
				}
			}
		}
		return false;
	}
}
