package com.java.javaSE����50��;
/**
 * ��Ŀ���ж�101-200֮���ж��ٸ��������������������
 * ������ֻ�ܱ�0����������������3,5,7,11,131... 
 * @author WangShuaiJie
 *
 */
public class Main02 {
	//�ж������ķ�������һ�����ֱ�ȥ��2���������1
	public static void main(String[] args) {
		for(int i=101;i<=200;i++) {
			if(isRightNum(i)) System.out.println(i);
		}
	}
	
	public static boolean isRightNum(int n) {
		if(n<=1) return false;
		for(int i=2;i<n;i++) {
			if(n%i==0) return false;
		}
		return true;
	}
}
