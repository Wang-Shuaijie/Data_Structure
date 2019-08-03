package com.java.leetcode;

public class JumpGameII {
	/**
	 * ����һ���Ǹ��������飬�����λ������ĵ�һ��λ�á�
�����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
���Ŀ����ʹ�����ٵ���Ծ����������������һ��λ�á�
ʾ��:
����: [2,3,1,1,4]
���: 2
����: �������һ��λ�õ���С��Ծ���� 2��
     ���±�Ϊ 0 �����±�Ϊ 1 ��λ�ã��� 1 ����Ȼ���� 3 ��������������һ��λ�á�
	 */
	public static int jump(int[] nums) {
		if(nums==null || nums.length<2) return 0;
		int res=0;
		int curMaxArea=0;//��ǰ���ߵ������
		int maxNext=0;//�����ߵ������
		//nums.length-1
		for(int i=0;i<nums.length-1;i++) {
			maxNext=Math.max(maxNext, i+nums[i]);
			if(i==curMaxArea) {
				res++;
				curMaxArea=maxNext;
			}
		}
		return res;
	}
	
	public static int jump2(int[] nums) {
		if(nums==null || nums.length<2) return 0;
		int level=0;
		int curMaxArea=0;
		int maxNext=0;
		int i=0;
		while(curMaxArea-i+1>0) {
			level++;
			for(;i<=curMaxArea;i++) {
				maxNext=Math.max(maxNext, nums[i]+i);
				if(maxNext>nums.length-1) {
					return level;
				}
			}
			curMaxArea=maxNext;
		}
		return level;
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {2,3,1,1,4};
		System.out.println(jump(nums));
	}
}
