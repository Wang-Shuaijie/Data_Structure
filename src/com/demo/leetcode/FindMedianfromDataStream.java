package com.demo.leetcode;

import java.util.Arrays;

public class FindMedianfromDataStream {
	/**
	 * ��λ���������б��м����������б�����ż������λ�������м���������ƽ��ֵ��

���磬

[2,3,4] ����λ���� 3

[2,3] ����λ���� (2 + 3) / 2 = 2.5

���һ��֧���������ֲ��������ݽṹ��

    void addNum(int num) - �������������һ�����������ݽṹ�С�
    double findMedian() - ����Ŀǰ����Ԫ�ص���λ����

	 */
	
	
	//�����������е����ݲ���������ģ�������������Ӧ�����������������
	//���������int[]�������������Ļ���ÿ����һ�������ݶ�Ҫ���������򣬺ܲ���Ч��
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
        //��������Ҫ������1
    	Arrays.sort(nums);
    	double num1=(double)nums[(nums.length)/2];
        double num2=(double)nums[(nums.length-1)/2];
        double res=(num1+num2)/2;
        return res;
    }
    
    
    
    
    
    /*
     ����int[]����
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
