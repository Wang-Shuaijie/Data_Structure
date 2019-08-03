package com.java.��ָoffer;

public class Solution43 {
	/**
	 * ��n���������ڵ��ϣ��������ӳ���һ��ĵ���֮��Ϊs,����n,��ӡ��s�����п��ܳ��ֵĸ���
	 */
	public static void printProbability(int n) {
		if(n<1) return;
		int g_maxValue=6;
		int[][] probabilities=new int[2][];
		probabilities[0]=new int[g_maxValue*n+1];
		probabilities[1]=new int[g_maxValue*n+1];
		int flag=0;
		//����һ����������ʱ����6�ֿ��ܣ�ÿ�ֿ��ܳ���һ��
		for(int i=1;i<=g_maxValue;i++) {
			probabilities[0][i]=1;
		}
		//�ӵڶ��ο�ʼ�����ӣ������һ�������еĵ�n�����ֱ�ʾ���Ӻ�Ϊn���ֵĴ�����
		for(int k=2;k<=n;k++) {
			for(int i=0;i<k;i++) {
				 // ��k�������ӣ�����СΪk��С��k������ǲ����ܷ�����,����ܷ����Ĵ�������Ϊ0��
				probabilities[1-flag][i]=0;
				// ��k�������ӣ�����СΪk�����Ϊg_maxValue*k
			}
			for(int i=k;i<=g_maxValue*k;i++) {
				 // ��ʼ������Ϊ�������Ҫ�ظ�ʹ�ã���һ�ε�ֵҪ��0
				probabilities[1-flag][i]=0;
				for(int j=1;j<=i && j<=g_maxValue;j++) {
					probabilities[1-flag][i]+=probabilities[flag][i-j];
				}
			}
			flag=1-flag;
		}
		double total=Math.pow(g_maxValue, n); 
		for(int i=n;i<=g_maxValue*n;i++) { 
			double ratio=(double) probabilities[flag][i]/total; 
			System.out.println(i); 
			System.out.println(ratio); 
		}
	}
	
	public static void main(String[] args) {
		printProbability(2);
	}
}
