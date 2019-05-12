package com.demo.leetcode;

import java.util.Arrays;

public class SearchforaRange {
	/**
	 * ����һ�������������е��������� nums����һ��Ŀ��ֵ target���ҳ�����Ŀ��ֵ�������еĿ�ʼλ�úͽ���λ�á�
	 * ����㷨ʱ�临�Ӷȱ����� O(log n) ����
	 * ��������в�����Ŀ��ֵ������ [-1, -1]��
	 * ʾ�� 1:
	 * ����: nums = [5,7,7,8,8,10], target = 8
	 * ���: [3,4]
	 * 
	 * ˼·�����ֲ���
	 */
	public static int[] searchRange(int[] nums,int target) {
		if(nums==null || nums.length==0) return new int[] {-1,-1};
		int start=findFirst(nums, target);
		if(start==-1) return new int[] {-1,-1};
		int end=findLast(nums, target);
		return new int[] {start,end};
	}
	
	public static int findFirst(int[] nums,int target) {
		int start=0;
		int end=nums.length-1;
		while(start<=end) {
			int mid=(end-start)/2+start;
			if(nums[mid]<target) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		if(nums[start]==target) return start;
		if(nums[end]==target) return end;
		return -1;
	}
	
	public static int findLast(int[] nums,int target) {
		int start=0;
		int end=nums.length-1;
		while(start<=end) {
			int mid=(end-start)/2+start;
			if(nums[mid]>target) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		if(nums[start]==target) return start;
		if(nums[end]==target) return end;
		return -1;
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {5,7,7,8,8,8,10};
		int target=8;
		int[] res=searchRange(nums, target);
		System.out.println(Arrays.toString(res));
	}
}
