package com.java.leetcode;

public class FindMinimuminRotatedSortedArrayII {
	/**
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.

�����д��ڴ������ظ�����ʱ���ͻ��ƻ����ֲ��ҷ��Ļ��ƣ������޷�ȡ��O(lgn)��ʱ�临�Ӷȣ��ֽ���ص��򵥴ֱ���O(n)�������������������
{2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2} �� {2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2}�� ���Ƿ��֣�����һ�����ֺ����һ�����֣������м��Ǹ�����ȫ����ȵ�ʱ��
���ֲ��ҷ��ͱ����ˣ���Ϊ���޷��жϵ��׸�ȥ���߻����Ұ�ߡ���������£����ǽ���ָ������һλ���Թ�һ����ͬ���֣���Խ���������Ӱ�죬��Ϊ����ֻ��ȥ����һ����ͬ�ģ�
Ȼ���ʣ��Ĳ��ּ����ö��ֲ��ҷ������������£�������������Ԫ�ض���ͬ��ʱ�临�ӶȻ�����O(n)��

	 */
public int findMin(int[] nums) {
        if(nums.length==0 || nums==null) return 0;
        int left=0, right=nums.length-1, res=nums[0];
        while(left<right-1) {
        	int mid=left+(right-left)/2;
        	if(nums[left]<nums[mid]) {
        		res=Math.min(res, nums[left]);
        		left=mid+1;
        	}else if(nums[left]>nums[mid]) {
        		res=Math.min(res, nums[right]);
        		right=mid;
        	}else {
        		left++;
        	}
        }
        res=Math.min(res, nums[left]);
        res=Math.min(res, nums[right]);
        return res;
        
    }
}
