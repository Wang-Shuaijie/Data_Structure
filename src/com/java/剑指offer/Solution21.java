package com.java.��ָoffer;

import java.util.Stack;

public class Solution21 {
	/**
	 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������

˼·����������ջ��һ��������ֵ����һ������Сֵ��
	 */
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	public Solution21() {
		stack1=new Stack<>();
		stack2=new Stack<>();
	}
	
	public void push(int x) {
		stack1.push(x);
		if(stack2.isEmpty() || x<stack2.peek()) {
			stack2.push(x);
		}
	}
	
	public int pop() {
		int x=stack1.pop();
		if(x==stack2.peek()) {
			return stack2.pop();
		}
		return x;
	}
	
	public int top() {
		return stack1.peek();
	}
	
	public int getMin() {
		return stack2.peek();
	}
	
}
