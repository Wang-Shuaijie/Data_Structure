package com.java.javaSE50��;

import java.util.Scanner;

/**
 * ��Ŀ���ж�һ�������ܱ�����9����
 * 
 * @author WangShuaiJie
 *
 */
public class Main45 {
	public static void main(String[] args) {
		// �������и�ë�Ĺ�ϵ��
		System.out.print("������һ������");
		Scanner scan = new Scanner(System.in);
		long l = scan.nextLong();
		long n = l;
		scan.close();
		int count = 0;
		while (n > 8) {
			n /= 9;
			count++;
		}
		System.out.println(l + "�ܱ�" + count + "��9������");
	}
}
