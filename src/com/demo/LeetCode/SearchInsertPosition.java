package com.demo.LeetCode;

public class SearchInsertPosition {
	/**
	 * ����һ�����������һ��Ŀ��ֵ�����������ҵ�Ŀ��ֵ����������������
	 * ���Ŀ��ֵ�������������У����������ᱻ��˳������λ�á�
	 * ����Լ������������ظ�Ԫ�ء�
	 * ʾ�� 1:
	 * ����: [1,3,5,6], 5
	 * ���: 2
	 */
	
	//ֱ�ӱ���
	public static int searchInsert(int[] nums,int target) {
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>=target) {
				return i;
			}
		}
		return -1;
	}
	
	
	//���ַ�
	public static int searchInsert2(int[] nums,int target) {
		int start=0;
		int end=nums.length-1;
		while(start<=end) {
			int mid=(end-start)/2+start;
			if(nums[mid]==target) return target;
			if(nums[mid]<target) {
				start=mid+1;
			}else {
				end=mid-1;
			}
		}
		if(target <= nums[start]) {
			return start;
		}else if(target <= nums[end]) {
			return end;
		}else {
			return end+1;
		}
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {1,3,5,6};
		int target=2;
		System.out.println(searchInsert(nums, target));
	}
}
