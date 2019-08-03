package com.java.leetcode;

public class Pow {
	/**
	 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
	 * 示例 1:
输入: 2.00000, 10
输出: 1024.00000

	 */
	public static double myPow(double x,int n) {
		if(n>0) {
			return pow(x, n);
		}else {
			return 1.0/pow(x, n);
		}
	}
	public static double pow(double x,int n) {
		//2^2=2^1*2^1=(2^0*2^0*2)*(2^0*2^0*2)
		if(n==0) {
			return 1;
		}
		double y=pow(x, n/2);
		if(n%2==0) {
			return y*y;
		}else {
			return y*y*x;
		}
	}
	
	public static double myPow2(double x,int n) {
		double res=1;
		if(n==0) return 1;
		//int 2^32-1----2^32  取绝对值后可能超出int范围
		long abs=Math.abs((long)n);
		while(abs>0) {
			if(abs%2!=0) {
				res=res*x;
			}
			x=x*x;
			abs/=2;
		}
		if(n<0) {
			return 1.0/res;
		}
		return res;
	}
	
	//直接for循环，OJ超时无法通过，需要优化算法
	public static double myPow3(double x,int n) {
		double res=1;
		if(n==0) return 1;
		long abs=Math.abs((long)n);
		for(int i=1;i<=abs;i++) {
			res=res*x;
		}
		if(n<0) {
			return 1.0/res;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(myPow(2, 4));
		System.out.println(myPow2(2, 4));
	}
}
