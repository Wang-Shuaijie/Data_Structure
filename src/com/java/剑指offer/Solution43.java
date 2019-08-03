package com.java.剑指offer;

public class Solution43 {
	/**
	 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s,输入n,打印出s的所有可能出现的概率
	 */
	public static void printProbability(int n) {
		if(n<1) return;
		int g_maxValue=6;
		int[][] probabilities=new int[2][];
		probabilities[0]=new int[g_maxValue*n+1];
		probabilities[1]=new int[g_maxValue*n+1];
		int flag=0;
		//当第一次抛掷骰子时，有6种可能，每种可能出现一次
		for(int i=1;i<=g_maxValue;i++) {
			probabilities[0][i]=1;
		}
		//从第二次开始掷骰子，假设第一个数组中的第n个数字表示骰子和为n出现的次数，
		for(int k=2;k<=n;k++) {
			for(int i=0;i<k;i++) {
				 // 第k次掷骰子，和最小为k，小于k的情况是不可能发生的,令不可能发生的次数设置为0！
				probabilities[1-flag][i]=0;
				// 第k次掷骰子，和最小为k，最大为g_maxValue*k
			}
			for(int i=k;i<=g_maxValue*k;i++) {
				 // 初始化，因为这个数组要重复使用，上一次的值要清0
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
