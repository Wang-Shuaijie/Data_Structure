package com.java.javaSE��ѡ50��;

import java.util.Scanner;

/**
 * ��Ŀ������3����a,b,c������С˳�������
 * 
 * @author WangShuaiJie
 *
 */
public class Main34 {
	public static void main(String[] args) {
		System.out.println("��������������");
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();// ��ȡ�������
		int num2 = scanner.nextInt();
		int num3 = scanner.nextInt();
		scanner.close();
		int temp = 0;
		if (num1 > num2) {// ȷ��num2>num1
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		if (num1 > num3) {// ȷ��num3>num1
			temp = num1;
			num1 = num3;
			num3 = temp;
		}
		if (num2 > num3) {// ȷ��num3>num2
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		System.out.println("���������Ӵ�С���У�" + num3 + "  " + num2 + "   " + num1);
	}
}
