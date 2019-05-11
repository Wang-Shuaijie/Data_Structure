package com.demo.offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Solution30 {
	/**
	 * ����n���������ҳ�������С��K������
��������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
˼·���Ƚ�ǰK�����������飬���ж�������֮�����������С������е���
	 */
    public static ArrayList<Integer> getLeastNumbers(int nums[], int k){
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	int lens = nums.length;
    	if(nums == null || lens == 0 || k > lens || k <= 0){
    		return list;
    	}
    	int start = 0;
    	int end = lens - 1;
    	int index = partition(nums, start, end);
    	while(index != k-1){
    		if(index > k-1){
    			end = index - 1;
    			index = partition(nums, start, end);
    		}else{
    			start = index + 1;
    			index = partition(nums, start, end);
    		}
    	}
    	for (int i = 0; i < k; i++) {
    		list.add(nums[i]);
    	}
    	return list;
    }

    private static int partition(int[] nums, int start, int end) { //����
    	int privotKey = nums[start];
    	while(start < end){
    		while(start < end && privotKey <= nums[end]){
    			--end;
    		}
    		swap(nums, start, end);//����λ�ã�ʹ����privotkey��ֵλ�������ұ�
    			
    		while(start < end && privotKey >= nums[start]){
    			++start;
    		}
    		swap(nums, start, end);//����λ�ã�ʹС��privotkey��ֵλ���������
    	}
    	return start;
    }

    private static void swap(int[] nums, int start, int end) { //��������Ԫ��λ��
    	int temp = nums[start];
    	nums[start] = nums[end];
    	nums[end] = temp;
    }
	
    
    public static ArrayList<Integer> getLeastNumbers2(int []nums, int k){
    	//TreeSet��ʵ���˺�����Ĺ��ܣ����ĵײ���ͨ��TreeMapʵ�ֵģ�TreeSet�е����ݻᰴ�ղ��������Զ�������������ֻ��Ҫ�����ݷ���TreeSet��
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	int lens = nums.length;
    	if(nums == null || lens == 0 || k > lens || k <= 0){
    		return list;
    	}
    	TreeSet<Integer> kSet = new TreeSet<Integer>();
    	for (int i = 0; i < lens; i++) {
    		if(kSet.size() < k){
    			kSet.add(nums[i]);
    		}else if(nums[i] < kSet.last()){
    			kSet.remove(kSet.last());
    			kSet.add(nums[i]);
    		}
    	}
    	Iterator<Integer> iterator = kSet.iterator();
    	while(iterator.hasNext()){
    		list.add(iterator.next());
    	}
    	return list;
    }
	
	public static void main(String[] args) {
		int[] nums=new int[] {4,5,1,6,2,7,3,8};
		int k=4;
		System.out.println(getLeastNumbers(nums, k));
	}
}
