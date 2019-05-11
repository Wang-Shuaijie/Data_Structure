package com.demo.offer;

public class Solution54 {
	/**
	 * 实现一个函数用来判断字符串是否表示数值（包括整数和小数）
	 * 
true

"+100"
"5e2"
"-123"
"3.1416"
"-1E-16"

false

"12e"
"1a3.14"
"1.2.3"
"+-5"
"12e+4.3"
	 */
	public boolean isNumeric1(char[] str) { 
		//1  用正则表达式   判断其是否是数字 
		String res=String.valueOf(str); 
		return res.matches("[\\+-]?[0-9]*(\\.[0-9])?([eE][\\+-]?[0-9]+)?"); 
		/**
        * 正则表达式说明:
        * [\+-]?  + -号可出现也可不出现
        * [0-9]*  整数部分是否出现    [0-9]可以用\\d代替
        * (\.[0-9])?  出现小数点后面必须跟数字
        * ([eE][\+-]?[0-9]+)  若有指数部分E或e肯定出现 + -可以不出现
        *                      紧接着可以跟着整数，也可以什么都没有
        */ 
	}
	
	
	public boolean isNumeric(char[] str) { 
		if (str == null) return false; 
		int index = 0; 
		int ecount = 0; 
		int point = 0; 
		// 如果第一个字符是符号就跳过 
		if (str[0] == '-' || str[0] == '+') index++; 
		for (int i = index; i < str.length; i++) { 
			if (str[i] == '-' || str[i] == '+') { 
				if (str[i-1] != 'e' && str[i-1] != 'E') 
					return false; 
				continue; 
			} 
			if (str[i] == 'e' || str[i] == 'E') { 
				ecount++; 
				if (ecount > 1) return false; 
				if (i == 0 || str[i-1] < 48 || str[i-1] > 57 || i == str.length-1) return false; 
				point++; 
				continue; 
			} 
			if (str[i] == '.') { 
				point++; 
				if (point > 1) return false; 
				continue; 
			} 
			// 出现非数字且不是e/E则返回false（小数点和符号用continue跳过了）
			if ((str[i] < 48 || str[i] > 57) && (str[i] != 'e') && (str[i] != 'E')) return false; 
		} 
		return true;
	}
}
