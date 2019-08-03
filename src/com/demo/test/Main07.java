package com.demo.test;
/**
 * 输入一个数字要求输出该数字各个位上偶数的和，如输入5584，输出12。
 * @author WangShuaiJie
 *
 */
public class Main07 {
	public static void main(String[] args) {
		System.out.println(getSum(25584));
	}
	private static int getSum(int num) {
		int temp=0;
		int sum=0;
		while(num>1) {
			temp=num%10;
			if(temp%2==0) {
				sum+=temp;
			}
			num=num/10;
		}
		return sum;
	}
}
