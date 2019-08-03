package com.java.leetcode;

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
		int left=0;
		int right=nums.length-1;
		int start=-1;
		while(left<=right) {
			int mid=(right-left)/2+left;
			if(nums[mid]==target) {
				start=mid;
				right=mid-1;
			}else if(nums[mid]>target) {
			    right=mid-1;
			}else {
				left=mid+1;
			}
		}

		return start;
	}
	
	public static int findLast(int[] nums,int target) {
		int left=0;
		int right=nums.length-1;
		int end=-1;
		while(left<=right) {
			int mid=(right-left)/2+left;
			if(nums[mid]==target) {
				end=mid;
				left=mid+1;
			}else if(nums[mid]>target) {
			    right=mid-1;
			}else {
				left=mid+1;
			}
		}

		return end;
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {5,7,7,8,8,8,10};
		int target=8;
		int[] res=searchRange(nums, target);
		System.out.println(Arrays.toString(res));
	}
}
