package com.demo.LeetCode;

import java.util.Stack;

public class MinStack {
/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
    push(x) -- 将元素 x 推入栈中。
    pop() -- 删除栈顶的元素。
    top() -- 获取栈顶元素。
    getMin() -- 检索栈中的最小元素
    
    思路：这道最小栈跟原来的栈相比就是多了一个功能，可以返回该栈的最小值。使用两个栈来实现，
    一个栈来按顺序存储push进来的数据，另一个用来存出现过的最小值。
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
    	//不能对两个stack同时调用peek()函数来比较,如果这样写永远返回false;
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
