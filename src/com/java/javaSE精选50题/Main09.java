package com.java.javaSE精选50题;

import java.util.Scanner;

/**
 * 题目：将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
 * @author WangShuaiJie
 *
 */
public class Main09 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		fun(num);
		
	}
	
	private static void fun(int n) {
		for(int i=1;i<=n;i++) {
			while(isPrime(i) && n%i==0) {
				n=n/i;
				System.out.println(i);
			}
		}
	}
	
	private static boolean isPrime(int n) {
		if(n<=1) return false; 
		for(int i=2;i<n;i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}
