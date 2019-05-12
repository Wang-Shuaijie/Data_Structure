package com.demo.leetcode;

import java.util.Arrays;

public class SearchinRotatedSortedArrayII {
	/**
	 * ���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת��

( ���磬���� [0,0,1,2,2,5,6] ���ܱ�Ϊ [2,5,6,0,0,1,2] )��

��дһ���������жϸ�����Ŀ��ֵ�Ƿ�����������С������ڷ��� true�����򷵻� false��

ʾ�� 1:

����: nums = [2,5,6,0,0,1,2], target = 0
���: true

	 */
	public boolean search(int[] nums, int target) {
		if(nums==null || nums.length==0) return false;
		//���������򣨲���Ҫ��
		//Arrays.sort(nums);
		int start=0;
		int end=nums.length-1;
		while(start<end) {
			int mid=(end-start)/2+start;
			if(nums[mid]==target) {
				return true;
			}
			//�ұ�����
			else if(nums[mid]<nums[end]) {
				
				if(nums[mid]<=target && target<=nums[end]) {
					start=mid+1;
				}else {
					end=mid-1;
				}
			//�������
			}else {
				if(nums[start]<=target && target<=nums[mid]) {
					end=mid-1;
				}else {
					start=mid+1;
				}
			}
		}
		return false;
	}
}
