package com.java.javaSE精选50题;

import java.util.Arrays;

/**
 * 题目：对10个数进行排序
 * 常用：快排，冒泡，选择排序
 * @author WangShuaiJie
 *
 */
public class Main28 {
	public static void main(String[] args) {
		int[] arr=new int[] {5,7,3,9,8,4,0,6,7,2};
		//selectSort(arr);
		//bubbleSort(arr);
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	public static void bubbleSort(int[] nums) {
		for(int i=0;i<nums.length-1;i++) {
			for(int j=0;j<nums.length-1-i;j++) {
				if(nums[j]>nums[j+1]) {
					swap(nums, j, j+1);
				}
			}
		}
	}
	
	public static void selectSort(int[] nums) {
		for(int i=0;i<nums.length;i++) {
			int minIndex=i;
			for(int j=i+1;j<nums.length;j++) {
				if(nums[minIndex]>nums[j]) {
					minIndex=j;
				}
			}
			if(i!=minIndex) {
				swap(nums, i, minIndex);
			}
		}
	}
	
	public static void quickSort(int[] nums, int start, int end) {
		if(start>=end) return ;
		int j=partition(nums, start, end);
		quickSort(nums, start, j-1);
		quickSort(nums, j+1, end);
	}
	
	private static int partition(int[] nums, int start, int end) {
		int i=start+1, j=end;
		while(true) {
			while(j>start && nums[j]>nums[start]) j--;
			while(i<end && nums[i]<nums[start]) i++;	
			if(i>=j) break;
			swap(nums, i, j);
		}
		swap(nums, start, j);
		return j;
	}
	
	
	private static void swap(int[] nums, int i, int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
}
