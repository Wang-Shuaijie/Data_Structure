package com.java.javaSE����50��;

/**
 * ��Ŀ��ĳ����˾���ù��õ绰�������ݣ���������λ�������� �ڴ��ݹ������Ǽ��ܵģ����ܹ������£�ÿλ���ֶ�����5,Ȼ���úͳ���10��������������֣�
 * �ٽ���һλ�͵���λ�������ڶ�λ�͵���λ����
 * 
 * @author WangShuaiJie
 *
 */
public class Main48 {
	private static void encryption(int n) {
		int[] nums = new int[4];
		for (int i = nums.length - 1; i >= 0; i--) {
			nums[i] = (n % 10 + 5) % 10;
			n = n / 10;
		}
		// ��Ҫ���滻,����1��4λ

		int temp = 0;// ������
		temp = nums[0];
		nums[0] = nums[3];
		nums[3] = temp;
		// ����2��3λ
		temp = nums[1];
		nums[1] = nums[2];
		nums[2] = temp;
		System.out.println("���ܺ�Ľ����" + nums[0] + nums[1] + nums[2] + nums[3]);
	}
}
