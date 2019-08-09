package com.java.javaSE50题;

import java.util.Arrays;

/**
 * 题目：输入数组，最大的与第一个元素交换，最小的与最后一个元素交换，输出数组
 * @author WangShuaiJie
 *
 */
public class Main35 {
	public static void main(String[] args) {
		int[] nums=new int[]{3,14,15,36,84,85}; 
		fun(nums);
	}
	private static void fun(int[] nums) {
		int maxIndex=0;
		int minIndex=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>nums[maxIndex]) {
				maxIndex=i;
			}else if(nums[i]<nums[minIndex]) {
				minIndex=i;
			}
		}
		//System.out.println(maxIndex+" "+minIndex);
		swap(nums, 0, maxIndex);
		if(minIndex==0) {
			minIndex=maxIndex;
		}
		swap(nums, nums.length-1, minIndex);
		System.out.println(Arrays.toString(nums));
	}
	private static void swap(int[] nums, int i, int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
}
