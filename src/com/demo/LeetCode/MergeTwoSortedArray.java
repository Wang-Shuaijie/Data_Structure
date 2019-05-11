package com.demo.LeetCode;

public class MergeTwoSortedArray {
	/**
	 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

    初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
    你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

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
        
        //把nums数组赋给nums1
        //nums1=nums;这种写法错误,不能修改,nums1没有实例化
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
