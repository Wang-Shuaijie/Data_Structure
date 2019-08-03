package com.java.leetcode.̰��;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

��Ŀ������һ��ѧ������������ (h, k) ������h ��ʾ��ߣ�k ��ʾ����ǰ����� k ��ѧ������߱����߻��ߺ���һ���ߡ�
 * @author WangShuaiJie
 *
 */
public class QueueReconstructionbyHeight {
	public int[][] reconstructQueue(int[][] people) {
		if (people == null || people.length == 0 || people[0].length == 0) {
	        return new int[0][0];
	    }
		//��� h ���򡢸��� k ֵ����Ȼ��ĳ��ѧ��������еĵ� k ��λ����
		Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
	    List<int[]> queue = new ArrayList<>();
	    for (int[] p : people) {
	        queue.add(p[1], p);
	    }
	    return queue.toArray(new int[queue.size()][]);
	}
}
