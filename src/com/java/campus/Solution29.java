package com.java.campus;

import java.util.Scanner;

/**
 * СQ��X�׳���ΪA�Ĳ�ͬ�ĸ��Y�׳���ΪB�Ĳ�ͬ�ĸ裬����СQ������Щ�����һ���ܳ�������ΪK�ĸ赥��ÿ�׸����ֻ���ڸ赥�г���һ�Σ��ڲ����Ǹ赥�ڸ������Ⱥ�˳�������£������ж�������ɸ赥�ķ�����
 * ÿ���������һ������������
ÿ�����������ĵ�һ�а���һ����������ʾ�赥���ܳ���K(1<=K<=1000)��
��������һ�а����ĸ����������ֱ��ʾ��ĵ�һ�ֳ���A(A<=10)������X(X<=100)�Լ���ĵڶ��ֳ���B(B<=10)������Y(Y<=100)����֤A������B��
�������:
���һ������,��ʾ��ɸ赥�ķ���ȡģ����Ϊ�𰸿��ܻ�ܴ�,�����1000000007ȡģ�Ľ����

��������1:
5
2 3 3 3

�������1:
9
 * @author WangShuaiJie
 *
 */
public class Solution29 {
	// ��̬�滮��ģ�±������⣬�����Ϊ��x+y����Ʒ������x�ֵ��ݻ�Ϊa��y�ֵ��ݻ�Ϊb�������ݻ�Ϊk���ʱ���װ��һ���ж����ֽⷨ��
	private static final int ASD = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int a = sc.nextInt(), x = sc.nextInt();
		int b = sc.nextInt(), y = sc.nextInt();
		int[] dp = new int[k + 1];
		dp[0] = 1;
		for (int i = 0; i < x; i++) {
			for (int j = k; j >= a; j--) {
				dp[j] = (dp[j] + dp[j - a]) % ASD;
			}
		}

		for (int i = 0; i < y; i++) {
			for (int j = k; j >= b; j--) {
				dp[j] = (dp[j] + dp[j - b]) % ASD;
			}
		}

		System.out.println(dp[k]);
		sc.close();
	}
}
