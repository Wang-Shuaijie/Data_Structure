package com.demo.leetcode.排序;
/**
 * 
 * 题目描述：只有 0/1/2 三种颜色
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * @author WangShuaiJie
 *
 */
public class SortColors {
	public void sortColors(int[] nums) {
		int zero=-1, one=0, two=nums.length;
		while(one<two) {
			if(nums[one]==0) {
				swap(nums, ++zero, one++);
			}else if(nums[one]==2) {
				swap(nums, --two, one);
			}else {
				++one;
			}
		}
	}
	
	private void swap(int[] nums, int i, int j) {
	    int t = nums[i];
	    nums[i] = nums[j];
	    nums[j] = t;
	}
}
