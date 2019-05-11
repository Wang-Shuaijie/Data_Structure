package com.demo.LeetCode;

public class MergeTwoSortedArray {
	/**
	 * �������������������� nums1 �� nums2���� nums2 �ϲ��� nums1 �У�ʹ�� num1 ��Ϊһ���������顣

˵��:

    ��ʼ�� nums1 �� nums2 ��Ԫ�������ֱ�Ϊ m �� n��
    ����Լ��� nums1 ���㹻�Ŀռ䣨�ռ��С���ڻ���� m + n�������� nums2 �е�Ԫ�ء�

ʾ��:

����:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

���: [1,2,2,3,5,6]

	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] nums=new int[m+n];
        int i=0,j=0,k=0;
        while(i<m && j<n){
            if(nums1[i] <= nums2[j])
                nums[k++] = nums1[i++];
            else
                nums[k++] = nums2[j++];
        }
        while(i < m) nums[k++] = nums1[i++];
        while(j < n) nums[k++] = nums2[j++];
        
        //��nums���鸳��nums1
        //nums1=nums;����д������,�����޸�,nums1û��ʵ����
        System.arraycopy(nums,0,nums1,0,nums.length);

	}
	
	public static void main(String[] args) {
		int[] nums1=new int[] {1,2,3,0,0,0};
		int m=3;
		int[] nums2=new int[] {2,5,6};
		int n=3;
		//int[] nums=new int[] {1,2,2,3,5,6};
		merge(nums1, m, nums2, n);
		for(int i=0;i<nums1.length;i++) {
			System.out.print(nums1[i]);
		}
	}
}
