package com.java.javaSE精选50题;

import java.util.Scanner;

/**
 * 题目：编写一个函数，
 * 输入n为偶数时，调用函数求1/2+1/4+…+1/n,
 * 当输入n为奇数时，调用函数1/1+1/3+…+1/n(利用指针函数)
 * @author WangShuaiJie
 *
 */
public class Main39 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		double sum=0;
		if(n%2==0) {
			for(int i=2;i<=n;i+=2) {
				sum+=1/i;	
			}
		}else {
			for(int i=1;i<=n;i+=2) {
				sum+=1/i;
			}
		}
		System.out.println(sum);
	}
}
