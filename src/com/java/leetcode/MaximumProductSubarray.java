package com.java.leetcode;

public class MaximumProductSubarray {
	/**
	 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。

示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
//子数组[2], [3], [-2], [4], [2, 3], [3, -2], [-2, 4], [2, 3, -2], [3, -2, 4], [2, 3, -2, 4]
示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。


	 */
	//动态规划，每一步只需要记住其前一步的整数最大值和负数的最小值
	public static int maxProduct(int[] A) {
		if (A == null || A.length == 0) {
	        return 0;
	    }
	    int[] f = new int[A.length];
	    int[] g = new int[A.length];
	    f[0] = A[0];
	    g[0] = A[0];
	    int res = A[0];
	    for (int i = 1; i < A.length; i++) {
	        f[i] = Math.max(Math.max(f[i - 1] * A[i], g[i - 1] * A[i]), A[i]);
	        g[i] = Math.min(Math.min(f[i - 1] * A[i], g[i - 1] * A[i]), A[i]);
	        res = Math.max(res, f[i]);
	    }
	    return res;
	}
	
	//暴力破解（直接求出每个子序列的乘积，取最大值。）超时
	public static int maxProduct2(int[] nums) {
		int res=nums[0];
		int index=1;
		
		while(index<=nums.length) {
			for(int i=0;i<=nums.length-index;i++) {
				int product=1;
				for(int j=0;j<index;j++) {
					product*=nums[i+j];
				}
				if(product>res) {
					res=product;
				}
			}
			index++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {2,3,-2,4};
		System.out.println(maxProduct(nums));
	}
}
