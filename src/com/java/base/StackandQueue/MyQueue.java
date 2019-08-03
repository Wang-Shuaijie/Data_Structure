package com.java.base.StackandQueue;
/**
 * 队列
 * 特点:先入先出
 * @author WangShuaiJie
 *
 */
public class MyQueue {
	//用数组存储数据
	int[] elements;
	
	public MyQueue() {
		elements=new int[0];
	}
	
	//入队
	public void add(int element) {
		//创建一个新数组
		int[] newArr=new int[elements.length+1];
		//遍历
		for(int i=0;i<elements.length;i++) {
				newArr[i]=elements[i];
		}
		newArr[elements.length]=element;
		//更新数组
		elements=newArr;		
	}
	
	//出队
	public int poll() {
		//队列是否有元素
		if(isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		//数组第0个元素取出
		int element=elements[0];
		//创建新数组
		int[] newArr =new int[elements.length-1];
		
		for(int i=0;i<newArr.length;i++) {
			newArr[i]=elements[i+1];
		}
		
		elements = newArr;
		return element;
	}
	
	public boolean isEmpty() {
		return elements.length == 0;
	}
	
	/*
	public static void main(String[] args) {
		MyQueue queue=new MyQueue();
		queue.add(5);
		queue.add(6);
		System.out.println(queue.poll());
	}
	*/
}
