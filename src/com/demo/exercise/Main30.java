package com.demo.exercise;

import java.util.Arrays;

/**
 * ��Ŀ����һ���Ѿ��ź�������顣������һ������Ҫ��ԭ���Ĺ��ɽ������������С�

��������������жϴ����Ƿ�������һ������Ȼ���ٿ��ǲ����м�����������������Ԫ��֮����������κ���һ��λ�á�
 * @author WangShuaiJie
 *
 */
public class Main30 {
	public static void main(String[] args) {
		int[] nums=new int[]{3,5,15,36,84,99}; 
		insertArr(nums, 88);
	}
	public static void insertArr(int[] nums, int target) {
		int[] arr = new int[nums.length + 1];
		//��ȡ�����λ��
		int index=0;
		if(nums[nums.length-1]<target) index=nums.length;
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i]<=target && nums[i+1]>=target) {
				index=i+1;
				break;
			}
		}
		for(int j=0;j<index;j++) {
			arr[j]=nums[j];
		}
		arr[index]=target;
		for(int k=index+1;k<arr.length;k++) {
			arr[k]=nums[k-1];
		}
		System.out.println(Arrays.toString(arr));
	}
}
