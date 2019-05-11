package com.demo.LeetCode;

public class DivideTwoIntegers {
	/**
	 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
	 * 返回被除数 dividend 除以除数 divisor 得到的商。
	 * 示例 1:
	 * 输入: dividend = 10, divisor = 3
	 * 输出: 3
	 * 考虑：1.越界;2.+,-;3.=0 例3/5;4.除数为0不考虑，编译器会自己报异常
	 */
	public static int divide(int dividend,int divisor) {
		int sign=1;
		//判断正负号
		if((dividend>0 && divisor<0)||(dividend<0 && divisor>0)) sign=-1;
		//long防止越界
		long ldividend=Math.abs(dividend);
		long ldivisor=Math.abs(divisor);
		if(ldividend<ldivisor || ldividend==0) return 0;
		long lres=divide(ldividend, ldivisor);
		int res=0;
		if(lres>Integer.MAX_VALUE) {
			res=(sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
		}else {
			res=(int)lres*sign;
		}
		return res;
	}
	
	//Time:O(logn)  Space:O(logn) 
	private static long divide(long ldividend, long ldivisor) {
		// TODO Auto-generated method stub
		if(ldividend<ldivisor) return 0;
		long sum=ldivisor;
		long multile=1;
		/**
		 * 8 / 2=4
		 * sum=2 multile=1
		 * sum=4 multile=2 
		 * sum=8(跳出循环) multile=4+divide(0/2) 			
		 */
		while((sum+sum)<=ldividend) {
			sum+=sum;
			multile+=multile;
		}
		//递归
		return multile+divide(ldividend-sum, ldivisor);
	}
	
	public static void main(String[] args) {
		System.out.println(divide(8, 5));
	}
}
