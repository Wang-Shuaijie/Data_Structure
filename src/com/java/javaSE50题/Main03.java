package com.java.javaSE50��;

import java.util.Scanner;

/**
 * ��Ŀ����ӡ�����еġ�ˮ�ɻ���������ν��ˮ�ɻ�������ָһ����λ�������λ���������͵��ڸ�������
 * ���磺153��һ����ˮ�ɻ���������Ϊ153=1�����η���5�����η���3�����η���
 * @author WangShuaiJie
 *
 */
public class Main03 {
	public static void main(String[] args) {
		for (int i = 100; i < 1000; i++) {
			if(isRightNum(i)) {
				System.out.println(i);
			}
		}
	}
	
	public static boolean isRightNum(int n) {
		int a=n%10;//��λ
		int b=n/10%10;//ʮλ
		int c=n/10/10;//��λ
		if(n==a*a*a+b*b*b+c*c*c) return true;
		return false;
	}
}
