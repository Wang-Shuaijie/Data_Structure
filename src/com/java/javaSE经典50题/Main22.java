package com.java.javaSE经典50题;
/**
 * 题目：利用递归方法求5!。

程序分析：递归公式：f(n)=n*f(n-1)
 * @author WangShuaiJie
 *
 */
public class Main22 {
	public static void main(String[] args) {
		System.out.println(factorial(5));
	}
	
	private static int factorial(int n) {
		if(n==1) return 1;
		return n*factorial(n-1);
	}
}
