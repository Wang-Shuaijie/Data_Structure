package com.java.面试精选;

import java.util.Scanner;

/**
 *  一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26

给定一个只包含数字的非空字符串，请计算解码方法的总数

示例1
输入
12

输出
2

说明
12可以解码成“AB”，“A，B"这两种


 * @author WangShuaiJie
 *
 */
public class Main14 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int n = str.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i=2;i<=n;i++){
            String sub = str.substring(i-2,i);
            int a = Integer.parseInt(sub);
            if (a >= 10 && a <= 26)
                dp[i] = dp[i-1]+dp[i-2];
            else
                dp[i] = dp[i-1];
        }
        System.out.println(dp[n]);
    }
}
