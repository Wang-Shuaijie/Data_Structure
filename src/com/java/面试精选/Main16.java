package com.java.���Ծ�ѡ;

import java.util.Scanner;

/**
 * 
 * 
 * ����һ�����������飬���ĵ� i ��Ԫ���Ǳ��رҵ� i ��ļ۸�
 * 
 * ��������ֻ�������һ�ʽ��ף������������һ�Σ������һ���㷨�����������ܻ�ȡ���������
 * 
 * ע���㲻����������ر�ǰ������ ��������: ���������飬Ϊ�Կո�ָ���n��������
 * 
 * �������: �������
 * 
 * ��������1: 7 1 5 3 6 4
 * 
 * �������1: 5
 * 
 * @author WangShuaiJie
 *
 */
public class Main16 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		int[] price = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			price[i] = Integer.parseInt(str[i]);
		}
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < price.length - 1; i++) {
			if (price[i] < min) {
				min = price[i];
			} else if (price[i] - min >= max) {
				max = price[i] - min;
			}
		}
		System.out.println(max);
	}

	// /*
	// * O(n)������ ���ڵ�i��λ���ϵ�Ԫ�أ�����ֻ��Ҫ֪������[0, i -
	// * 1]��Сֵ���Ϳ��Եó��ڶ�������λ��Ϊi������ֵ����ż��ö��i�Ϳ��Եó��𰸣�������[0, i - 1]��Сֵ����Ԥ���������
	// */
	// public static void main(String[] args) {
	//
	// Scanner scanner = new Scanner(System.in);
	// int min = scanner.nextInt(), max = 0;
	// int temp;
	// while (scanner.hasNext()) {
	// temp = scanner.nextInt();
	// max = Math.max(max, temp - min);
	// min = Math.min(min, temp);
	// }
	// System.out.println(max);
	// }
}
