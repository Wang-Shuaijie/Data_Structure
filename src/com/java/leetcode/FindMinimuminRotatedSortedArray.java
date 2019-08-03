package com.java.leetcode;

public class FindMinimuminRotatedSortedArray {
	/**
	 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
	 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 
	 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 
	 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
	 * 
	 * 首先要判断这个有序数组是否旋转了，通过比较第一个和最后一个数的大小，如果第一个数小，则没有旋转，直接返回这个数。
	 * 如果第一个数大，就要进一步搜索。我们定义left和right两个指针分别指向开头和结尾，
	 * 还要找到中间那个数，然后和left指的数比较，如果中间的数大，则继续二分查找右半段数组，
	 * 反之查找左半段。终止条件是当左右两个指针相邻，返回小的那个。
	 */
	public int findMin(int[] nums) {
		if(nums.length==1) return nums[0];
		int left = 0, right = nums.length - 1;
		if(nums[left]<nums[right]) return nums[0];
		while(left+1 != right) {
			int mid=left+(right-left)/2;
			if(nums[mid]<nums[left]) {
				right=mid;
			}else if(nums[mid]>nums[right]) {
				left=mid;
			}
		}
		return Math.min(nums[left], nums[right]);
	}
}
