package com.demo.test;

import java.util.HashMap;
import java.util.Scanner;

/*
 * 输入一行字符串，输出其字符组成回文字符串的最小个数，
 * 例如输入“abbaaba”可以组成回文“abababa”输出个数1，
 * 例如输入“abc”可以组成回文“a”“b”“c”，输出个数3
 *
 */
public class Main02 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();// 输入字符串
        char[] sInput = s.toCharArray();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int n = sInput.length;
        String temp;
        for (int i = 0; i < n; i++) {
            temp = String.valueOf(sInput[i]);
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else
                map.put(temp, 1);
        }
        int res = 0;//存储map中奇数个数

        for (String key : map.keySet()) {
            if (map.get(key) % 2 != 0)
                res = res + 1;
        }

        if (res == 0)
            System.out.println(1);
        else
            System.out.println(res);

    }
}
