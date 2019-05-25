package com.demo.offer;

import java.util.Arrays;

public class Solution09 {
	
	//不推荐，有越界的风险(从1开始)
	public static int febonaqcci(int i) {
		if(i<=0) return 0;
		else if(i==1 || i==2) {
			return 1;
		}else {
			return febonaqcci(i-1)+febonaqcci(i-2);
		}
	}
	
	
	
	/**
	 * 把递归变成循环可防止栈溢出
	 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
	 */
	
	public long febonaqcci2(int n) {
		long res=0;
		long firstNum=1;
		long secondNum=0;

		if(n==1) {
			return 1;
		}
		for(int i=2;i<=n;i++) {
			res=firstNum+secondNum;
			secondNum=firstNum;
			firstNum=res;
		}
		return res;
	}
	
	/**
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * 思路：feibonaqcci思想,求第n项数
	 * 
	 *             | 1, (n=1)
        f(n) =     | 2, (n=2)
                   | f(n-1)+f(n-2) ,(n>2,n为整数)
	 */
	public static int febonaqcci3(int i) {
		if(i==0) return 0;
		else if(i==1) {
			return 1;
		}
		else if(i==2) {
			return 2;
		}
		else {
			return febonaqcci(i-1)+febonaqcci(i-2);
		}
	}
	
	/**
	 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
	 * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个 2*n 的大矩形，总共有多少种方法？
	 */
	public int RectCover(int n) {
	    if (n <= 2)
	        return n;
	    int pre2 = 1, pre1 = 2;
	    int result = 0;
	    for (int i = 3; i <= n; i++) {
	        result = pre2 + pre1;
	        pre2 = pre1;
	        pre1 = result;
	    }
	    return result;
	} 
	
	
	/**
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * 2^(n-1)
	 * 或f(n)=2*f(n-1)
	 */
	public int JumpFloor2(int target) {
        return (int) Math.pow(2,target-1);
    }
	//动态规划
	public int JumpFloorII(int target) {
	    int[] dp = new int[target];
	    Arrays.fill(dp, 1);
	    for (int i = 1; i < target; i++)
	        for (int j = 0; j < i; j++)
	            dp[i] += dp[j];
	    return dp[target - 1];
	}
	
	
	//假设农场中成熟的母牛每年只会生1头小母牛，并且永远不会死。
	//第一年农场有1只成熟的母牛，从第二年开始，母牛开始生小母牛。
	//每只小母牛3年之后成熟又可以生小母牛。
	//给定整数N，求出N年后牛的数量。
	//f[i]代表第i年母牛的数量，那么f[i]=f[i-1]+f[i-3]
	//第i年的母牛头数 = 去年的木牛头数 + 新生的小牛头数(只有距第i年3年前的牛才能生小牛)。
	public int cowNum(int n){
        if(n <= 0)
            return 0;
        if(n == 1 || n == 2 || n == 3)
            return n;
        return cowNum(n - 1) + cowNum(n - 3);
    }
	
	
	/*
	 * 把一根绳子剪成多段，并且使得每段的长度乘积最大。

n = 2
return 1 (2 = 1 + 1)

n = 10
return 36 (10 = 3 + 3 + 4)
	 */
	public int integerBreak(int n) {
		// 贪心算法
		// 尽可能多剪长度为 3 的绳子，并且不允许有长度为 1 的绳子出现。
		//如果出现了，就从已经切好长度为 3 的绳子中拿出一段与长度为 1
		// 的绳子重新组合，把它们切成两段长度为 2 的绳子
		if (n < 2)
			return 0;
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		int timesOf3 = n / 3;
		if (n - timesOf3 * 3 == 1)
			timesOf3--;
		int timesOf2 = (n - timesOf3 * 3) / 2;
		return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
	}
	
	public int integerBreak2(int n) {
		// 动态规划
		int[] dp=new int[n+1];
		dp[1]=1;
		for(int i=2;i<=n;i++) {
			for(int j=1;j<i;j++) {
				dp[i]=Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
			}
		}
		return dp[n];
	}
	
}
