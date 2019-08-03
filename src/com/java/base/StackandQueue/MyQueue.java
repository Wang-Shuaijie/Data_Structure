package com.java.base.StackandQueue;
/**
 * ����
 * �ص�:�����ȳ�
 * @author WangShuaiJie
 *
 */
public class MyQueue {
	//������洢����
	int[] elements;
	
	public MyQueue() {
		elements=new int[0];
	}
	
	//���
	public void add(int element) {
		//����һ��������
		int[] newArr=new int[elements.length+1];
		//����
		for(int i=0;i<elements.length;i++) {
				newArr[i]=elements[i];
		}
		newArr[elements.length]=element;
		//��������
		elements=newArr;		
	}
	
	//����
	public int poll() {
		//�����Ƿ���Ԫ��
		if(isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		//�����0��Ԫ��ȡ��
		int element=elements[0];
		//����������
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
