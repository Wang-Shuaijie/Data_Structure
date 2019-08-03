package com.demo.test;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * �ֶκ���
 * �ֶκ�����ֵ
Time Limit: 1000 ms Memory Limit: 65536 KiB
Submit Statistic
Problem Description

�����·ֶκ���
F(x) = x^2 + 1 ��x> 0ʱ��
F(x) = -x ��x<0ʱ��
F(x) = 100.0 ��x=0ʱ��
��̸�������Ĳ�ͬx��xΪʵ������������Ӧ�ĺ���ֵ
Input

�������룬ÿ��һ��ʵ��x�������ļ�������
Output

����ÿ������x��������Ӧ��F(x),ÿ��һ�У��������1λС����
Sample Input

8.00
-5.0
Sample Output

65.0
5.0 
 * @author WangShuaiJie
 *
 */
public class Main06 {
	public static void main(String[] args) {
		Scanner str = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.0");
        double x, y;
        while(str.hasNext())
        {
            x = str.nextDouble();
            if(x > 0)
            {
                y = x * x + 1;
            }
            else if(x < 0)
            {
                y = - x;
            }
            else
                y = 100.0;
            System.out.println(df.format(y));
        }
        str.close();
	}
}
