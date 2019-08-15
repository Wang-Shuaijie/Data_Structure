package com.java.campus;

import java.util.Scanner;

/**
 * 小Q有X首长度为A的不同的歌和Y首长度为B的不同的歌，现在小Q想用这些歌组成一个总长度正好为K的歌单，每首歌最多只能在歌单中出现一次，在不考虑歌单内歌曲的先后顺序的情况下，请问有多少种组成歌单的方法。
 * 每个输入包含一个测试用例。
每个测试用例的第一行包含一个整数，表示歌单的总长度K(1<=K<=1000)。
接下来的一行包含四个正整数，分别表示歌的第一种长度A(A<=10)和数量X(X<=100)以及歌的第二种长度B(B<=10)和数量Y(Y<=100)。保证A不等于B。
输出描述:
输出一个整数,表示组成歌单的方法取模。因为答案可能会很大,输出对1000000007取模的结果。

输入例子1:
5
2 3 3 3

输出例子1:
9
 * @author WangShuaiJie
 *
 */
public class Solution29 {
	// 动态规划，模仿背包问题，问题简化为有x+y种物品，其中x种的容积为a，y种的容积为b，背包容积为k，问背包装满一共有多少种解法？
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
