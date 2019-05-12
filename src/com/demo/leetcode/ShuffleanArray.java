package com.demo.leetcode;

import java.util.Random;

public class ShuffleanArray {
	/**
	 * ����һ��û���ظ�Ԫ�ص����顣

ʾ��:

// �����ּ��� 1, 2 �� 3 ��ʼ�����顣
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// �������� [1,2,3] �����ؽ�����κ� [1,2,3]�����з��صĸ���Ӧ����ͬ��
solution.shuffle();

// �������鵽���ĳ�ʼ״̬[1,2,3]��
solution.reset();

// �����������[1,2,3]���Һ�Ľ����
solution.shuffle();


	 */
	private int[] nums;
	private Random random;
	
	public ShuffleanArray(int[] nums) {
		this.nums=nums;
		random=new Random();
	}
	
	public int[] reset() {
		return this.nums;
	}
	
	public int[] shuffle() {
		int[] arr=nums.clone();
		for(int i=0;i<arr.length;i++) {
			int j=random.nextInt(i+1);
			swap(arr, i, j);
		}
		return arr;
	}
	
	private void swap(int [] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
