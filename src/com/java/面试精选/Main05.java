package com.java.���Ծ�ѡ;
/**
 * ���� n �� b , �ҳ� 1 �� n �б� b �����ĸ���.
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
