package com.java.javaSE50��;

import java.util.Scanner;

/**
 * ��Ŀ����һ��3*3����Խ���Ԫ��֮�� �������������˫��forѭ�����������ά���飬�ٽ�a[i][i]�ۼӺ����
 * 
 * @author WangShuaiJie
 *
 */
public class Main29 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] arr = new int[3][3];
		// ��ȡ��������
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}
		System.out.println("��һ���Խ���֮�ͣ�" + (arr[0][0] + arr[1][1] + arr[2][2]));
		System.out.println("�ڶ����Խ���֮�ͣ�" + (arr[0][2] + arr[1][1] + arr[2][0]));
		scanner.close();
	}
}
