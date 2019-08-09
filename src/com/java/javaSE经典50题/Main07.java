package com.java.javaSE经典50题;
/**
 * 题目：求s=a+aa+aaa+aaaa+aa…a的值，其中a是一个数字。
 * 例如2+22+222+2222+22222(此时共有5个数相加)，
 * 几个数相加有键盘控制。输出结果的形式如：2+22+222=246
 * @author WangShuaiJie
 *
 */
public class Main07 {
	public static void main(String[] args) {
		System.out.println(getSum(2, 3));
	}
	
	private static int getSum(int num, int count) {
		/*
		 * 2+22+222
		 * 1、第一项有一个num,最后一项有3个num
		 * 2、 第1和第2项相差num*10，第2和第三项相差num*100，第k和第k+1项相差2*（10的k次方）
		 */
		int sum=0;
		int tmp=num;
		for(int i=1;i<=count;i++) {
			//System.out.println(num);
			sum+=num;
			num=num+tmp*(int)Math.pow(10, i);			
		}
		return sum;
	}
}
