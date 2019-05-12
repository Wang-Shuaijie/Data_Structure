package com.demo.leetcode;

import java.util.Arrays;

public class FindMedianfromDataStream {
	/**
	 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

    void addNum(int num) - 从数据流中添加一个整数到数据结构中。
    double findMedian() - 返回目前所有元素的中位数。

	 */
	
	
	//由于数据流中的数据并不是有序的，所以我们首先应该想个方法让其有序。
	//如果我们用int[]来保存数据流的话，每进来一个新数据都要给数组排序，很不高效。
	private int[] nums;
	public FindMedianfromDataStream() {
		nums=new int[0];
	}
	
	public void addNum(int num) {
        int[] newNums=new int[nums.length+1];
        for(int i=0;i<nums.length;i++) {
        	newNums[i]=nums[i];
        }
        newNums[nums.length]=num;
        nums=newNums;
    }
    
    public double findMedian() {
        //数组无序，要先排序1
    	Arrays.sort(nums);
    	double num1=(double)nums[(nums.length)/2];
        double num2=(double)nums[(nums.length-1)/2];
        double res=(num1+num2)/2;
        return res;
    }
    
    
    
    
    
    /*
     不用int[]数组
    private int count;
    private int sum;
    private java.util.SortedSet<Integer> set;
    
    public MedianFinder() {
        set = new TreeSet();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        set.add(num);
    }

    // Returns the median of current data stream
    public double findMedian() {
        Integer[] list = set.toArray(new Integer[0]);
        int size = set.size();
        double res = 0.0;
        if(size % 2 == 0) {
            res = (double)(list[size/2] + list[size/2 - 1]) / 2.0;
        }
        else {
            res = (double)list[size/2];
        }
        return res;
    }
     */
	
}
