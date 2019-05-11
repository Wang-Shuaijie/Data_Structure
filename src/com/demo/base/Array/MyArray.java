package com.demo.base.Array;

import java.util.Arrays;


/**
 * �����������
 * @author WangShuaiJie
 *
 */
public class MyArray {
	//���ڴ洢���ݵ�����
	private int[] elements;
	
	public MyArray() {
		//��ʼ��
		elements=new int[0];
	}
	
	//��ȡ���鳤�ȵķ���
	public int size() {
		return elements.length;
	}
	
	//������ĩβ���Ԫ��
	public void add(int element) {
		//����һ��������
		int[] newArr = new int[elements.length+1];
		//������Ԫ�ظ��Ƶ�������
		for(int i=0;i<elements.length;i++) {
			newArr[i]=elements[i];
		}
		newArr[elements.length]=element;
		//�滻ԭ������
		elements=newArr;
	}
	
	//ɾ�������е�Ԫ��
	public void delete(int index) {
		if(index < 0 || index > elements.length) {
			throw new RuntimeException( "�±�Խ��");
		}
		//����һ��������
		int[] newArr =new int[elements.length-1];
		for(int i=0;i<newArr.length;i++) {
			if(i<index) {
				newArr[i]=elements[i]; 
			}else {
				newArr[i]=elements[i+1];
			}
		}
		elements=newArr;
	}
	
	//ɾ�������е�Ԫ��
	public void deleteElemnet(int val) {
		int res=0;
		for(int i=0;i<elements.length;i++) {
			if(elements[i]==val) {
				elements[res]=elements[i];
				res++;
			}					
		}
	}
	
	//��ȡĳ��Ԫ��
	public int get(int index) {
		if(index < 0 || index > elements.length) {
			throw new RuntimeException("�±�Խ��");
		}
		return elements[index];
	}
	
	//����һ��Ԫ�ص�ָ��λ��
	public void insert(int index,int element) {
		if(index < 0 || index > elements.length) {
			throw new RuntimeException("�±�Խ��");
		}
		//����һ��������
		int[] newArr =new int[elements.length+1];
		for(int i=0;i<elements.length;i++) {
			//Ŀ��Ԫ��֮ǰ
			if(i<index) {
				newArr[i] = elements[i];
			//Ŀ��Ԫ��֮��
			}else {
				newArr[i+1] = elements[i];
			}
		}
		newArr[index]=element;
		
		elements=newArr;
	}
	
	//�滻ָ��λ��Ԫ��
	public void set(int index,int element) {
		if(index < 0 || index > elements.length) {
			throw new RuntimeException("�±�Խ��");
		}
		elements[index]=element;
	}
	
	//���Բ���
	public int search(int target) {
		//��������
		for(int i=0;i<elements.length;i++) {
			if(elements[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	//���ַ�����(��������)
	public int binarySearch(int target) {
		int left=0;
		int right=elements.length-1;
		//����
		while(left <= right) {
			int mid = (left+right) / 2;
		
			if(elements[mid] == target) {
				return mid;
			}
			else if(elements[mid] < target ) {
				//��[mid+1,right]�в���
				left = mid+1;
			}else {
				//��[left,mid-1]�в���
				right = mid-1;
			}
		}
		return -1;
	}
	
	//��ӡ����Ԫ��
	public void show() {
		System.out.println(Arrays.toString(elements));
	}
	
	/*
	public static void main(String[] args) {
		MyArray array=new MyArray();
		array.add(99);
		array.add(89);
		array.add(78);
		array.show();
		array.delete(1);
		array.show();
		System.out.println(array.get(1));
		array.insert(1, 68);
		array.show();
		array.set(1, 50);
		array.show();
		
	}
	*/
}
