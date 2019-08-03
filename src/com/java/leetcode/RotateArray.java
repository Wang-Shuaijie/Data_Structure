package com.java.leetcode;

import java.util.Arrays;

public class RotateArray {
	/**
	 * ����һ�����飬�������е�Ԫ�������ƶ� k ��λ�ã����� k �ǷǸ�����

ʾ�� 1:

����: [1,2,3,4,5,6,7] �� k = 3
���: [5,6,7,1,2,3,4]
����:
������ת 1 ��: [7,1,2,3,4,5,6]
������ת 2 ��: [6,7,1,2,3,4,5]
������ת 3 ��: [5,6,7,1,2,3,4]

	 */
	public static void rotate(int[] nums, int k) {
		//����һ������
		//ӳ��i-->>(i+k)%n
		//int[] res=nums;nums��resָ�����һ�����飬�޸�һ��=���޸�
		int[] res=new int[nums.length];
		System.arraycopy(nums, 0, res, 0, nums.length);
		for(int i=0;i<res.length;i++) {
			nums[(i+k)%nums.length]=res[i];
		}
	}
	
	
	public static void rotate2(int[] nums, int k) {
		k%=nums.length;
		reverse(nums, 0, nums.length-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
	}
	private static void reverse(int[] nums, int start, int end) {
		while(start<end) {
			int temp=nums[start];
			nums[start]=nums[end];
			nums[end]=temp;
			start++;
			end--;
		}
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {1,2,3,4,5,6,7};
		rotate(nums, 3);
	}
}
