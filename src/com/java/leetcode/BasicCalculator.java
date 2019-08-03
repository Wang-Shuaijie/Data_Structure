package com.java.leetcode;

import java.util.Stack;

public class BasicCalculator {
	/**
	 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。
字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
示例 1:
输入: "1 + 1"
输出: 2
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
	 */
	
	public static int calculate(String s) {
		/*
		 * 需要一个栈来辅助计算，用个变量sign来表示当前的符号，
		 * 我们遍历给定的字符串s，如果遇到了数字，由于可能是个多位数，
		 * 使用了一个变量来保存读入的num，所以在遇到其他字符的时候，都要用sign*num来更新结果res
		 * 如果遇到了加号，则sign赋为1，如果遇到了符号，则赋为-1；如果遇到了左括号，
		 * 则把当前结果res和符号sign压入栈，res重置为0，sign重置为1；
		 * 如果遇到了右括号，结果res乘以栈顶的符号，栈顶元素出栈，
		 * 结果res加上栈顶的数字，栈顶元素出栈。
		 */
		if(s.length()==0 || s==null) return 0;
		int res=0;
		int sign=1;
		int num=0;
		Stack<Integer> stack=new Stack<>();
		for(char c:s.toCharArray()) {
			if(c>='0') {
				//可能是一个多位数
				num=num*10+(c-'0');
			}else if(c=='+') {
				res=res+sign*num;
				num=0;
				sign=1;
			}else if(c=='-') {
				res=res+sign*num;
				num=0;
				sign=-1;
			}else if(c=='(') {
				stack.push(res);
				stack.push(sign);
				res=0;
				sign=1;
			}else if(c==')') {
				res=res+sign*num;
				num=0;
				res=res*stack.pop();
				res=res+stack.pop();
			}
		}
		//res+=sign*num
		return res;
	}
	
	public static void main(String[] args) {
		String s="(1+(4+5+2)-3)+(6+8)";
		System.out.println(calculate(s));
	}
}
