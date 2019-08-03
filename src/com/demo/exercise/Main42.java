package com.demo.exercise;
/**
 * 题目：809*??=800*??+9*??+1
 * 其中??代表的两位数,8*??的结果为两位数，9*??的结果为3位数。
 * 求??代表的两位数，及809*??后的结果。
 * @author WangShuaiJie
 *
 */
public class Main42 {
	public static void main(String[] args) {
		int x = 0;
		boolean flag = false;
		for (int i = 10; i < 100; i++) {
			if (809 * i == 800 * i + 9 * i + 1) {
				flag = true;
				x = i;
				break;
			}
 
		}
		if (flag) {
			System.out.print("这个两位数是" + x);
			System.out.print("809*??的结果是:" + 809 * x);
		} else
			System.out.print("无符合要求的数");

	}
}
