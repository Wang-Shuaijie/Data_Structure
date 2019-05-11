package com.demo.LeetCode;

import java.util.Stack;

/**
 * 
 * ʹ��ջʵ�ֶ��е����в�����
 * 
 * ��ջ���Ƚ������������ģ������е��Ƚ��ȳ�����ô��ô���أ���ʵ�ܼ򵥣�
 * ֻҪ�����ڲ���Ԫ�ص�ʱ��ÿ�ζ�����ǰ����뼴�ɣ��������һ��������1,2,3,4��
 * ��ô������ջ�б���Ϊ4,3,2,1����ô����ջ��Ԫ��1��Ҳ���Ƕ��е���Ԫ�أ�
 * ������ӭ�ж��⡣���Դ�����Ѷ���push������
 * ������Ҫһ������ջtmp����s��Ԫ��Ҳ����˳�����tmp�У�
 * ��ʱ������Ԫ��x���ٰ�tmp�е�Ԫ�ش������������������Ҫ��˳���ˣ�
 * ������������Ҳ��ֱ�ӵ���ջ�Ĳ�������
 *
 */
public class ImplementQueueusingStacks {
	//���ڴ��Ԫ�ص�ջ
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	public ImplementQueueusingStacks() {
		stack1=new Stack<>();
		stack2=new Stack<>();
	}
	/*
	 * ����д�ᳬʱ���򻯴��룬����ջ��������

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
		
		//�����ݷŻ�ԭ����ջ
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
		
		//�����ݷŻ�ԭ����ջ
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
		
		//�����ݷŻ�ԭ����ջ
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

