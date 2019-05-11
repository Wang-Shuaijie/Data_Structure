package com.demo.offer;

import java.util.ArrayList;
import java.util.List;

public class Solution41 {
	/**
	 * ������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
	 * ��������Ϊ18ʱ�����Ϊ3,4,5,6/5,6,7
	 */
	public List<List<Integer>> findContinuousSequence(int sum){
		//ʵ���Ͼ��������ΪS,����Ϊ1�ĵȲ�����
		//��������ָ��(һǰһ��)���ֱ������Ѱ�Һ�Ϊs������
		List<List<Integer>> res=new ArrayList<>();
		if(sum<=2) return res;
		int start=1;
		int end=2;
		while(start!=(sum+1)/2) {
			int currentSum=getSum(start, end);
			if(currentSum==sum) {
				List<Integer> list=new ArrayList<>();
				for(int i=start;i<=end;i++) {
					list.add(i);
				}
				res.add(list);
				start++;
				end++;
			}else if(currentSum<sum) {
				end++;
			}else {
				start++;
			}
		}
		return res;
	}
	
	private int getSum(int start, int end) {
		int sum=0;
		for(int i=start;i<=end;i++) {
			sum=sum+i;
		}
		return sum;
	}
}
