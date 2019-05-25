package com.demo.offer;

import java.util.Arrays;

public class Solution09 {
	
	//���Ƽ�����Խ��ķ���(��1��ʼ)
	public static int febonaqcci(int i) {
		if(i<=0) return 0;
		else if(i==1 || i==2) {
			return 1;
		}else {
			return febonaqcci(i-1)+febonaqcci(i-2);
		}
	}
	
	
	
	/**
	 * �ѵݹ���ѭ���ɷ�ֹջ���
	 * ����Ҫ������һ������n���������쳲��������еĵ�n�n<=39
	 */
	
	public long febonaqcci2(int n) {
		long res=0;
		long firstNum=1;
		long secondNum=0;

		if(n==1) {
			return 1;
		}
		for(int i=2;i<=n;i++) {
			res=firstNum+secondNum;
			secondNum=firstNum;
			firstNum=res;
		}
		return res;
	}
	
	/**
	 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2���������������һ��n����̨���ܹ��ж�����������
	 * ˼·��feibonaqcci˼��,���n����
	 * 
	 *             | 1, (n=1)
        f(n) =     | 2, (n=2)
                   | f(n-1)+f(n-2) ,(n>2,nΪ����)
	 */
	public static int febonaqcci3(int i) {
		if(i==0) return 0;
		else if(i==1) {
			return 1;
		}
		else if(i==2) {
			return 2;
		}
		else {
			return febonaqcci(i-1)+febonaqcci(i-2);
		}
	}
	
	/**
	 * ���ǿ����� 2*1 ��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
	 * ������ n �� 2*1 ��С�������ص��ظ���һ�� 2*n �Ĵ���Σ��ܹ��ж����ַ�����
	 */
	public int RectCover(int n) {
	    if (n <= 2)
	        return n;
	    int pre2 = 1, pre1 = 2;
	    int result = 0;
	    for (int i = 3; i <= n; i++) {
	        result = pre2 + pre1;
	        pre2 = pre1;
	        pre1 = result;
	    }
	    return result;
	} 
	
	
	/**
	 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
	 * 2^(n-1)
	 * ��f(n)=2*f(n-1)
	 */
	public int JumpFloor2(int target) {
        return (int) Math.pow(2,target-1);
    }
	//��̬�滮
	public int JumpFloorII(int target) {
	    int[] dp = new int[target];
	    Arrays.fill(dp, 1);
	    for (int i = 1; i < target; i++)
	        for (int j = 0; j < i; j++)
	            dp[i] += dp[j];
	    return dp[target - 1];
	}
	
	
	//����ũ���г����ĸţÿ��ֻ����1ͷСĸţ��������Զ��������
	//��һ��ũ����1ֻ�����ĸţ���ӵڶ��꿪ʼ��ĸţ��ʼ��Сĸţ��
	//ÿֻСĸţ3��֮������ֿ�����Сĸţ��
	//��������N�����N���ţ��������
	//f[i]�����i��ĸţ����������ôf[i]=f[i-1]+f[i-3]
	//��i���ĸţͷ�� = ȥ���ľţͷ�� + ������Сţͷ��(ֻ�о��i��3��ǰ��ţ������Сţ)��
	public int cowNum(int n){
        if(n <= 0)
            return 0;
        if(n == 1 || n == 2 || n == 3)
            return n;
        return cowNum(n - 1) + cowNum(n - 3);
    }
	
	
	/*
	 * ��һ�����Ӽ��ɶ�Σ�����ʹ��ÿ�εĳ��ȳ˻����

n = 2
return 1 (2 = 1 + 1)

n = 10
return 36 (10 = 3 + 3 + 4)
	 */
	public int integerBreak(int n) {
		// ̰���㷨
		// �����ܶ������Ϊ 3 �����ӣ����Ҳ������г���Ϊ 1 �����ӳ��֡�
		//��������ˣ��ʹ��Ѿ��кó���Ϊ 3 ���������ó�һ���볤��Ϊ 1
		// ������������ϣ��������г����γ���Ϊ 2 ������
		if (n < 2)
			return 0;
		if (n == 2)
			return 1;
		if (n == 3)
			return 2;
		int timesOf3 = n / 3;
		if (n - timesOf3 * 3 == 1)
			timesOf3--;
		int timesOf2 = (n - timesOf3 * 3) / 2;
		return (int) (Math.pow(3, timesOf3)) * (int) (Math.pow(2, timesOf2));
	}
	
	public int integerBreak2(int n) {
		// ��̬�滮
		int[] dp=new int[n+1];
		dp[1]=1;
		for(int i=2;i<=n;i++) {
			for(int j=1;j<i;j++) {
				dp[i]=Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
			}
		}
		return dp[n];
	}
	
}
