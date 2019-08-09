package com.java.leetcode.���ֲ���;
/**
 * Input: [3,4,5,1,2],
Output: 1
��ת�������С����
 * @author WangShuaiJie
 *
 */
public class FindMinimuminRotatedSortedArray {
	public int findMin(int[] nums) {
		int l=0, h=nums.length-1;
		while(l<h){
			int mid=l+(h-l)/2;
			if(nums[mid]<=nums[h]) {
				h=mid;
			}else {
				l=mid+1;
			}
		}
		return nums[l];
	}
}
