package com.demo.exercise;

import java.util.Scanner;

/**
 * �ŵ����⣺��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�
 * С���ӳ����������º�ÿ��������һ�����ӣ�
 * �������Ӷ���������ÿ���µ����Ӷ���Ϊ���٣�
 * ������������ӵĹ���Ϊ����1,1,2,3,5,8,13,21��.
 * @author WangShuaiJie
 *
 */
public class Main01 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(fun(n));
		sc.close();
	}
	//쳲���������a[n]=a[n-1]+a[n-1]
	public static int fun(int n) {
		if(n==1 || n==2) return 1;
		return fun(n-1)+fun(n-2);
	}
}
