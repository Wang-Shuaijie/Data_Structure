package com.demo.exercise;
/**
 * 题目：一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请问该数是多少？
 * @author WangShuaiJie
 *
 */
public class Main13 {
	public static void main(String[] args) {
		/*for(int i=0; i<10000; i++) {
			int num1=(int)Math.sqrt(i+100);
			int num2=(int)Math.sqrt(i+168);
			if(num1*num1==(i+100) && num2*num2==(i+168)) {
				System.out.println(i);
			}
		}*/
		int n=0;
		for (int i = 0; i <= 100000; i++) //先确定一个在100000内的大概范围
		{
			if (isCompSqrt(i + 100) && isCompSqrt(i + 168)) 
			{
				n = i;
				break;
			}
		}
		System.out.print("所求的数是:" + n);
		
	}
	
	public static boolean isCompSqrt(int p) {
		boolean flag = false;
		double fsqrt = Math.sqrt(p); // 先将数开平方
		int q = (int) fsqrt; // 转换成整数，另q为开平方且转换为整数的结果。
 
		if (p == Math.pow(q, 2)) // pow(x,y) 就是计算 x 的 y 次幂。把开平方后的整数再平方，看看他和开平方之前的数是不是相等 。
		{
			flag = true;
		}
		return flag;
	}
}
