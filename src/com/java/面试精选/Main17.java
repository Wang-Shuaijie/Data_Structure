package com.java.���Ծ�ѡ;

import java.util.Scanner;

/**
 * 
С����ϲ���������������� N ���������� i ������ p[i] ���������������뿪�ˣ����� H Сʱ�������
С�������Ծ��������������ٶ� K ����λ����/Сʱ����ÿ��Сʱ��������ѡ��һ�����������гԵ� K ������������������ K ���������Ե���ѵ�����������Ȼ����һСʱ�ڲ����ٳԸ����������  
С����ϲ�������ԣ�����Ȼ���������˻���ǰ�Ե����е�������
������������ H Сʱ�ڳԵ�������������С�ٶ� K��K Ϊ��������

��������:

��һ������Ϊ�������飬�Կո�ָ���N������
�ڶ�������ΪHСʱ��

�������:
��С�ٶ�K

��������1:
3 6 7 11
8

�������1:
4

 * @author WangShuaiJie
 *
 */
public class Main17 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = sc.nextLine().split(" ");
		int[] nums = new int[str.length];
		int total=0;
		for (int i = 0; i < str.length; i++) {
			nums[i] = Integer.parseInt(str[i]);
			total+=nums[i];
		}
		int h=sc.nextInt();
		int k  = total / h;//�ܵ�è����������ʱ�䣬����ÿСʱ�Ե�è������
        while (costTime(nums, k) > h) {
            k++;
        }
        System.out.println(k);
		
	}

	private static int costTime(int[] nums, int k) {
		int total_h = 0;//����è�����ѵ�ʱ��
        for (int i = 0; i < nums.length; i++) {
            total_h += (nums[i] + k - 1) / k; //����ȡ����eg: k = 4,nums[i]=5,����Ҫ����Сʱ
        }
        return total_h;
	}
}
