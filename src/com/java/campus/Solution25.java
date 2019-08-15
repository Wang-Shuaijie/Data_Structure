package com.java.campus;

import java.util.Scanner;

/**
 * 从字符串string开始完整匹配子串sub，返回匹配到的字符个数。 sub中如果出现'?'表示可以匹配一到三个除'\0'以外的任意字符。
 * 如果sub还有找不到匹配的字符，则说明不能完整匹配。
 * 如果能完整匹配，返回匹配到的字符个数，如果有多种匹配方式，返回匹配字符数最少的那个，如果不能完整匹配，返回-1
 * 
 * 输入描述: 第一行输入字符串string，长度小于10000 第二行输入子串sub，长度小于100
 * 
 * 
 * 输出描述: 从string开头位置完整匹配sub，匹配到的字符个数。
 * 
 * 输入例子1: abcdefg a?c
 * 
 * 输出例子1: 3
 * 
 * 输入例子2: aabcddefg a?c
 * 
 * 输出例子2: 4
 * 
 * 输入例子3: aabcddefg b?e
 * 
 * 输出例子3: -1
 * 
 * 输入例子4: aabcddefg a?d
 * 
 * 输出例子4: 5
 * 
 * @author WangShuaiJie
 *
 */
public class Solution25 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String sub = sc.nextLine();
		System.out.println(getIndex(str, sub));
	}

	private static int getIndex(String str, String sub) {
		if (sub.charAt(0) != str.charAt(0))
			return -1;
		int count = 0;
		int i = 1;
		int j = i;
		while (i < sub.length() && j < str.length()) {
			if (sub.charAt(i) != '?') {
				if (sub.charAt(i) != str.charAt(j)) {
					return -1;
				}
			} else {
				for (; j <= i + 3 && j < str.length(); j++) {
					if (str.charAt(j) == sub.charAt(i + 1)) {
						break;
					}
				}
				if (str.charAt(j) != sub.charAt(i + 1))
					return -1;
				j = j - 1;
				
			}
			i++;
			j++;
		}
		if (i != sub.length())
			return -1;
		return j;
	}
}
