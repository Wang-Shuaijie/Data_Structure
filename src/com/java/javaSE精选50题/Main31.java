package com.java.javaSE��ѡ50��;

import java.util.Arrays;

/**
 * ��Ŀ����һ���������������
 * @author WangShuaiJie
 *
 */
public class Main31 {
	public static void main(String[] args) {
		int[] nums=new int[]{3,5,15,36,84,99}; 
		System.out.println(Arrays.toString(nums));
		resverseArr(nums);
	}
	
	public static void resverseArr(int[] nums) {
		for(int i=0;i<nums.length/2;i++) {
			swap(nums, i, nums.length-1-i);
		}
		System.out.println(Arrays.toString(nums));
	}
	
	private static void swap(int[] nums, int i, int j) {
		int tmp=nums[i];
		nums[i]=nums[j];
		nums[j]=tmp;
	}
}
