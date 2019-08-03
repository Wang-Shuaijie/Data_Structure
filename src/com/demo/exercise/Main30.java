package com.demo.exercise;

import java.util.Arrays;

/**
 * 题目：有一个已经排好序的数组。现输入一个数，要求按原来的规律将它插入数组中。

程序分析：首先判断此数是否大于最后一个数，然后再考虑插入中间的数的情况，插入后此元素之后的数，依次后移一个位置。
 * @author WangShuaiJie
 *
 */
public class Main30 {
	public static void main(String[] args) {
		int[] nums=new int[]{3,5,15,36,84,99}; 
		insertArr(nums, 88);
	}
	public static void insertArr(int[] nums, int target) {
		int[] arr = new int[nums.length + 1];
		//获取插入的位置
		int index=0;
		if(nums[nums.length-1]<target) index=nums.length;
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i]<=target && nums[i+1]>=target) {
				index=i+1;
				break;
			}
		}
		for(int j=0;j<index;j++) {
			arr[j]=nums[j];
		}
		arr[index]=target;
		for(int k=index+1;k<arr.length;k++) {
			arr[k]=nums[k-1];
		}
		System.out.println(Arrays.toString(arr));
	}
}
