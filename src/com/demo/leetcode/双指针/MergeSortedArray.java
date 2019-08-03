package com.demo.leetcode.˫ָ��;
/**
 * Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

��Ŀ�������ѹ鲢����浽��һ�������ϡ�
 * @author WangShuaiJie
 *
 */
public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i=m-1, j=n-1;
		int index=m+n-1;
		while(index>=0) {
			//ǰ�����ж�Ҫ����ǰ�棬��ֹ��ָ���쳣
			if(i<0) {
				nums1[index--]=nums2[j--];
			}else if(j<0) {
				nums1[index--]=nums1[i--];
			}else if(nums1[i]>nums2[j] && i>=0){
                nums1[index--]=nums1[i--];
            }else if(nums1[i]<=nums2[j]&& j>=0){
                nums1[index--]=nums2[j--];
            }
		}
	}
	
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		int[] nums=new int[m+n];
		int i=0, j=0, k=0;
		while(i<m && j<n) {
			if(nums1[i] <= nums2[j])
                nums[k++] = nums1[i++];
            else
                nums[k++] = nums2[j++];
		}
		while(i<m) nums[k++]=nums[i++];
		while(j<n) nums[k++]=nums[j++];
		System.arraycopy(nums, 0, nums1, 0, nums.length);
	}
}
