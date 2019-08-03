package com.java.leetcode;

import java.util.Arrays;

public class FindMedianSortedArrays {
	/**
	 * 重要
	 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
	 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
	 * 你可以假设 nums1 和 nums2 不会同时为空。
	 * 示例 1:nums1 = [1, 3] nums2 = [2]则中位数是 2.0
	 * 示例 2:nums1 = [1, 2] nums2 = [3, 4]则中位数是 (2 + 3)/2 = 2.5
	 * @author WangShuaiJie
	 *
	 */
	
	//O(log(m + n))
	/*
	 * 思路:假设两个有序数组的长度分别为m和n，由于两个数组长度之和 m+n 的奇偶不确定,
	 * 所以我们分别找第 (m+n) / 2 个，和 (m+n-1) / 2 个，然后求其平均值即可，这对奇偶数均适用。
	 * 加入 m+n 为奇数的话，那么其实 (m+n) / 2 和 (m+n-1) / 2 的值相等，相当于两个相同的数字相加再除以2，还是其本身。
	 * 
	 * O(log(m + n))应用二分法
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
	
	
	//个人不成熟的想法，简单但时间复杂度不合法
	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int[] nums3=new int[nums1.length+nums2.length];
		int k=0;
		for(int i=0;i<nums1.length;i++) {
			nums3[k++]=nums1[i];
		}
		for(int i=0;i<nums2.length;i++) {
			nums3[k++]=nums2[i];
		}
		//对nums3排序
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
