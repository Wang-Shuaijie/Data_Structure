package com.java.javaSE��ѡ50��;
/**
 * ��Ŀ��һ���h�׸߶��������£�ÿ����غ�����ԭ�߶ȵ�һ�룻 
 *  �����£������� ��n�����ʱ�������������ף���n�η�����ߣ�
 * @author WangShuaiJie
 *
 */
public class Main10 {
	public static void main(String[] args) {
		System.out.println(getHeight(10, 3));
	}
	/*
	 *  �����ľ��룺��������ܽ�õ���
	 *  ��һ����ؾ�����h,
	 *  �ڶ�����ؾ�����h+(h/2)*2,
	 *  ��������ؾ�����h+(h/2)*2+(h/2/2)*2 
	 *  ��ô��n����ؾ�����  h+(h/2)*2+(h/2/2)*2 +...+h/(2��n-1�η�)*2
	 */
	private static float getHeight(float h, float n) {
		float sum=h;
		for(int i=2;i<=n;i++) {
			h=h/2;//��i����ط����߶�
			sum+=h*2;//�ܾ�������		
		}
		return sum;
	}
}
