package com.demo.LeetCode;

import java.util.Stack;

/**
 * 
 * 使用栈实现队列的下列操作：
 * 
 * 用栈的先进后出的特性来模拟出队列的先进先出。那么怎么做呢，其实很简单，
 * 只要我们在插入元素的时候每次都都从前面插入即可，比如如果一个队列是1,2,3,4，
 * 那么我们在栈中保存为4,3,2,1，那么返回栈顶元素1，也就是队列的首元素，
 * 则问题迎刃而解。所以此题的难度是push函数，
 * 我们需要一个辅助栈tmp，把s的元素也逆着顺序存入tmp中，
 * 此时加入新元素x，再把tmp中的元素存回来，这样就是我们要的顺序了，
 * 其他三个操作也就直接调用栈的操作即可
 *
 */
public class ImplementQueueusingStacks {
	//用于存放元素的栈
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	public ImplementQueueusingStacks() {
		stack1=new Stack<>();
		stack2=new Stack<>();
	}
	/*
	 * 这样写会超时，简化代码，对入栈操作更改

	public void push(int x) {
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
		
		//把数据放回原来的栈
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return res;
	}
	
	public int peek() {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		int res=0;
		while(!stack2.isEmpty()) {
			res=stack2.peek();
		}
		
		//把数据放回原来的栈
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
		return res;
	}
	
	public boolean empty() {
		return stack1.isEmpty();
	}
	*/
	 public void push(int x) {
        while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		stack1.push(x);
		
		//把数据放回原来的栈
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}

    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack1.isEmpty()) return -1;
        return stack1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(stack1.isEmpty()) return -1;
        return stack1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
}

