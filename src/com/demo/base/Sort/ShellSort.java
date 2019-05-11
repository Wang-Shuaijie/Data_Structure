package com.demo.base.Sort;

import java.util.Arrays;

/**
 * 希尔排序
 * @author WangShuaiJie
 *
 */
public class ShellSort {
	
	public static void shellSort(int[] arr) {
		//遍历所有步长(增量)
		for(int d=arr.length/2;d>0;d/=2) {
			//遍历所有元素
			for(int i=d;i<arr.length;i++) {
				for(int j=i-d;j>=0;j-=d){
					//如果当前元素大于加上步长后的那个元素，交换
					if(arr[j]>arr[j+d]) {
						int temp=arr[j];
						arr[j]=arr[j+d];
						arr[j+d]=temp;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr=new int[] {5,7,3,9,8,4,0,6,7,2};
		shellSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
