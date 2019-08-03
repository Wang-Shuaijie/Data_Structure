package com.java.leetcode;

import java.util.Arrays;

public class KthLargestElementinanArray {
	/**
	 * ��δ������������ҵ��� k ������Ԫ�ء���ע�⣬����Ҫ�ҵ������������ĵ� k ������Ԫ�أ������ǵ� k ����ͬ��Ԫ�ء�
ʾ�� 1:
����: [3,2,1,5,6,4] �� k = 2
���: 5

ʾ�� 2:
����: [3,2,3,1,2,4,5,5,6] �� k = 4
���: 4
	 */
	
	//����Arrays.sort(),ֱ�ӷ���
	public int findKthLargest(int[] nums,int k) {
		if(k==0 || nums.length==0 || nums==null) return 0;
		Arrays.sort(nums);
		return nums[nums.length-k];
	}
	
	
	//���ÿ��������ԭ��
	public int findKthLargest2(int[] nums,int k) {
		k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }
	
	
	//���䣺��������
	public void quickSort(int[] nums,int left,int right) {
		if(left<right) {
			int stard=nums[left];
			int i=left;
			int j=right;
			while(i<j) {
				while(i<j && stard<nums[j]) {
					j--;
				}
				nums[i]=nums[j];
				
				while(i<j && stard>nums[i]) {
					i++;
				}
				nums[j]=nums[i];
				
			}
			nums[i]=stard;
			
			quickSort(nums, left, i);
			quickSort(nums, i, right);
		}
	}
}
