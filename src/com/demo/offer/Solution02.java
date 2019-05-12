package com.demo.offer;

public class Solution02 {
	/**
	 * ��һ������Ϊ n ����������������ֶ��� 0 �� n-1 �ķ�Χ�ڡ�������ĳЩ�������ظ��ģ�����֪���м����������ظ��ģ�
	 * Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡�
	 * Input:
{2, 3, 1, 0, 2, 5}

Output:
2

������������Ԫ���� [0, n-1] ��Χ�ڵ����⣬���Խ�ֵΪ i ��Ԫ�ص������� i ��λ���Ͻ�����⡣
�� (2, 3, 1, 0, 2, 5) Ϊ����������λ�� 4 ʱ����λ���ϵ���Ϊ 2�����ǵ� 2 ��λ�����Ѿ���һ�� 2 ��ֵ�ˣ���˿���֪�� 2 �ظ���
0 1 2 3 2 5
0 1 2 3 4 5
	 */
	public boolean duplicate(int[] nums, int length, int[] duplication) {
		if(nums==null || nums.length==0) return false;
		for(int i=0;i<nums.length;i++) {
			while(nums[i]!=i){
				if(nums[i]==nums[nums[i]]) {
					duplication[0]=nums[i];
					return true;
				}
				swap(nums,i,nums[i]);
			}
		}
		return false;
	}
	
	private void swap(int[] nums, int i, int j) {
	    int t = nums[i];
	    nums[i] = nums[j];
	    nums[j] = t;
	}
}
