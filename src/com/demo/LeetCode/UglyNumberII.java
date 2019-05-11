package com.demo.LeetCode;

public class UglyNumberII {
	/**
	 * �����ҵ���n����ª��
	 */
	public int nthUglyNumber(int n) {
		//˼·��(1) 1x2,  2x2, 2x2, 3x2, 3x2, 4x2, 5x2...
		//		(2) 1x3,  1x3, 2x3, 2x3, 2x3, 3x3, 3x3...
		//		(3) 1x5,  1x5, 1x5, 1x5, 2x5, 2x5, 2x5...
		//ÿ�����б���һ����ª���ֱ����2,3,5����Ҫ��ĳ�ª�����Ǵ��Ѿ����ɵ�������ȡ�����ģ�����ÿ�ζ��������б���ȡ����ǰ��С���Ǹ���������
		if(n<0) return 0;
		int[] nums=new int[n];
		nums[0]=1;
		int i2=0,i3=0,i5=0;
		for(int i=1;i<n;i++) {
			int min=Math.min(nums[i2]*2, Math.min(nums[i3]*3, nums[i5]*5));
			nums[i]=min;
			if(nums[i2]*2==min) {
				i2++;
			}
			if(nums[i3]*3==min) {
				i3++;
			}
			if(nums[i5]*5==min) {
				i5++;
			}
		}
		return nums[n-1];
	}
}
