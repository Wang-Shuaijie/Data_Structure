package com.java.javaSE精选50题;

import java.util.Arrays;

/**
 * 题目：有n个人围成一圈，顺序排号。
 * 从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
 * @author WangShuaiJie
 *
 */
public class Main37 {
	public static void main(String[] args) {
		findLast(3);
	}
	public static void findLast(int n) {
		boolean[] people=new boolean[n];
		Arrays.fill(people, true);
		int i=n;//总人数
		int countNum=0;
		int index=0;
		while(i>1) {
			if(people[index]==true) {
				countNum++;
				if(countNum==3) {
					countNum=0;
					people[index]=false;
					i--;
				}
			}
			index++;
			if(index==n) {
				index=0;
			}
		}
		for(int j=0;j<n;j++) {
			if(people[j]==true) {
                System.out.println("原排在第" + (j + 1) + "位的人留下了。");
			}
		}
	}
}
