package com.demo.LeetCode;

import java.util.Stack;

public class ValidParentheses {
	/**
	 * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
	 * ��Ч�ַ��������㣺�����ű�������ͬ���͵������űպϡ� �����ű�������ȷ��˳��պϡ�
	 * ע����ַ����ɱ���Ϊ����Ч�ַ�����
	 * ʾ�� 1:����: "()"���: true
	 * ˼·������ջ��ԭ��
	 */
	
	public static boolean isValid(String s) {
		if(s==null || s.length()==0) return true;
		Stack<Character> stack=new Stack<>();
		//��ջ
		for(Character ch:s.toCharArray()) {
			if(ch=='(') {
				stack.push(')');
			}else if(ch=='[') {
				stack.push(']');
			}else if(ch=='{') {
				stack.push('}');
			}else {
				//���ջΪ�ջ��߳�ջԪ�ز���ch(��ջ�����Ǳ���ִ�е�)
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
