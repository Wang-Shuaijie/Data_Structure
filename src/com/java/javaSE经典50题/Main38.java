package com.java.javaSE����50��;

import java.util.Scanner;

/**
 * ��Ŀ��дһ����������һ���ַ����ĳ��ȣ���main�����������ַ�����������䳤�ȡ�
 * 
 * @author WangShuaiJie
 *
 */
public class Main38 {
	public static void main(String[] args) {
		System.out.println("������һ���ַ���");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();// ��ȡ������ַ���
		System.out.println("��������ַ����ǣ�" + input);
		System.out.println("��������ַ��������ǣ�" + input.length());
		scanner.close();
	}
}
