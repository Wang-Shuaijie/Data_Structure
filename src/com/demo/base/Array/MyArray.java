package com.demo.base.Array;

import java.util.Arrays;


/**
 * 面向对象数组
 * @author WangShuaiJie
 *
 */
public class MyArray {
	//用于存储数据的数组
	private int[] elements;
	
	public MyArray() {
		//初始化
		elements=new int[0];
	}
	
	//获取数组长度的方法
	public int size() {
		return elements.length;
	}
	
	//向数组末尾添加元素
	public void add(int element) {
		//创建一个新数组
		int[] newArr = new int[elements.length+1];
		//把数组元素复制到新数组
		for(int i=0;i<elements.length;i++) {
			newArr[i]=elements[i];
		}
		newArr[elements.length]=element;
		//替换原有数组
		elements=newArr;
	}
	
	//删除数组中的元素
	public void delete(int index) {
		if(index < 0 || index > elements.length) {
			throw new RuntimeException( "下标越界");
		}
		//创建一个新数组
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
	
	//删除数组中的元素
	public void deleteElemnet(int val) {
		int res=0;
		for(int i=0;i<elements.length;i++) {
			if(elements[i]==val) {
				elements[res]=elements[i];
				res++;
			}					
		}
	}
	
	//获取某个元素
	public int get(int index) {
		if(index < 0 || index > elements.length) {
			throw new RuntimeException("下标越界");
		}
		return elements[index];
	}
	
	//插入一个元素到指定位置
	public void insert(int index,int element) {
		if(index < 0 || index > elements.length) {
			throw new RuntimeException("下标越界");
		}
		//创建一个新数组
		int[] newArr =new int[elements.length+1];
		for(int i=0;i<elements.length;i++) {
			//目标元素之前
			if(i<index) {
				newArr[i] = elements[i];
			//目标元素之后
			}else {
				newArr[i+1] = elements[i];
			}
		}
		newArr[index]=element;
		
		elements=newArr;
	}
	
	//替换指定位置元素
	public void set(int index,int element) {
		if(index < 0 || index > elements.length) {
			throw new RuntimeException("下标越界");
		}
		elements[index]=element;
	}
	
	//线性查找
	public int search(int target) {
		//遍历数组
		for(int i=0;i<elements.length;i++) {
			if(elements[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	//二分法查找(有序数组)
	public int binarySearch(int target) {
		int left=0;
		int right=elements.length-1;
		//遍历
		while(left <= right) {
			int mid = (left+right) / 2;
		
			if(elements[mid] == target) {
				return mid;
			}
			else if(elements[mid] < target ) {
				//在[mid+1,right]中查找
				left = mid+1;
			}else {
				//在[left,mid-1]中查找
				right = mid-1;
			}
		}
		return -1;
	}
	
	//打印所有元素
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
