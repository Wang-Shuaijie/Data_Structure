package com.demo.exercise;

import java.util.Scanner;

/**
 * 题目：一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同。
 * @author WangShuaiJie
 *
 */
public class Main25 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int input=sc.nextInt();
		System.out.println(isPartition(input));
	}
	
	private static boolean isPartition(int n) {
		String s=Integer.toString(n);
		for(int i=0;i<s.length()/2+1;i++) {
			if(s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
		}
		return true;
	}
}
