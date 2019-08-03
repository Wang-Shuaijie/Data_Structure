package com.demo.leetcode.̰��;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Input:
[[10,16], [2,8], [1,6], [7,12]]

Output:
2

��Ŀ������������һ��ˮƽ�����ϰڷţ������ص������ڴ�ֱͶ�������ᣬʹ��·���ϵ����򶼱����ơ�
�����С��Ͷ���ڴ���ʹ�������򶼱����ơ�
 * @author WangShuaiJie
 *
 */
public class MiniumNumberofArrowstoBurstBalloons {
	//Ҳ�Ǽ��㲻�ص������������������ Non-overlapping Intervals ���������ڣ�[1, 2] �� [2, 3] �ڱ����������ص�����
	public int findMinArrowShots(int[][] points) {
		if(points.length==0) return 0;
		Arrays.sort(points, Comparator.comparing(o-> o[1]));
		int cnt=1, end=points[0][1];
		for(int i=1;i<points.length;i++) {
			if(points[i][0]<=end) continue;
			cnt++;
			end=points[i][1];
		}
		return cnt;
	}
}
