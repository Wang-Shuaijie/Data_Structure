package com.java.leetcode.���ֲ���;
/**
 * 
Input: [1, 1, 2, 3, 3, 4, 4, 8, 8]
Output: 2
��Ŀ������һ����������ֻ��һ�������������Σ��ҳ��������
Ҫ���� O(logN) ʱ�临�ӶȽ�����⣬��˲��ܱ������鲢��������������⣬��ô����ʱ�临�Ӷ�Ϊ O(N)��
 * @author WangShuaiJie
 *
 */
public class SingleElementinaSortedArray {
	public int singleNonDuplicate(int[] nums) {
		int l=0, h=nums.length-1;
		while(l<h) {
			int m=l+(h-l)/2;
			if(m%2==l) {
				m--;// ��֤ l/h/m ����ż��λ��ʹ�ò��������Сһֱ��������
			}
			if(nums[m]==nums[m+1]) {
				l=m+2;
			}else {
				h=m;
			}
		}
		return nums[l];
	}
}
