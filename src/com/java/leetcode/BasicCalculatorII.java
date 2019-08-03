package com.java.leetcode;

import java.util.Stack;

public class BasicCalculatorII {
	/**
	 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。

字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

示例 1:

输入: "3+2*2"
输出: 7

	 */
	public int calculate(String s) {
		if (s == null || (s.length()) == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int num = 0;
		char sign = '+';
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i) - '0';
			}
			if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == s.length() - 1) {
				if (sign == '-') {
					stack.push(-num);
				}
				if (sign == '+') {
					stack.push(num);
				}
				if (sign == '*') {
					stack.push(stack.pop() * num);
				}
				if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = s.charAt(i);
				num = 0;
			}
		}

		int re = 0;
		for (int i : stack) {
			re += i;
		}
		return re;

	}
	
	public int calculate2(String s) {
		if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        s += '+';
        char op = '+';
        for (int i = 0, n = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') { n = n * 10 + c - '0'; continue; }
            if (c == ' ') continue;
            if (op == '+') stack.push(n);
            else if (op == '-') stack.push(-n);
            else if (op == '*') stack.push(stack.pop()*n);
            else if (op == '/') stack.push(stack.pop()/n);
            op = c;
            n = 0;
        }

        int total = 0;
        while (!stack.isEmpty()) total += stack.pop();
        return total;
	}
}
