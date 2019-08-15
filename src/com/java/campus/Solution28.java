package com.java.campus;

import java.util.Scanner;

/**
 * СQ�ĸ�ĸҪ����N�죬��֮ǰ��СQ������M���ɿ�����СQ����ÿ��Ե��ɿ�������������ǰһ��Ե�һ�룬�������ֲ����ڸ�ĸ����֮ǰ��ĳһ��û���ɿ����ԣ���������һ������ܳԶ��ٿ��ɿ���
 * 
 * @author WangShuaiJie
 *
 */
public class Solution28 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int day = scan.nextInt();
		int number = scan.nextInt();
		System.out.print(fun(day, number));
	}

	// �����һ���s���ɿ���һ����Ҫ���ٸ����ٸ��ɿ���
	public static int sum(int s, int n, int m) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += s;
			s = (s + 1) / 2;// ����ȡ��
		}
		return sum;
	}

	// ���ֲ���
	public static int fun(int n, int m) {
		if (n == 1)
			return m;
		int low = 1;
		int high = m;// ��һ����ɿ���һ���Ǵ��ڵ���1С�ڵ���m��
		while (low <= high) {
			int mid = (low + high + 1) / 2;// ����ȡ��
			if (sum(mid, n, m) == m)
				return mid;// �����һ���mid���ɿ������ոպó��������ɿ�������ôֱ�ӷ���
			else if (sum(mid, n, m) < m) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return high;
	}
}
