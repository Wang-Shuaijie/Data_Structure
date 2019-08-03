package com.java.面试精选;

import java.util.Scanner;

/**
 * 1+2/3+3/5+4/7+....数列求和，输出结果
 * @author WangShuaiJie
 *
 */
public class Main12 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		float up=1;
		float down=1;
		float tmp=up/down;
		float sum=0;
		for(int i=1;i<=n;i+=2) {
			sum+=tmp;
			up=up+down;
			down=i+2;
			tmp=up/down;
		}
		System.out.println(sum);
	}
}
