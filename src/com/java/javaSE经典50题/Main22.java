package com.java.javaSE����50��;
/**
 * ��Ŀ�����õݹ鷽����5!��

����������ݹ鹫ʽ��f(n)=n*f(n-1)
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
