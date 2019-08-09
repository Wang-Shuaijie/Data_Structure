package com.java.campus;
/**
 * (编程题)整数成绩最大化
给出一个整数n，将n分解为至少两个整数之和，使得这些整数的乘积最大化，输出能够获得的最大的乘积。
例如：
2=1+1，输出1；
10=3+3+4，输出36。 
 * @author WangShuaiJie
 *
 */
public class Solution05 {
	/*
	 * 思路：分解出来的3越多，乘积越大，具体数学证明可以网上找。当分解到剩4及以下时，可以看出此时再分解结果会更小，因此不予分解，直接相乘即可。
	 */
	private static int getMaxMultiply(int n) {
		if(n==2) return 1;
		if(n==3) return 2;
		if(n==4) return 4;
		int res=1;
		while(n>4) {
			res*=3;
			n=n-3;
		}
		return res*n;
	}
	
}
