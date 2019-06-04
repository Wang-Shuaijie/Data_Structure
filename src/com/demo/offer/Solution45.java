package com.demo.offer;

import java.util.ArrayList;

public class Solution45 {
	/**
	 * ԲȦ�����ʣ�µ����֣�Լɪ�򻷣�
	 * ��֪n����(�Ա��1��2��3...n�ֱ��ʾ)Χ����һ��Բ����Χ��
	 * �ӱ��Ϊk���˿�ʼ����������m���Ǹ��˳���;
	 * ������һ�����ִ�1��ʼ����������m���Ǹ����ֳ���;
	 * ���˹����ظ���ȥ��ֱ��Բ����Χ����ȫ�����С�
	 * 
	 * ������n���ˣ���1��n������һ��ArrayList�У����ÿ�ʼ�ı��k(��Ϊ0��Ϊ��һ���ˣ���
	 * ������Ҫ��������1�����õ���Ҫ�����˵�������Ҫע��Ҫ���е����ǲ������һ���ˣ�Ҫ���⴦����ArrayListΪ�գ������
	 */
	
	public static int yesefu(int n, int m) {
		 if (m == 0 || n == 0) {
	            return -1;
	        }
	        ArrayList<Integer> data = new ArrayList<Integer>();
	        for (int i = 0; i < n; i++) {
	            data.add(i);
	        }
	        int index = -1;
	        while (data.size() > 1) {
//	          System.out.println(data);
	            index = (index + m) % data.size();
//	          System.out.println(data.get(index));
	            data.remove(index);
	            index--;
	        }
	        return data.get(0);
	}
	
	int LastRemaining_Solution(int n, int m) {
		 if(n==0||m==0)return -1;
	        int s=0;
	        for(int i=2;i<=n;i++)
	        {
	            s=(s+m)%i;
	        }   
	       return s ;
    }
	
	//f[1]=0;
	//f[i]=(f[i-1]+m)%i;  (i>1) 
	int LastRemaining_Solution2(int n, int m)
    {
        if(n==0)
            return -1;
        if(n==1)
            return 0;
        else
            return (LastRemaining_Solution(n-1,m)+m)%n;
    }
	
	public static void main(String[] args) {
		System.out.println(yesefu(5, 3));
	}
}
