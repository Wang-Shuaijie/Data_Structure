package com.java.leetcode;

import java.util.Stack;

public class LongestValidParenthese {
	/**
	 * ����һ��ֻ���� '(' �� ')' ���ַ������ҳ���İ�����Ч���ŵ��Ӵ��ĳ��ȡ�
	 * ʾ�� 1:
	 * ����: "(()"
	 * ���: 2
	 * ����: ���Ч�����Ӵ�Ϊ "()"
	 * ʾ�� 2:
	 * ����: ")()())"
	 * ���: 4
	 * ����: ���Ч�����Ӵ�Ϊ "()()"
	 * 
	 * ˼·�����������ȿ���ջ
	 */
	public static int longestVaildParentheses(String s) {
		int res=0;
		Stack<Integer> stack=new Stack<>();
		int start=-1;//��ʼλ��
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') {
				stack.push(i);
			}else {
				//ջΪ��
				if(stack.isEmpty()) {
					//�ı���ʼλ
					start=i;
				//ջ��Ϊ��	
				}else {
					//ȡ��ջ��Ԫ��
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
