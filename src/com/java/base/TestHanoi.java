package com.java.base;
/**
 * ��ŵ������
 * @author WangShuaiJie
 *
 */
public class TestHanoi {
	/**
	 * 
	 * @param n���м�������
	 * @param from��ʼ����
	 * @param in�м������
	 * @param toĿ������
	 */
	public static void hanoi(int n ,char from, char in, char to) {
		//ֻ��һ��
		if(n == 1) {
			System.out.println("��һ�����Ӵ�"+from+"�Ƶ�"+to);
		//�����ж��ٸ����ӣ�����Ϊֻ�������������������Ӻ������������
		}else {
			//�ƶ������������ӵ��м�λ��
			hanoi(n-1, from, to, in);
			//�ƶ����������
			System.out.println("��"+n+"�����Ӵ�"+from+"�Ƶ�"+to);
			//�������������Ӵ��м�λ���Ƶ�Ŀ��λ��
			hanoi(n-1, in, from, to);
		}
	}
	
	
	
	public static void main(String[] args) {
		hanoi(3, 'A', 'B', 'C');
	}
}
