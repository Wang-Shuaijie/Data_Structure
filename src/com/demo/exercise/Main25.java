package com.demo.exercise;

import java.util.Scanner;

/**
 * ��Ŀ��һ��5λ�����ж����ǲ��ǻ���������12321�ǻ���������λ����λ��ͬ��ʮλ��ǧλ��ͬ��
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
