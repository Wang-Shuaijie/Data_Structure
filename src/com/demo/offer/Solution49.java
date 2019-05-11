package com.demo.offer;

public class Solution49 {
	/**
	 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
	 */
	public int strtoInt(String str) {
		if(str.length()==0 && str==null) return 0;
		int res=0;
		int sign=1;
		int i=0;
		if(str.charAt(0)=='-') {
			sign=1;
			i++;
		}
		if(str.charAt(0)=='+') {
			sign=1;
			i++;
		}
		for(;i<str.length();i++) {
			if(str.charAt(i)<'0' || str.charAt(i)>'9') {
				return 0;
			}else {
				res=res*10+str.charAt(i)-'0';
			}
		}
		return res*sign;
	}
}
