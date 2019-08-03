package com.java.leetcode.贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

题目描述：一个学生用两个分量 (h, k) 描述，h 表示身高，k 表示排在前面的有 k 个学生的身高比他高或者和他一样高。
 * @author WangShuaiJie
 *
 */
public class QueueReconstructionbyHeight {
	public int[][] reconstructQueue(int[][] people) {
		if (people == null || people.length == 0 || people[0].length == 0) {
	        return new int[0][0];
	    }
		//身高 h 降序、个数 k 值升序，然后将某个学生插入队列的第 k 个位置中
		Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
	    List<int[]> queue = new ArrayList<>();
	    for (int[] p : people) {
	        queue.add(p[1], p);
	    }
	    return queue.toArray(new int[queue.size()][]);
	}
}
