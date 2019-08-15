package com.java.面试精选;

import java.util.Scanner;

/**
 * 
 * 
 * 给定一个正整数数组，它的第 i 个元素是比特币第 i 天的价格。
 * 
 * 如果你最多只允许完成一笔交易（即买入和卖出一次），设计一个算法来计算你所能获取的最大利润。
 * 
 * 注意你不能在买入比特币前卖出。 输入描述: 正整数数组，为以空格分隔的n个正整数
 * 
 * 输出描述: 最大利润
 * 
 * 输入例子1: 7 1 5 3 6 4
 * 
 * 输出例子1: 5
 * 
 * @author WangShuaiJie
 *
 */
public class Main16 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		int[] price = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			price[i] = Integer.parseInt(str[i]);
		}
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < price.length - 1; i++) {
			if (price[i] < min) {
				min = price[i];
			} else if (price[i] - min >= max) {
				max = price[i] - min;
			}
		}
		System.out.println(max);
	}

	// /*
	// * O(n)的做法 对于第i个位置上的元素，我们只需要知道区间[0, i -
	// * 1]最小值，就可以得出第二个数的位置为i的最大差值有序偶，枚举i就可以得出答案；而区间[0, i - 1]最小值可以预处理出来。
	// */
	// public static void main(String[] args) {
	//
	// Scanner scanner = new Scanner(System.in);
	// int min = scanner.nextInt(), max = 0;
	// int temp;
	// while (scanner.hasNext()) {
	// temp = scanner.nextInt();
	// max = Math.max(max, temp - min);
	// min = Math.min(min, temp);
	// }
	// System.out.println(max);
	// }
}
