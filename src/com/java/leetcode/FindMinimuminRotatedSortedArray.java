package com.java.leetcode;

public class FindMinimuminRotatedSortedArray {
	/**
	 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� 
	 * ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء� 
	 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� 
	 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0
	 * 
	 * ����Ҫ�ж�������������Ƿ���ת�ˣ�ͨ���Ƚϵ�һ�������һ�����Ĵ�С�������һ����С����û����ת��ֱ�ӷ����������
	 * �����һ�����󣬾�Ҫ��һ�����������Ƕ���left��right����ָ��ֱ�ָ��ͷ�ͽ�β��
	 * ��Ҫ�ҵ��м��Ǹ�����Ȼ���leftָ�����Ƚϣ�����м��������������ֲ����Ұ�����飬
	 * ��֮�������Ρ���ֹ�����ǵ���������ָ�����ڣ�����С���Ǹ���
	 */
	public int findMin(int[] nums) {
		if(nums.length==1) return nums[0];
		int left = 0, right = nums.length - 1;
		if(nums[left]<nums[right]) return nums[0];
		while(left+1 != right) {
			int mid=left+(right-left)/2;
			if(nums[mid]<nums[left]) {
				right=mid;
			}else if(nums[mid]>nums[right]) {
				left=mid;
			}
		}
		return Math.min(nums[left], nums[right]);
	}
}
