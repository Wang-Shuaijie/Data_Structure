package com.demo.LeetCode;

public class UglyNumberII {
	/**
	 * 我们找到第n个丑陋数
	 */
	public int nthUglyNumber(int n) {
		//思路：(1) 1x2,  2x2, 2x2, 3x2, 3x2, 4x2, 5x2...
		//		(2) 1x3,  1x3, 2x3, 2x3, 2x3, 3x3, 3x3...
		//		(3) 1x5,  1x5, 1x5, 1x5, 2x5, 2x5, 2x5...
		//每个子列表都是一个丑陋数分别乘以2,3,5，而要求的丑陋数就是从已经生成的序列中取出来的，我们每次都从三个列表中取出当前最小的那个加入序列
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
