package com.java.javaSE����50��;

import java.util.Scanner;

/**
 * ��Ŀ��������������x,y,z���������������С���������
 * ���������������취����С�����ŵ�x�ϣ��Ƚ�x��y���бȽϣ����x>y��x��y��ֵ���н�����Ȼ������x��z���бȽϣ����x>z��x��z��ֵ���н�����������ʹx��С��
 * ���������Ҳʹz>y�Ϳ�����
 * 
 * @author WangShuaiJie
 *
 */
public class Main15 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();// ��ȡ����
		int num2 = scanner.nextInt();
		int num3 = scanner.nextInt();
		int temp = 0;// ��Ϊһ��������
		if (num1 > num2) {// ��֤num2>num1
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		if (num1 > num3) {// ��֤num3>num1
			temp = num1;
			num1 = num3;
			num3 = temp;
		}
		if (num2 > num3) {// ��֤num3>num2
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		System.out.println("����������С�������У�" + num1 + "  " + num2 + "  " + num3);
		scanner.close();
	}
}
