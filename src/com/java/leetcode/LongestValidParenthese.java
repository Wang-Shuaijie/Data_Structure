package com.java.leetcode;

import java.util.Stack;

public class LongestValidParenthese {
	/**
	 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
	 * 示例 1:
	 * 输入: "(()"
	 * 输出: 2
	 * 解释: 最长有效括号子串为 "()"
	 * 示例 2:
	 * 输入: ")()())"
	 * 输出: 4
	 * 解释: 最长有效括号子串为 "()()"
	 * 
	 * 思路：括号问题先考虑栈
	 */
	public static int longestVaildParentheses(String s) {
		int res=0;
		Stack<Integer> stack=new Stack<>();
		int start=-1;//起始位置
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				stack.push(i);
			}else {
				//栈为空
				if(stack.isEmpty()) {
					//改变起始位
					start=i;
				//栈不为空	
				}else {
					//取出栈顶元素
					stack.pop();
					if(stack.isEmpty()) {
						res=Math.max(res,i-start);
					}else {
						res=Math.max(res, i-stack.peek());
					}
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String s="(()))";
		System.out.println(longestVaildParentheses(s));
	}
}
