package com.demo.test;
/**
 * ��һ�е��ģ��Ѱ��������������룺A-Z a-z����һ����ĸ��ɵ�26����ĸ��
 * ��i����ĸ��ɵڣ�26-i+1������ĸ������ĸ�ַ����䡣
 * Ҫ�������������ԭ�ģ�����������ԭ��
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
