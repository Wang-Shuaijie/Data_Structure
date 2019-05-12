package com.demo.leetcode;

public class CountandSay {
	/**
	 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
	 * 1.     1
	 * 2.     11
	 * 3.     21
	 * 4.     1211
	 * 5.     111221
	 * 1 被读作  "one 1"  ("一个一") , 即 11。
	 * 11 被读作 "two 1s" ("两个一"）, 即 21。
	 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
	 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
	 * 注意：整数顺序将表示为一个字符串。
	 * 示例 1:
	 * 输入: 1 输出: "1"
	 * 示例 2:
	 * 输入: 4 输出: "1211"
	 * 
	 */
	public static String countAndSay(int n) {
        //暴力解
		/*
		 * 思路：
		 * 就是对于前一个数，找出相同元素的个数，
		 * 把个数和该元素存到新的string里
		 * 题意是n=1时输出字符串1；n=2时，
		 * 数上次字符串中的数值个数，因为上次字符串有1个1，
		 * 所以输出11；n=3时，由于上次字符是11，有2个1，所以输出21；
		 * n=4时，由于上次字符串是21，有1个2和1个1
		 * i=1 count=0 c=1
		 * j=0 count++; sb=11
		 * res="11" i=2
		 * count=0 c="1"
		 * j=0 count=1
		 * j=1 count=2
		 * j=2 res="21"
		 * ...
		 */
		int i=1;
		String res="1";
		while(i<n) {
			int count=0;
			StringBuilder sb=new StringBuilder();
			char c=res.charAt(0);
			//这里必须=，否则会越界，判断须去掉=res.length的情况
			for(int j=0;j<=res.length();j++) {
				if(j!=res.length() && res.charAt(j)==c) {
					count++;
				}else {
					sb.append(count);
					sb.append(c);
					//System.out.println(sb.toString());
					if(j!=res.length()) {
						count=1;
						c=res.charAt(j);
					}
				}
			}
			res=sb.toString();
			i++;
		}
		return res;
    }
	
	
	public static void main(String[] args) {
		int n=4;
		System.out.println(countAndSay(n));
	}
}
