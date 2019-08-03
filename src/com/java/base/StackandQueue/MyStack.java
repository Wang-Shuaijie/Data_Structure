package com.java.base.StackandQueue;
/**
 * ջ
 * �ص�:������
 * @author WangShuaiJie
 *
 */
public class MyStack {
	//ջ�ĵײ�ʹ���������洢����
	int[] elements;
	
	public MyStack() {
		elements=new int[0];
	}
	
	//ѹ��Ԫ��(���)
	public void push(int element) {
		//����һ��������
		int[] newArr=new int[elements.length+1];
		
		for(int i=0;i<elements.length;i++) {
			newArr[i]=elements[i];
		}
		newArr[elements.length]=element;
		//��������
		elements=newArr;
	}
	
	//ȡ��ջ��Ԫ��(��ɾ��)����ջ�Ĵ�С
	public int pop() {
		//ջ��û��Ԫ��
		if(isEmpty()) {
			throw new RuntimeException("stack is empty");
		}
		//�൱��ȡ���������һ��Ԫ��
		int element=elements[elements.length-1];
		//����һ��������
		int[] newArr=new int[elements.length-1];
		//��ԭ����������һ��Ԫ�������������
		for(int i=0;i<newArr.length;i++) {
			newArr[i]=elements[i];
		}
		//�滻
		elements=newArr;
		//����ջ��Ԫ��
		return element;
	}
	
	//�鿴ջ��Ԫ��(��ɾ��)
	public int peek() {
		//ջ��û��Ԫ��
		if(isEmpty()) {
			throw new RuntimeException("stack is empty");
		}
		return elements[elements.length-1];
	}
	
	//�ж�ջ�Ƿ�Ϊ��
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
