package com.demo.leetcode.����;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Input: [3,2,1,5,6,4] and k = 2
Output: 5

��Ŀ�������ҵ������� k ����Ԫ�ء�
 * @author WangShuaiJie
 *
 */
public class KthLargestElementinanArray {
	//����
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
	
	//������
	public int findKthLargest2(int[] nums, int k) {
	    PriorityQueue<Integer> pq = new PriorityQueue<>(); // С����
	    for (int val : nums) {
	        pq.add(val);
	        if (pq.size() > k)  // ά���ѵĴ�СΪ K
	            pq.poll();
	    }
	    return pq.peek();
	}
	
	
	//����������ϸ����
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
