package com.java.campus;

import java.util.Scanner;
import java.util.TreeSet;
/**
 * ��һ��������¼�������ж����ţ����ʱ�䣬���ʱ�䣻
����һ��ʱ��ֵA����Ҫ��������¼���ҵ����������ʱ�䷶Χ��A���ڵ������ʱ�䣬����AС�ڵ������ʱ�䣩�ڵ����м�¼�� ���β�ѯʱ�临�Ӷȿ�����O(logN)
��ע�⣺�������������
 * @author WangShuaiJie
 *
 */
public class Solution07 {
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long A=sc.nextLong();
        int[] nums=new int[n];
        long[] enter=new long[n];
        long[] out=new long[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
            enter[i]=sc.nextLong();
            out[i]=sc.nextLong();
        }
        TreeSet<Integer> res=getResult(nums,A,enter,out);
        if(res.size()==0) {
            System.out.println("null");
        }else{
            for(int i:res){
                System.out.println(i);
            }
        }
             
    }
     
    private static TreeSet<Integer> getResult(int[] nums, long A, long[] enter, long[] out){
        TreeSet<Integer> res=new TreeSet<Integer>();
        for(int i=0;i<nums.length;i++){
            if(A>=enter[i] && A<=out[i]){
                res.add(nums[i]);
            }
        }
        return res;
    }
}
