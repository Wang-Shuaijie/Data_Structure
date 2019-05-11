package com.demo.base.Sort;

import java.util.Arrays;
/**
 * 插入排序
 * @author WangShuaiJie
 *
 */
public class InsertSort {
	
	public static void insertSort(int arr[]) {
		//遍历所有数字
		for(int i=1;i<arr.length;i++) {
			//如果当前数字比前一个小,存起来用作比较数据
			if(arr[i]<arr[i-1]) {
				int temp=arr[i];
				//当比到最左边或遇到比temp更小数据结束
				int j=i-1;
				while(j >= 0 && arr[j]>temp) {
					//右移
					arr[j+1]=arr[j];
					j--;
				}
				//把temp放在空位
				arr[j+1]=temp;
				
			}
		}
	}
	
	/*
	 * 
	 * 
	 */
	public static void main(String[] args) {
		int[] arr=new int[] {5,7,3,9,8,4,0,6,7,2};
		insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
