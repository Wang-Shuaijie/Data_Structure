package com.java.base.Sort;

import java.util.Arrays;

/**
 * 简单选择排序
 * @author WangShuaiJie
 *
 */
public class SelectSort {
	
	public static void selectSort(int[] arr) {
		//遍历所有的数
		for(int i=0;i<arr.length;i++) {
			//标记最小数的下标
			int minIndex=i;
			//把当前遍历的数与后面所有的数比较
			for(int j=i+1;j<arr.length;j++) {
				//如果后面有更小的数,替换下标
				if(arr[minIndex]>arr[j]) {
					minIndex=j;
				}
			}
			//如当前遍历数下标与最小数下标不一致
			if(i!=minIndex) {
				int temp=arr[i];
				arr[i]=arr[minIndex];
				arr[minIndex]=temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr=new int[] {5,7,3,9,8,4,0,6,7,2};
		selectSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
