package com.java.leetcode.二分查找;
/**
 * 
Input: [1, 1, 2, 3, 3, 4, 4, 8, 8]
Output: 2
题目描述：一个有序数组只有一个数不出现两次，找出这个数。
要求以 O(logN) 时间复杂度进行求解，因此不能遍历数组并进行异或操作来求解，这么做的时间复杂度为 O(N)。
 * @author WangShuaiJie
 *
 */
public class SingleElementinaSortedArray {
	public int singleNonDuplicate(int[] nums) {
		int l=0, h=nums.length-1;
		while(l<h) {
			int m=l+(h-l)/2;
			if(m%2==l) {
				m--;// 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
			}
			if(nums[m]==nums[m+1]) {
				l=m+2;
			}else {
				h=m;
			}
		}
		return nums[l];
	}
}
