package com.java.javaSE50��;

import java.util.Scanner;

/**
 * ��Ŀ�����������������Ƕ������ɴ��⣺ ѧϰ�ɼ�>=90�ֵ�ͬѧ��A��ʾ��60-89��֮�����B��ʾ��60�����µ���C��ʾ��
 * 
 * @author WangShuaiJie
 *
 */
public class Main04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		String res = input >= 90 ? "A" : (input >= 60 ? "B" : "C");
		System.out.println(res);
		sc.close();
	}
}
