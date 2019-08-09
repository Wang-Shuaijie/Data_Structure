package com.java.javaSE经典50题;

import java.util.Scanner;

/**
 * 题目：输入三个整数x,y,z，请把这三个数由小到大输出。
 * 程序分析：我们想办法把最小的数放到x上，先将x与y进行比较，如果x>y则将x与y的值进行交换，然后再用x与z进行比较，如果x>z则将x与z的值进行交换，这样能使x最小。
 * 最后两个数也使z>y就可以了
 * 
 * @author WangShuaiJie
 *
 */
public class Main15 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();// 获取整数
		int num2 = scanner.nextInt();
		int num3 = scanner.nextInt();
		int temp = 0;// 最为一个交换数
		if (num1 > num2) {// 保证num2>num1
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		if (num1 > num3) {// 保证num3>num1
			temp = num1;
			num1 = num3;
			num3 = temp;
		}
		if (num2 > num3) {// 保证num3>num2
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		System.out.println("这三个数从小到大排列：" + num1 + "  " + num2 + "  " + num3);
		scanner.close();
	}
}
