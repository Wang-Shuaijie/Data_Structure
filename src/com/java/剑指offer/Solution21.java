package com.java.剑指offer;

import java.util.Stack;

public class Solution21 {
	/**
	 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。

思路：定义两个栈，一个存放入的值。另一个存最小值。
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
