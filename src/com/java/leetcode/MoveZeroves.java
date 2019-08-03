package com.java.leetcode;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class MoveZeroves {
	/**
	 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳��

ʾ��:

����: [0,1,0,3,12]
���: [1,3,12,0,0]
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
		int count=0;//����ͳ�Ʒ�0��������
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
