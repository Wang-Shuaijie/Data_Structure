package com.demo.test;
/**
 * 有一行电文，已按下面规律译成密码：A-Z a-z即第一个字母变成第26个字母，
 * 第i个字母变成第（26-i+1）个字母。非字母字符不变。
 * 要求编程序将密码译回原文，并输出密码和原文
 * @author WangShuaiJie
 *
 */
public class Main08 {
	public static void main(String[] args) {
		String s="abc";
		change(s);
	}
	private static void change(String str) {
		for(char c:str.toCharArray()) {
			if(c>='a' && c<='z') {
				c=(char) ('z'-(c-'a'));
				System.out.print(c);
			}
			if(c>='A' && c<='Z') {
				c=(char) ('Z'-(c-'A'));
				System.out.print(c);
			}
		}
	}
}
