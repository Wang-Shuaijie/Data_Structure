package com.demo.leetcode;

public class StringtoInteger {
	/**
	 * "42"  42
	 * "-42" -42
	 * "4193w"  4193
	 */
	
	public static int myAtoi(String str) {
		if(str==null || str.length()==0) return 0;
		//去除空格(首尾)
		str=str.trim();
		//第一个字符
		char firstChar=str.charAt(0);
		int sign=1;
		int start=0;
		long res=0;
		if(firstChar=='+') {
			sign=1;
			start++;
		}else if(firstChar=='-') {
			sign=-1;
			start++;
		}
		for(int i=0;i<str.length();i++) {
			//判断当前是否是数字字符
			if(!Character.isDigit(str.charAt(i))) {
				return (int)res*sign;
			}
			//字符串里面的数字会变成ASCII码值进行计算，所以才要减去'0'
			res=res*10+str.charAt(i)-'0';
			if(sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
			if(sign == -1 && res >Integer.MAX_VALUE) return Integer.MIN_VALUE;
		}
		return (int)res*sign;
	}
	public static int myAoti2(String str) {
		if (str.isEmpty()) return 0;
        int sign = 1, base = 0, i = 0, n = str.length();
        while (i < n && str.charAt(i) == ' ') ++i;
        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            sign = (str.charAt(i++) == '+') ? 1 : -1;
        }
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;
	}
	
	public static void main(String[] args) {
		String s="12344";
		int res=myAtoi(s);
		System.out.println(res);
	}
}
