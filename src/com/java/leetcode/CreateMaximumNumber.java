package com.java.leetcode;

import java.util.Arrays;

public class CreateMaximumNumber {
	/**
	 * �������ȷֱ�Ϊ m �� n ���������飬��Ԫ���� 0-9 ���ɣ���ʾ������Ȼ����λ�ϵ����֡����ڴ�������������ѡ�� k (k <= m + n) ������ƴ�ӳ�һ���µ�����Ҫ���ͬһ��������ȡ�������ֱ�������ԭ�����е����˳��

���������������������������һ����ʾ��������ĳ���Ϊ k �����顣

˵��: �뾡���ܵ��Ż����㷨��ʱ��Ϳռ临�Ӷȡ�

ʾ�� 1:

����:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
���:
[9, 8, 6, 5, 3]
	 */
	
	public static int[] maxNumber(int[] nums1,int[] nums2,int k) {
		/*
		 * ��nums1������i����, ��nums2������k-i�����ϲ����������.
		 * ��ô�Ϳ��Էֳ�����С������. 
		 * ��һ������δ�һ������������i����, ʹ��ʾ���������.
		 * �ڶ�������ȫ�ϲ���������ʹ����������.
		 * �ȿ���һ������, ����i����ʹ�ϳɵ��������. ����stack, ����ʣ�µ����ָ������㹻, ��stack�������Ǳȵ�ǰ����С�����滻��. ����stack��size�ǹ̶���, ������array��ʾ.
�ڶ�����������������nums1, nums2, ��ȫ�ϲ����µ�����sizeΪk = num1.length+nums2.length����������. ��ѡnums1, nums2��ǰλ�ýϴ����. ��������ȵľ�Ҫ�������λ.
��󰤸���i, Ҳ���Ǵ�nums1���������ֵĸ���. ����ɵ�candidate�Ƿ����, ά��res.
		 */
		if (nums1 == null || nums2 == null || k < 1) return new int[0];
		if (nums1.length + nums2.length < k) return new int[0];
		int[] res=new int[k];
		for(int i=Math.max(0, k-nums2.length);i<=nums1.length && i<k;i++) {
			int[] candidate=merge(maxArray(nums1, i),maxArray(nums2, k-i) , k);
			if(greater(candidate, 0, res, 0)) {
				res=candidate;
			}
			
		}
		return res;
	}
	
	private static int[] merge(int[] nums1, int[] nums2, int k) {
		int[] res=new int[k];
		for(int i=0,j=0,r=0;r<k;r++) {
			res[r]=greater(nums1, i, nums2, j)?nums1[i++]:nums2[j++];
		}
		return res;
	}
	
	private static boolean greater(int[] nums1,int i,int[] nums2,int j) {
		while(i<nums1.length && j<nums2.length && nums1[i]==nums2[j]) {
			i++;
			j++;
		}
		return j==nums2.length || (i<nums1.length && nums1[i]>nums2[j]);
	}
	
	private static int[] maxArray(int[] nums,int k) {
		int len=nums.length;
		int[] res=new int[k];
		for(int i=0,po=0;i<len;i++) {
			while(len-i>k-po && po>0 && res[po-1]<nums[i]) {
				po--;
			}
			if(po<k) {
				res[po++]=nums[i];
			}
		}
		return res;
	}
	
	//��򵥵ķ������ϲ����鲢���裬ȡk�������(���)
	//�����˴�ͬһ��������ȡ�������ֱ�������ԭ�����е����˳�������������Ϊ�����
	public static int[] maxNumber2(int[] nums1,int[] nums2,int k) {
		int[] nums=new int[nums1.length+nums2.length];
		int j=0;
		for(int i=0;i<nums1.length;i++) {
			nums[j++]=nums1[i];
		}
		for(int i=0;i<nums2.length;i++) {
			nums[j++]=nums2[i];
		}
		Arrays.sort(nums);
		j=j-1;
		int[] res=new int[k]; 
		for(int i=0;i<k;i++) {
			res[i]=nums[j--];
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		int[] nums1=new int[] {3,4,6,5};
		int[] nums2=new int[] {9,1,2,5,8,3};
		int k=5;
		int[] res=maxNumber(nums1, nums2, k);
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]);
		}
	}
}
