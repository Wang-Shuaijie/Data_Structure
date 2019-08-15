package com.java.campus;

import java.util.Scanner;
import java.util.Stack;

/**
 * 有K种颜色的小球(K<=10)，每种小球有若干个，总数小于100个。
 * 现在有一个小盒子，能放N个小球(N<=8)，现在要从这些小球里挑出N个小球，放满盒子。 想知道有哪些挑选方式。注：每种颜色的小球之间没有差别。
 * 
 * 请按数字递增顺序输出挑选小球的所有方式。
 * 
 * 如有3种颜色，每种颜色小球的个数分别为a:1,b:2,c:3，挑出3个小球的挑法有： 003,012,021,102,111,120
 * 
 * 
 * 输入描述:
 * 
 * 第一行两个数字K N，分别表示小球种类数目和挑选的小球个数 第二行开始为每种小球的数目，共N行数据
 * 
 * 
 * 输出描述: 输出所有可行的挑选方案，按升序排列
 * 
 * 输入例子1: 3 3 1 2 3
 * 
 * 输出例子1: 003 012 021 102 111 120
 * 
 * @author WangShuaiJie
 *
 */
public class Solution26 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			int[] nums = new int[k];
			for (int i = 0; i < k; i++) {
				nums[i] = sc.nextInt();
			}
			Stack<String> stack = new Stack<String>();
			helper(nums, n, 0, stack, "");
			while (!stack.isEmpty()) {
				System.out.println(stack.pop());
			}
		}

	}

	private static void helper(int[] nums, int target, int index, Stack<String> stack, String string) {
		if (index == nums.length && target == 0) {
			stack.push(string);
			return;
		}
		int nextTarget = 0;
		for (int i = Math.min(target, nums[index]); i >= 0; i--) {
			nextTarget = target - i;
			helper(nums, nextTarget, index + 1, stack, string + "i");
		}
	}
}
