package com.java.leetcode;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class MoveZeroves {
	/**
	 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
	 */
	
	public static void moveZeroes(int[] nums) {
		int curIndex=nums.length-1;
		int lastIndex=nums.length-1;
		int count=0;
		while(curIndex>=0) {
			if(nums[curIndex]==0) {
				count=lastIndex-curIndex;
				for(int i=0;i<count;i++) {
					nums[curIndex+i]=nums[curIndex+i+1];
				}
				nums[lastIndex]=0;
				lastIndex--;
			}
			curIndex--;
		}
	}
	
	public static void moveZeroes2(int[] nums) {
		int count=0;//用来统计非0数的数量
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=0) {
				nums[count]=nums[i];
				count++;
			}
		}
		for(int i=count;i<nums.length;i++) {
			nums[i]=0;
		}
	}
	
	
	public static void main(String[] args) {
		int[] nums=new int[] {0,1,0,3,12};
		moveZeroes2(nums);
		for(int i=0;i<nums.length;i++) {
			System.out.print(nums[i]+" ");
		}
	}
}
