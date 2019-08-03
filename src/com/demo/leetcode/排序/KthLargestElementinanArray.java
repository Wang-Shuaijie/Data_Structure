package com.demo.leetcode.排序;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Input: [3,2,1,5,6,4] and k = 2
Output: 5

题目描述：找到倒数第 k 个的元素。
 * @author WangShuaiJie
 *
 */
public class KthLargestElementinanArray {
	//快排
	public int findKthLargest(int[] nums, int k) {
		k=nums.length-k;
		int l=0, r=nums.length-1;
		while(l<r) {
			int j=partition(nums, l, r);
			if(j==k) break;
			else if(j<k) {
				l=j+1;
			}else {
				r=j-1;
			}
		}
		return nums[k];
	}
	
	//堆排序
	public int findKthLargest2(int[] nums, int k) {
	    PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
	    for (int val : nums) {
	        pq.add(val);
	        if (pq.size() > k)  // 维护堆的大小为 K
	            pq.poll();
	    }
	    return pq.peek();
	}
	
	
	//快速排序详细代码
	private static int partition(int[] nums, int l, int r) {
		int i=l+1, j=r;
		while(true) {
			while(j>l && nums[j]>nums[l]) j--;
			while(i<r && nums[i]<nums[l]) i++;
			if(i>=j) break;
			swap(nums, i, j);
		}
		swap(nums, l, j);
		return j;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	
	public static void quickSort(int[] nums, int l, int r) {
		if(l>=r) return ;
		int j=partition(nums, l, r);
		quickSort(nums, l, j-1);
		quickSort(nums, j+1, r);
	}
	
//	public static void main(String[] args) {
//		int[] arr=new int[] {5,7,3,9,8,4,0,6,7,2};
//		quickSort(arr, 0, arr.length-1);
//		System.out.println(Arrays.toString(arr));
//	}
}
