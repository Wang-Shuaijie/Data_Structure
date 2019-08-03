package com.demo.test;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 分段函数
 * 分段函数求值
Time Limit: 1000 ms Memory Limit: 65536 KiB
Submit Statistic
Problem Description

有如下分段函数
F(x) = x^2 + 1 当x> 0时；
F(x) = -x 当x<0时；
F(x) = 100.0 当x=0时；
编程根据输入的不同x（x为实数），输出其对应的函数值
Input

多组输入，每组一个实数x。处理到文件结束。
Output

对于每组输入x，输出其对应的F(x),每组一行，结果保留1位小数。
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
