package com.demo.exercise;
/**
 * ��Ŀ��һ��������������100����һ����ȫƽ�������ټ���168����һ����ȫƽ���������ʸ����Ƕ��٣�
 * @author WangShuaiJie
 *
 */
public class Main13 {
	public static void main(String[] args) {
		/*for(int i=0; i<10000; i++) {
			int num1=(int)Math.sqrt(i+100);
			int num2=(int)Math.sqrt(i+168);
			if(num1*num1==(i+100) && num2*num2==(i+168)) {
				System.out.println(i);
			}
		}*/
		int n=0;
		for (int i = 0; i <= 100000; i++) //��ȷ��һ����100000�ڵĴ�ŷ�Χ
		{
			if (isCompSqrt(i + 100) && isCompSqrt(i + 168)) 
			{
				n = i;
				break;
			}
		}
		System.out.print("���������:" + n);
		
	}
	
	public static boolean isCompSqrt(int p) {
		boolean flag = false;
		double fsqrt = Math.sqrt(p); // �Ƚ�����ƽ��
		int q = (int) fsqrt; // ת������������qΪ��ƽ����ת��Ϊ�����Ľ����
 
		if (p == Math.pow(q, 2)) // pow(x,y) ���Ǽ��� x �� y ���ݡ��ѿ�ƽ�����������ƽ�����������Ϳ�ƽ��֮ǰ�����ǲ������ ��
		{
			flag = true;
		}
		return flag;
	}
}
