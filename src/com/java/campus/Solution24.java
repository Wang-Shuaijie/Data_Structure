package com.java.campus;
/**
 * 高贵的蕾米莉亚大小姐每天需要饮用定量 B 型血的红茶以保持威严，并且要分两杯在不同时段饮用。
女仆长十六夜咲夜每天可以制作很多杯不同剂量 B 型血的红茶供蕾米莉亚大小姐饮用。
某日，你和天才妖精琪露诺偷偷潜入红魔馆被咲夜抓住，要求在今日份的红茶中挑出所有满足大小姐要求的茶杯，否则……

输入描述:
每个样例有三行输入，第一行输入表示茶杯个数，第二行输入表示每份茶杯里的 B 型血剂量，第三行表示大小姐今天的定量

输出描述:
对每一个样例，输出所有可能的搭配方案，如果有多种方案，请按每个方案的第一杯 B 型血剂量的大小升序排列。
如果无法找到任何一种满足大小姐的方案，输出"NO"(不包括引号)并换行。

示例1
输入
7
2 4 6 1 3 5 7
7

输出
1 6
2 5
3 4
 * @author WangShuaiJie
 *
 */

import java.util.Arrays;
import java.util.Scanner;

public class Solution24 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cups = sc.nextInt();
		sc.nextLine();
		String line = sc.nextLine();
		int target = sc.nextInt();
		sc.close();

		int[] vols = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.sort(vols);

		int s = 0, e = vols.length - 1;
		boolean find = false;
		while (s < e) {
			int firstCup = vols[s], secondCup = vols[e];
			if (firstCup + secondCup == target) {
				System.out.printf("%d %d\n", firstCup, secondCup);
				find = true;
				++s;
			} else if (firstCup + secondCup > target) {
				--e;
			} else {
				++s;
			}
		}

		if (!find) {
			System.out.println("NO");
		}
	}
}
