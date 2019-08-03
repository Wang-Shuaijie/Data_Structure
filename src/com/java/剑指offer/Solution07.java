package com.java.��ָoffer;

import java.util.Stack;

public class Solution07 {
	/**
	 * ������ջ��ɶ���
	 * ջ���ص㣺�����ȳ�
	 */
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	public Solution07() {
		stack1=new Stack<>();
		stack2=new Stack<>();
	}
	
	public void push(int x) {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		//���к��������������ķŵ���ײ�
		stack1.push(x);
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}
	
	public int pop() {
		if(!stack1.isEmpty()) {
			return stack1.pop();
		}
		return 0;
	}
	
	/*public void push(int x) {
		stack1.push(x);
	}
	
	public int pop() {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		int res=0;
		while(!stack2.isEmpty()) {
			res=stack2.pop();
		}
		
		//�����ݷŻ�ԭ����ջ
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return res; 
	}*/
	
}
