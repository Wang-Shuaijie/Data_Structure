package com.demo.exercise;

import java.util.Scanner;

/**
 * ��Ŀ��һ��ż�����ܱ�ʾΪ��������֮�͡�
 * @author WangShuaiJie
 *
 */
public class Main44 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=1;i<=n;i++) {
			if(isPrime(i) && isPrime(n-i)) {
				System.out.println(n+"="+i+"+"+(n-i));
				break;
			}
		}
	}
	private static boolean isPrime(int n) {
		if(n<=1) return false;
		if(n==2) return true;
		for(int i=2;i<n;i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}
