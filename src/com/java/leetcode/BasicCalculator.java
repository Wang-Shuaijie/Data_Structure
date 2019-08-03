package com.java.leetcode;

import java.util.Stack;

public class BasicCalculator {
	/**
	 * ʵ��һ�������ļ�����������һ���򵥵��ַ������ʽ��ֵ��
�ַ������ʽ���԰��������� ( �������� )���Ӻ� + ������ -���Ǹ������Ϳո�  ��
ʾ�� 1:
����: "1 + 1"
���: 2
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
	 */
	
	public static int calculate(String s) {
		/*
		 * ��Ҫһ��ջ���������㣬�ø�����sign����ʾ��ǰ�ķ��ţ�
		 * ���Ǳ����������ַ���s��������������֣����ڿ����Ǹ���λ����
		 * ʹ����һ����������������num�����������������ַ���ʱ�򣬶�Ҫ��sign*num�����½��res
		 * ��������˼Ӻţ���sign��Ϊ1����������˷��ţ���Ϊ-1����������������ţ�
		 * ��ѵ�ǰ���res�ͷ���signѹ��ջ��res����Ϊ0��sign����Ϊ1��
		 * ��������������ţ����res����ջ���ķ��ţ�ջ��Ԫ�س�ջ��
		 * ���res����ջ�������֣�ջ��Ԫ�س�ջ��
		 */
		if(s.length()==0 || s==null) return 0;
		int res=0;
		int sign=1;
		int num=0;
		Stack<Integer> stack=new Stack<>();
		for(char c:s.toCharArray()) {
			if(c>='0') {
				//������һ����λ��
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
