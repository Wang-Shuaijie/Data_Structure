package com.demo.LeetCode;

import java.util.Stack;

public class ValidParentheses {
	/**
	 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
	 * 有效字符串需满足：左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。
	 * 注意空字符串可被认为是有效字符串。
	 * 示例 1:输入: "()"输出: true
	 * 思路：利用栈的原理
	 */
	
	public static boolean isValid(String s) {
		if(s==null || s.length()==0) return true;
		Stack<Character> stack=new Stack<>();
		//进栈
		for(Character ch:s.toCharArray()) {
			if(ch=='(') {
				stack.push(')');
			}else if(ch=='[') {
				stack.push(']');
			}else if(ch=='{') {
				stack.push('}');
			}else {
				//如果栈为空或者出栈元素不是ch(出栈操作是必须执行的)
				if(stack.isEmpty() || stack.pop() != ch) {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		String s="{[()]}";
		System.out.println(isValid(s));
	}
}
