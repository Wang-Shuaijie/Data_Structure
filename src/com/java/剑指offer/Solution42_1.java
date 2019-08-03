package com.java.剑指offer;

public class Solution42_1 {
	/**
	 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出
	 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。
	 */
	public static String leftRotateString(String str,int k) {
		//拼接或反转三次字符串
		if(str.length()==0 || str==null) return null;
		String s1=str.substring(0, k);
		String s2=str.substring(k, str.length());
		return s2+s1;
	}
	
	public static String leftRotateString2(String str,int k) {
		//拼接或反转三次字符串
		if(str.length()==0 || str==null) return null;
		char[] chars=str.toCharArray();
		for(int i=0;i<chars.length;i++) {
			chars[i]=str.charAt((i+k)%str.length());
		}
		return String.valueOf(chars);
	}
	
	public static void main(String[] args) {
		String str="abcXYZdef";
		System.out.println(leftRotateString2(str, 3));
	}
}
