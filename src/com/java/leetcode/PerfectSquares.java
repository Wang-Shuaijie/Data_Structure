package com.java.leetcode;

import java.util.Arrays;

public class PerfectSquares {
	/**
	 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3 
解释: 12 = 4 + 4 + 4.

示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.


	 */
	//递归实现
	public int numSquares(int n) {
		int res=n, num=2;
		while(num*num<=n) {
			int a=n/(num*num);
			int b=n%(num*num);
			res=Math.min(res, a+numSquares(b));
			num++;
		}
		return res;
	}
	
	//动态规划实现
	public int numSquares2(int n) {
		int[] dp=new int[n+1];
		//将所有非平方数的结果置最大，保证之后比较的时候不被选中
		Arrays.fill(dp, Integer.MAX_VALUE);
		//将所有平方数的结果置1;
		for(int i=0;i*i<=n;i++) {
			dp[i*i]=1;
		}
		//从小到大找任意数a
		for(int a=0;a<=n;a++) {
			//从小到大找平方数b*b
			for(int b=0;a+b*b<=n;b++) {
				//因为a+b*b可能本身就是平方数，所以我们要取两个中较小的
				dp[a+b*b]=Math.min(dp[a]+1, dp[a+b*b]);
			}
		}
		return dp[n];
	}
}
