package com.demo.base.Sort;

import java.util.Arrays;

import com.demo.base.StackandQueue.MyQueue;

/**
 * 基数排序(队列实现)
 * @author WangShuaiJie
 *
 */
public class RadixQueueSort {
	
	public static void radixQueueSort(int[] arr) {
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
		MyQueue[] temp=new MyQueue[10];
		//为队列数组赋值
		for(int i=0;i<temp.length;i++) {
			temp[i]=new MyQueue();
		}
		//根据最大长度的数决定比较的次数
		for(int i=0,n=1;i<maxLength;i++,n*=10) {
			//把每一个数字分别计算余数
			for(int j=0;j<arr.length;j++) {
				//计算余数
				int ys=arr[j]/n%10;
				//把当前遍历的数据放入指定队列中
				temp[ys].add(arr[j]);
			}	
		}
		//记录取的元素需要放的位置
		int index=0;
		//取出数字
		for(int k=0;k<temp.length;k++) {
			//当前队列不为空,循环取出元素
				while(!temp[k].isEmpty()) {
					arr[index]=temp[k].poll();
					index++;
				}
		}
	}
	
	public static void main(String[] args) {
		int[] arr=new int[] {5,7,3,9,8,4,0,6,7,2};
		radixQueueSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
