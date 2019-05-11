package com.demo.offer;

public class Solution36 {
	/**
	 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P

	 */
	
	public int getInvCount(int[] nums) {
		//使用暴力解法。对于每个元素，计算在它右边有多少个元素比它小
		int inv_count=0;
		for(int i=0;i<nums.length-1;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]>nums[j]) {
					inv_count++;
				}
			}
		}
		return inv_count;
	}
	
	public int getInvCount1(int[] nums) {
		//冒泡排序原理，逆序对的个数就是元素交换的次数
		int inv_count=0;
		for(int i=0;i<nums.length-1;i++) {
			for(int j=0;j<nums.length-i-1;j++) {
				if(nums[j]>nums[j+1]) {
					int temp=nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=temp;
					inv_count++;
				}
			}
		}
		return inv_count;
	}
	
	public int getInvCount2(int[] nums) {
		//插入排序原理，逆序对的个数就是元素向后移动的次数
		int inv_count=0;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]<nums[i-1]) {
				int temp=nums[i];
				int j=i-1;
				while(j >= 0 &&  nums[j]>temp) {
					//右移
					nums[j+1]=nums[j];
					j--;
					inv_count++;
				}
				//把temp放在空位
				nums[j+1]=temp;
			}
		}
		return inv_count;
	}
	
	

	public int getInvCount3(int[] nums) {
		return 0;
		//归并排序原理，逆序对数量=左半部分的逆序对数量+右半部分的逆序对数量+合并部分的逆序对数量。

	}
}
