package com.java.leetcode;

import java.util.Arrays;

public class FindMedianSortedArrays {
	/**
	 * ��Ҫ
	 * ����������СΪ m �� n ���������� nums1 �� nums2��
	 * �����ҳ������������������λ��������Ҫ���㷨��ʱ�临�Ӷ�Ϊ O(log(m + n))��
	 * ����Լ��� nums1 �� nums2 ����ͬʱΪ�ա�
	 * ʾ�� 1:nums1 = [1, 3] nums2 = [2]����λ���� 2.0
	 * ʾ�� 2:nums1 = [1, 2] nums2 = [3, 4]����λ���� (2 + 3)/2 = 2.5
	 * @author WangShuaiJie
	 *
	 */
	
	//O(log(m + n))
	/*
	 * ˼·:����������������ĳ��ȷֱ�Ϊm��n�������������鳤��֮�� m+n ����ż��ȷ��,
	 * �������Ƿֱ��ҵ� (m+n) / 2 ������ (m+n-1) / 2 ����Ȼ������ƽ��ֵ���ɣ������ż�������á�
	 * ���� m+n Ϊ�����Ļ�����ô��ʵ (m+n) / 2 �� (m+n-1) / 2 ��ֵ��ȣ��൱��������ͬ����������ٳ���2�������䱾��
	 * 
	 * O(log(m + n))Ӧ�ö��ַ�
	 * 
	 * nums1: 3 5 8 9
	 * nums2: 1 2 4 6 7 0 
	 * nums3: 1 2 3 4 5 6 7 8 9 0
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }
	
    int findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) return nums2[j + k - 1];
        if (j >= nums2.length) return nums1[i + k - 1];
        if (k == 1) return Math.min(nums1[i], nums2[j]);
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if (midVal1 < midVal2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }
	
	
	//���˲�������뷨���򵥵�ʱ�临�ӶȲ��Ϸ�
	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int[] nums3=new int[nums1.length+nums2.length];
		int k=0;
		for(int i=0;i<nums1.length;i++) {
			nums3[k++]=nums1[i];
		}
		for(int i=0;i<nums2.length;i++) {
			nums3[k++]=nums2[i];
		}
		//��nums3����
		for(int i=0;i<nums3.length-1;i++) {
			for(int j=0;j<nums3.length-1-i;j++) {
				if(nums3[j]>nums3[j++]) {
					int temp=nums3[j];
					nums3[j]=nums3[j++];
					nums3[j++]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(nums3));
		double res=0;
		
		
		double x=nums3[nums3.length/2];
		double y=nums3[nums3.length-1/2];
		res = (x+y)/2;
		return res;
    }
	
	
	
	
	public static void main(String[] args) {
		int[] arr1=new int[] {1,2,3};
		int[] arr2=new int[] {3,4};
		System.out.println(findMedianSortedArrays2(arr1, arr2));
	}
}
