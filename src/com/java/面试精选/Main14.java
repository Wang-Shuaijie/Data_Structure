package com.java.���Ծ�ѡ;

import java.util.Scanner;

/**
 *  һ��������ĸ A-Z ����Ϣͨ�����·�ʽ�����˱��룺

'A' -> 1
'B' -> 2
...
'Z' -> 26

����һ��ֻ�������ֵķǿ��ַ������������뷽��������

ʾ��1
����
12

���
2

˵��
12���Խ���ɡ�AB������A��B"������


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
