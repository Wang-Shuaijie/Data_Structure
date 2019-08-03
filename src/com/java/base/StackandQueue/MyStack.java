package com.java.base.StackandQueue;
/**
 * 栈
 * 特点:先入后出
 * @author WangShuaiJie
 *
 */
public class MyStack {
	//栈的底层使用数组来存储数据
	int[] elements;
	
	public MyStack() {
		elements=new int[0];
	}
	
	//压入元素(添加)
	public void push(int element) {
		//创建一个新数组
		int[] newArr=new int[elements.length+1];
		
		for(int i=0;i<elements.length;i++) {
			newArr[i]=elements[i];
		}
		newArr[elements.length]=element;
		//更新数组
		elements=newArr;
	}
	
	//取出栈顶元素(并删除)调整栈的大小
	public int pop() {
		//栈中没有元素
		if(isEmpty()) {
			throw new RuntimeException("stack is empty");
		}
		//相当于取出数组最后一个元素
		int element=elements[elements.length-1];
		//创建一个新数组
		int[] newArr=new int[elements.length-1];
		//把原有数组除最后一个元素外放入新数组
		for(int i=0;i<newArr.length;i++) {
			newArr[i]=elements[i];
		}
		//替换
		elements=newArr;
		//返回栈顶元素
		return element;
	}
	
	//查看栈顶元素(不删除)
	public int peek() {
		//栈中没有元素
		if(isEmpty()) {
			throw new RuntimeException("stack is empty");
		}
		return elements[elements.length-1];
	}
	
	//判断栈是否为空
	public boolean isEmpty() {
		return elements.length==0;
	}
	
	/*
	public static void main(String[] args) {
		MyStack stack=new MyStack();
		stack.push(2);
		stack.push(5);
		stack.push(9);
		System.out.println(stack.pop());
	}
	*/
}
