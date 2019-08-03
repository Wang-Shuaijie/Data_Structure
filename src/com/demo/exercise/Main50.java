package com.demo.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 题目：有五个学生，每个学生有3门课的成绩，从键盘输入以上数据（包括学生号，姓名，三门课成绩），
 * 计算出平均成绩，将原有的数据和计算出的平均分数存放在磁盘文件”stud”中。
 * 
 * @author WangShuaiJie
 *
 */
public class Main50 {
	// 定义学生模型
	String[] number = new String[5];
	String[] name = new String[5];
	float[][] grade = new float[5][3];
	float[] avg = new float[5];

	public static void main(String[] args) {

	}

	// 输入学号姓名成绩
	void input() throws IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		boolean isRecord = true;// 录入状态标识
		while (isRecord) {
			try {
				for (int i = 0; i < 5; i++) {
					System.out.print("请输入学号：");
					number[i] = buff.readLine();
					System.out.print("请输入姓名：");
					name[i] = buff.readLine();
					for (int j = 0; j < 3; j++) {
						System.out.print("请输入第" + (j + 1) + "门课成绩：");
						grade[i][j] = Integer.parseInt(buff.readLine());
					}
					System.out.println();
					avg[i] = grade[i][0] + grade[i][1] + grade[i][2];
				}
				isRecord = false;
			} catch (Exception e) {
				System.out.println("请输入一个数字！");
			}
		}
	}

	// 输出文件
	void output() throws IOException {
		FileWriter fw = new FileWriter("E://java//stud.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("No.  " + "Name  " + "grade1  " + "grade2  " + "grade3  " + "average");
		bw.newLine();
		for (int i = 0; i < 5; i++) {
			bw.write(number[i]);
			bw.write("  " + name[i]);
			for (int j = 0; j < 3; j++) {
				bw.write("  " + grade[i][j]);
			}
			bw.write("  " + (avg[i] / 5));
			bw.newLine();
		}
		bw.close();
	}
}
