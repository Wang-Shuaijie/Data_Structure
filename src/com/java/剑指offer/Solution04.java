package com.java.剑指offer;

public class Solution04 {
	/**
	 * 将一个字符串中的空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy
	 */
	public String replaceSpace(String str) {
		if(str==null || str.length()==0) return str;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==' ') {
				sb.append("%20");
			}else {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}
}
