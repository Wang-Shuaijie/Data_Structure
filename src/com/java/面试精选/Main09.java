package com.java.面试精选;
/**
 * 输入十个数，最大数和最后一个数交换，最小树和第一个数交换
 * @author WangShuaiJie
 *
 */
public class Main09 {
	private static void change(int[] nums) {
		int maxIndex=0;
		int minIndex=0;
		for(int i=0;i<nums.length;i++){
			maxIndex=(nums[i]>nums[maxIndex])?i:maxIndex;
			minIndex=(nums[i]<nums[minIndex])?i:minIndex;
		}
		
		int change;
		change=nums[0];
		nums[0]=nums[minIndex];
		nums[minIndex]=change;
		
		if(maxIndex==0) {
			maxIndex=minIndex;
		}

		change=nums[nums.length-1];
		nums[nums.length-1]=nums[maxIndex];
		nums[maxIndex]=change;
	}
}
