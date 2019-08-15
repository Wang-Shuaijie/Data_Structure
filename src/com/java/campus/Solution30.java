package com.java.campus;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * СQ�Ĺ�˾����ӵ�m������, ��i��������Ҫxi��ʱ��ȥ���, �Ѷȵȼ�Ϊyi�� СQӵ��n̨����, ÿ̨���������ʱ��zi, �����ȼ�wi��
 * ����һ������,��ֻ�ܽ���һ̨���������, ������Ÿ����Ļ����������ʱ��С��������Ҫ��ʱ��, �������,������������񽫻��200 * xi + 3
 * * yi���档
 * 
 * ����һ̨����,��һ��ֻ�����һ������, ������Ļ����ȼ�С�ڰ��Ÿ����������Ѷȵȼ�, ������ɡ�
 * 
 * СQ���ڽ��쾡���ܵ�ȥ�������, ����ɵ����������������ж��ְ��ŷ���,СQ�����ҵ����������Ǹ�������СQ��Ҫ��������������һ�¡� ��������:
 * 
 * �������N + M + 1��, ����ĵ�һ��Ϊ����������n��m(1 <= n, m <= 100000), ��ʾ�����������������������
 * ������n��,ÿ����������zi��wi(0 < zi < 1000, 0 <= wi <= 100), ��ʾÿ̨�����������ʱ��ͻ����ȼ���
 * ��������m��,ÿ����������xi��yi(0 < xi < 1000, 0 <= yi<= 100), ��ʾÿ��������Ҫ�����ʱ���������Ѷȵȼ���
 * 
 * �������: �����������, �ֱ��ʾ�������ɵ����������ͻ�ȡ�����档
 * 
 * ��������1: 1 2 100 3 100 2 100 1
 * 
 * �������1: 1 20006
 * 
 * @author WangShuaiJie
 *
 */
public class Solution30 {
	public static void main(String[] args) {
		int[] cnt = new int[105];
		Scanner sr = new Scanner(System.in);
		int n = sr.nextInt();
		int m = sr.nextInt();
		node[] e = new node[n];
		node[] f = new node[m];
		for (int i = 0; i < n; i++) {
			e[i] = new node(sr.nextInt(), sr.nextInt());
		}
		for (int i = 0; i < m; i++) {
			f[i] = new node(sr.nextInt(), sr.nextInt());
		}
		Arrays.sort(e, new Comparator<node>() {
			public int compare(node a, node b) {
				if (a.t == b.t)
					return b.w - a.w;
				return b.t - a.t;
			}
		});
		Arrays.sort(f, new Comparator<node>() {
			public int compare(node a, node b) {
				if (a.t == b.t)
					return b.w - a.w;
				return b.t - a.t;
			}
		});
		int num = 0;
		long ans = 0;
		int i, j, k;
		for (i = 0, j = 0; i < m; i++) {
			while (j < n && e[j].t >= f[i].t) {
				cnt[e[j].w]++;
				j++;
			}
			for (k = f[i].w; k <= 100; k++) {
				if (cnt[k] != 0) {
					num++;
					cnt[k]--;
					ans = ans + 200 * f[i].t + 3 * f[i].w;
					break;
				}
			}
		}
		System.out.println(num + " " + ans);

	}

	boolean cmp(node a, node b) {
		if (a.t == b.t)
			return a.w > b.w;
		return a.t > b.t;
	}

}

class node {
	int t;
	int w;

	node(int t, int w) {
		this.t = t;
		this.w = w;
	}
}
