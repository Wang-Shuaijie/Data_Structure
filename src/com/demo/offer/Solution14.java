package com.demo.offer;

public class Solution14 {
	/**
	 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
	 * 使得所有的奇数位于数组的前半部分，
	 * 所有的偶数位于位于数组的后半部分，
	 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变
	 * 12345
	 * 13524
	 * 思路：每次只和前面一个数交换位置。或者利用辅助数组
	 */
	public void reOrderArray(int[] nums) {
		if(nums==null || nums.length==0) return ;
		for(int i=1;i<nums.length;i++) {
			int j=i-1;
			if(nums[i]%2 != 0) {
				while(j>=0) {
					if(nums[j]%2!=0) {
						break;
					}
					if(nums[j]%2==0) {
						int temp=nums[j+1];
						nums[j+1]=nums[j];
						nums[j]=temp;
						j--;
					}
				}
			}
		}
	}
	
	//使用辅助数组
	public void reOrderArray2(int[] nums) {
		//奇数个数
		int oddCnt=0;
		for(int val:nums) {
			if(val%2==1) {
				oddCnt++;
			}
		}
		int[] copy=nums.clone();
		int i=0, j=oddCnt;
		for(int num:copy) {
			if(num%2==1) {
				nums[i++]=num;
			}else {
				nums[j++]=num;
			}
		}
	}
}
