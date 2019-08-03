package com.java.base.Sort;

import java.util.Arrays;

/**
 * 冒泡排序(两两比较，大数后移)
 * @author WangShuaiJie
 *
 */
public class BubbleSort {
	/**
	 * 
	 * @param arr目标数组
	 */
	public static void bubbleSort(int[] arr) {
		//控制共比较多少轮
		for(int i=0;i<arr.length-1;i++) {
			//arr.length-1-i前面比较过的就不要再比了(比较的次数)
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp=0;
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}
	
	/*
	 * 共需比较length-1轮
	 * 5,7,3,9,8,4,0,6,7,2 
	 * 5,3,7,8,4,0,6,7,2,9
	 * 3,5,7,4,0,6,7,2,8,9
	 * 3,5,4,0,6,7,2,7,8,9
	 * 3,5,0,4,6,2,7,7,8,9
	 * 3,0,4,5,2,6,7,7,8,9
	 * 0,3,4,2,5,6,7,7,8,9
	 * 0,3,2,4,5,6,7,7,8,9
	 * 0,2,3,4,5,6,7,7,8,9
	 *  9轮
	 */
	public static void main(String[] args) {
		int[] arr=new int[] {5,7,3,9,8,4,0,6,7,2};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
