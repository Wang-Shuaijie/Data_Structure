package com.demo.leetcode.贪心;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * Input: [ [1,2], [1,2], [1,2] ]

Output: 2

Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.

Input: [ [1,2], [2,3] ]

Output: 0

Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

题目描述：计算让一组区间不重叠所需要移除的区间个数。
 * @author WangShuaiJie
 *
 */
public class NonoverlappingIntervals {
	public int eraseOverlapIntervals(int[][] intervals) {
		if(intervals.length==0) return 0;
		Arrays.sort(intervals, Comparator.comparing(o->o[1]));
		int cnt=1;
		int end=intervals[0][1];
		//开始要查找不重叠区间，判断方法是看如果前一个区间的 end 大于后一个区间的 start，那么一定是重复区间
		for(int i=1;i<intervals.length;i++) {
			if(intervals[i][0]<end) {
				continue;
			}
			end=intervals[i][1];
			cnt++;
		}
		return intervals.length-cnt;
	}
}
