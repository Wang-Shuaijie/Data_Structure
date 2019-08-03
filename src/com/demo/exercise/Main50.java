package com.demo.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ��Ŀ�������ѧ����ÿ��ѧ����3�ſεĳɼ����Ӽ��������������ݣ�����ѧ���ţ����������ſγɼ�����
 * �����ƽ���ɼ�����ԭ�е����ݺͼ������ƽ����������ڴ����ļ���stud���С�
 * 
 * @author WangShuaiJie
 *
 */
public class Main50 {
	// ����ѧ��ģ��
	String[] number = new String[5];
	String[] name = new String[5];
	float[][] grade = new float[5][3];
	float[] avg = new float[5];

	public static void main(String[] args) {

	}

	// ����ѧ�������ɼ�
	void input() throws IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		boolean isRecord = true;// ¼��״̬��ʶ
		while (isRecord) {
			try {
				for (int i = 0; i < 5; i++) {
					System.out.print("������ѧ�ţ�");
					number[i] = buff.readLine();
					System.out.print("������������");
					name[i] = buff.readLine();
					for (int j = 0; j < 3; j++) {
						System.out.print("�������" + (j + 1) + "�ſγɼ���");
						grade[i][j] = Integer.parseInt(buff.readLine());
					}
					System.out.println();
					avg[i] = grade[i][0] + grade[i][1] + grade[i][2];
				}
				isRecord = false;
			} catch (Exception e) {
				System.out.println("������һ�����֣�");
			}
		}
	}

	// ����ļ�
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
