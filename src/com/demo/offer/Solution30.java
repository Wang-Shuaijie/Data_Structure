package com.demo.offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class Solution30 {
	/**
	 * 输入n个整数，找出其中最小的K个数。
例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
思路：先将前K个数放入数组，进行堆排序，若之后的数比它还小，则进行调整
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

    private static int partition(int[] nums, int start, int end) { //快排
    	int privotKey = nums[start];
    	while(start < end){
    		while(start < end && privotKey <= nums[end]){
    			--end;
    		}
    		swap(nums, start, end);//交换位置，使大于privotkey的值位于数组右边
    			
    		while(start < end && privotKey >= nums[start]){
    			++start;
    		}
    		swap(nums, start, end);//交换位置，使小于privotkey的值位于数组左边
    	}
    	return start;
    }

    private static void swap(int[] nums, int start, int end) { //交换数组元素位置
    	int temp = nums[start];
    	nums[start] = nums[end];
    	nums[end] = temp;
    }
	
    
    public static ArrayList<Integer> getLeastNumbers2(int []nums, int k){
    	//TreeSet类实现了红黑树的功能，它的底层是通过TreeMap实现的，TreeSet中的数据会按照插入数据自动升序排序。我们只需要将数据放入TreeSet中
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
