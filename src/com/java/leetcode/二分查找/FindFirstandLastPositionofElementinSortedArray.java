package com.java.leetcode.二分查找;
/**
 * Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
返回下标
 * @author WangShuaiJie
 *
 */
public class FindFirstandLastPositionofElementinSortedArray {
	public int[] searchRange(int[] nums, int target) {
		if(nums==null || nums.length==0) return new int[] {-1,-1};
		int start=findFrist(nums, target);
		if(start==-1) return new int[] {-1,-1};
		int end=findLast(nums, target);
		return new int[] {start,end};
	}

	public int findFrist(int[] nums, int target) {
		int l=0, h=nums.length-1;
		int start=-1;
		while(l<=h) {
			int mid=l+(h-l)/2;
			if(nums[mid]==target) {
				start=mid;
				h=mid-1;
			}else if(nums[mid]>target){
				l=mid+1;
			}else {
				h=mid-1;
			}
		}
		return start;
	}
	
	public int findLast(int[] nums, int target) {
		int l=0, h=nums.length-1;
		int end=-1;
		while(l<=h) {
			int mid=l+(h-l)/2;
			if(nums[mid]==target) {
				end=mid;
				l=mid+1;
			}else if(nums[mid]>target){
				l=mid+1;
			}else {
				h=mid-1;
			}
		}
		return end;
	}
}
