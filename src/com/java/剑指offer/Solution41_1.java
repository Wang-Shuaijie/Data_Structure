package com.java.��ָoffer;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution41_1 {
	/**
	 * ����һ����������������һ������S���������в������������ǵ����ǵĺ�������S������ж�����ֵĺ͵���S������������ĳ˻���С��
	 *�����ܶ࣬����hash�������ƽ⣬����д��һ�֣���������ָ�룬�ֱ��ǰ��ͺ�����б��������ԽԶ�˻�ԽС�����������ȳ��ֵ��������˻���С
	 */
	public int[] findNumberWithSum(int[] nums, int target) {
		Arrays.sort(nums);
		int[] res=new int[] {-1,-1};
		if(nums==null || nums.length==0) return res;
		int start=0;
		int end=nums.length-1;
		while(start<=end) {
			int sum=nums[start]+nums[end];
			if(sum==target) {
				res[0]=nums[start];
				res[1]=nums[end];
			}else if(sum>target) {
				end--;
			}else {
				start++;
			}
		}
		return res;
	}
	
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (array == null || array.length < 2) {
            return list;
        }
        int i=0,j=array.length-1;
        while(i<j){
            if(array[i]+array[j]==sum){
            	list.add(array[i]);
            	list.add(array[j]);
                return list;
           }else if(array[i]+array[j]>sum){
                j--;
            }else{
                i++;
            }
             
        }
        return list;
    }
}
