package com.demo.offer;

public class Solution14 {
	/**
	 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
	 * ʹ�����е�����λ�������ǰ�벿�֣�
	 * ���е�ż��λ��λ������ĺ�벿�֣�
	 * ����֤������������ż����ż��֮������λ�ò���
	 * 12345
	 * 13524
	 * ˼·��ÿ��ֻ��ǰ��һ��������λ�á��������ø�������
	 */
	public void reOrderArray(int[] nums) {
		if(nums==null || nums.length==0) return ;
		for(int i=1;i<nums.length;i++) {
			int j=i-1;
			if(nums[i]%2 != 0) {
				while(j>=0) {
					if(nums[j]%2!=0) {
						break;
					}
					if(nums[j]%2==0) {
						int temp=nums[j+1];
						nums[j+1]=nums[j];
						nums[j]=temp;
						j--;
					}
				}
			}
		}
	}
	
	//ʹ�ø�������
	public void reOrderArray2(int[] nums) {
		//��������
		int oddCnt=0;
		for(int val:nums) {
			if(val%2==1) {
				oddCnt++;
			}
		}
		int[] copy=nums.clone();
		int i=0, j=oddCnt;
		for(int num:copy) {
			if(num%2==1) {
				nums[i++]=num;
			}else {
				nums[j++]=num;
			}
		}
	}
}
