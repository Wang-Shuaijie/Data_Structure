package com.java.���Ծ�ѡ;
/**
 * ����ʮ����������������һ������������С���͵�һ��������
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
