package com.demo.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 用队列实现栈
 *
 */
public class ImplementStackusingQueues {
	private Queue<Integer> queue;
	
	public ImplementStackusingQueues() {
		queue=new LinkedList<>();
	}
	/** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for(int i=0;i<queue.size()-1;i++) {
        	queue.add(queue.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	if(queue.isEmpty()) return -1;
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
    	if(queue.isEmpty()) return -1;
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
