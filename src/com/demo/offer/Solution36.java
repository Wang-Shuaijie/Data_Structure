package com.demo.offer;

public class Solution36 {
	/**
	 * �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�����һ������,�����������е�����Ե�����P

	 */
	
	public int getInvCount(int[] nums) {
		//ʹ�ñ����ⷨ������ÿ��Ԫ�أ����������ұ��ж��ٸ�Ԫ�ر���С
		int inv_count=0;
		for(int i=0;i<nums.length-1;i++) {
			for(int j=i+1;j<nums.length;j++) {
				if(nums[i]>nums[j]) {
					inv_count++;
				}
			}
		}
		return inv_count;
	}
	
	public int getInvCount1(int[] nums) {
		//ð������ԭ������Եĸ�������Ԫ�ؽ����Ĵ���
		int inv_count=0;
		for(int i=0;i<nums.length-1;i++) {
			for(int j=0;j<nums.length-i-1;j++) {
				if(nums[j]>nums[j+1]) {
					int temp=nums[j];
					nums[j]=nums[j+1];
					nums[j+1]=temp;
					inv_count++;
				}
			}
		}
		return inv_count;
	}
	
	public int getInvCount2(int[] nums) {
		//��������ԭ������Եĸ�������Ԫ������ƶ��Ĵ���
		int inv_count=0;
		for(int i=1;i<nums.length;i++) {
			if(nums[i]<nums[i-1]) {
				int temp=nums[i];
				int j=i-1;
				while(j >= 0 &&  nums[j]>temp) {
					//����
					nums[j+1]=nums[j];
					j--;
					inv_count++;
				}
				//��temp���ڿ�λ
				nums[j+1]=temp;
			}
		}
		return inv_count;
	}
	
	

	public int getInvCount3(int[] nums) {
		return 0;
		//�鲢����ԭ�����������=��벿�ֵ����������+�Ұ벿�ֵ����������+�ϲ����ֵ������������

	}
}
