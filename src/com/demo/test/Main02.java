package com.demo.test;

import java.util.HashMap;
import java.util.Scanner;

/*
 * ����һ���ַ�����������ַ���ɻ����ַ�������С������
 * �������롰abbaaba��������ɻ��ġ�abababa���������1��
 * �������롰abc��������ɻ��ġ�a����b����c�����������3
 *
 */
public class Main02 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();// �����ַ���
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
        int res = 0;//�洢map����������

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
