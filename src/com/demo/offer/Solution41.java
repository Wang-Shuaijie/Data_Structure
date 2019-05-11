package com.demo.offer;

import java.util.ArrayList;
import java.util.List;

public class Solution41 {
	/**
	 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
	 * 例：输入为18时，输出为3,4,5,6/5,6,7
	 */
	public List<List<Integer>> findContinuousSequence(int sum){
		//实际上就是求出和为S,公差为1的等差数列
		//定义两个指针(一前一后)，分别递增，寻找和为s的序列
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
