package com.demo.base.Sort;

import java.util.Arrays;

/**
 * 基数排序
 * @author WangShuaiJie
 *
 */
public class RadixSort {
	public static void radixSort(int[] arr) {
		//存储数组中最大的数字
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		//计算最大数字是几位数
		int maxLength=(max+"").length();
		//用于临时存放数据
		int[][] temp=new int[10][arr.length];
		//用于记录在temp中相应的数组中存放的数字的数量
		int[] counts=new int[10];
		//根据最大长度的数决定比较的次数
		for(int i=0,n=1;i<maxLength;i++,n*=10) {
			//把每一个数字分别计算余数
			for(int j=0;j<arr.length;j++) {
				//计算余数
				int ys=arr[j]/n%10;
				//把当前遍历的数据放入指定数组中
				temp[ys][counts[ys]]=arr[j];
				//记录数量
				counts[ys]++;
			}	
		}
		//记录取的元素需要放的位置
		int index=0;
		//取出数字
		for(int k=0;k<counts.length;k++) {
			//记录数量的数组中当前余数的数量不为0
			if(counts[k]!=0) {
				//循环取出元素
				for(int l=0;l<counts[k];l++) {
					//取出元素
					arr[index]=temp[k][l];
					index++;
				}
				//把数量置为0
				counts[k]=0;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr=new int[] {5,7,3,9,8,4,0,6,7,2};
		radixSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
