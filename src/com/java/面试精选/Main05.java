package com.java.面试精选;
/**
 * 输入 n 和 b , 找出 1 到 n 中被 b 整除的个数.
 * @author WangShuaiJie
 *
 */
public class Main05 {
	private static int count(int n, int b) {
		int count=0;
		for(int i=1;i<-n;i++) {
			if(i%b==0) {
				count++;
			}
		}
		return count;
	}
}
