package com.demo.LeetCode;

import java.util.Stack;

public class MinStack {
/**
 * ���һ��֧�� push��pop��top �����������ڳ���ʱ���ڼ�������СԪ�ص�ջ��
    push(x) -- ��Ԫ�� x ����ջ�С�
    pop() -- ɾ��ջ����Ԫ�ء�
    top() -- ��ȡջ��Ԫ�ء�
    getMin() -- ����ջ�е���СԪ��
    
    ˼·�������Сջ��ԭ����ջ��Ⱦ��Ƕ���һ�����ܣ����Է��ظ�ջ����Сֵ��ʹ������ջ��ʵ�֣�
    һ��ջ����˳��洢push���������ݣ���һ����������ֹ�����Сֵ��
 */
	private Stack<Integer> stack1=new Stack<>();
	private Stack<Integer> stack2=new Stack<>();
	
	public MinStack(){
		
	}
	
	public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty() || x<=stack2.peek()) {
        	stack2.push(x);
        }
    }
    
    public void pop() {
    	// Cannot write like the following:
    	//���ܶ�����stackͬʱ����peek()�������Ƚ�,�������д��Զ����false;
        // if (s2.peek() == s1.peek()) s2.pop();
        // s1.pop();
    	int x=stack1.pop();
    	if(x==stack2.peek()) {
    		stack2.pop();
    	}
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return stack2.peek();
    }
}
