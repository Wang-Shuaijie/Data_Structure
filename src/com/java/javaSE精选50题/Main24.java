package com.java.javaSE精选50题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目：给一个不多于5位的正整数，
 * 要求：一、求它是几位数，二、逆序打印出各位数字
 * @author WangShuaiJie
 *
 */
public class Main24 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int[] arr=new int[5];
		int i=0;
		while(num!=0) {
			arr[i]=num%10;
			num=num/10;
			i++;
		}
		System.out.println(Arrays.toString(arr));
	}
}
