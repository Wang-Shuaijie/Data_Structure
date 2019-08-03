package com.java.leetcode;

import java.util.Arrays;

public class PerfectSquares {
	/**
	 * ���������� n���ҵ����ɸ���ȫƽ���������� 1, 4, 9, 16, ...��ʹ�����ǵĺ͵��� n������Ҫ����ɺ͵���ȫƽ�����ĸ������١�

ʾ�� 1:

����: n = 12
���: 3 
����: 12 = 4 + 4 + 4.

ʾ�� 2:

����: n = 13
���: 2
����: 13 = 4 + 9.


	 */
	//�ݹ�ʵ��
	public int numSquares(int n) {
		int res=n, num=2;
		while(num*num<=n) {
			int a=n/(num*num);
			int b=n%(num*num);
			res=Math.min(res, a+numSquares(b));
			num++;
		}
		return res;
	}
	
	//��̬�滮ʵ��
	public int numSquares2(int n) {
		int[] dp=new int[n+1];
		//�����з�ƽ�����Ľ������󣬱�֤֮��Ƚϵ�ʱ�򲻱�ѡ��
		Arrays.fill(dp, Integer.MAX_VALUE);
		//������ƽ�����Ľ����1;
		for(int i=0;i*i<=n;i++) {
			dp[i*i]=1;
		}
		//��С������������a
		for(int a=0;a<=n;a++) {
			//��С������ƽ����b*b
			for(int b=0;a+b*b<=n;b++) {
				//��Ϊa+b*b���ܱ������ƽ��������������Ҫȡ�����н�С��
				dp[a+b*b]=Math.min(dp[a]+1, dp[a+b*b]);
			}
		}
		return dp[n];
	}
}
