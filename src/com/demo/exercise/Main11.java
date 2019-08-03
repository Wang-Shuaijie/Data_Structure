package com.demo.exercise;
/**
 * 题目：有1、2、3、4个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
 * @author WangShuaiJie
 *
 */
public class Main11 {
	//填在百位、十位、个位的数字都是1、2、3、4。这里要用3个for循环
	public static void main(String[] args) {
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=4;j++) {
				for(int k=1;k<=4;k++) {
					if(i!=j && j!=k && i!=k) {
						System.out.println(i*100+j*10+k);
					}
				}
			}
		}
	}
}
