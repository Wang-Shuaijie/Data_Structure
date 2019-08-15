package com.java.���Ծ�ѡ;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ��˾��֯�Ž������ĳƯ��ʥ��Ư����������������� Ա���������ز�һ���� i ���˵�����Ϊ people[i]��ÿ��Ư�������Գ��ص��������Ϊ
 * limit�� ÿ�Ҵ�����ͬʱ�����ˣ�����������Щ�˵�����֮�����Ϊ limit��
 * Ϊ��ʡ��֧���鷳��æ������ص�ÿһ�����������С��ֻ��(��֤ÿ���˶��ܱ�����)�� ��������: ��һ���������Ư������Ա��Ӧ���������飬
 * 
 * �ڶ�������Ư�������ص��������
 * 
 * �������: ������С��ֻ�� ʾ��1 ���� 1 2 3 ��� 1
 * 
 * @author WangShuaiJie
 *
 */
public class Main03 {
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        int maxLoad=sc.nextInt();
        System.out.println(countLeastBoat(nums, maxLoad));
    }
     
    public static int countLeastBoat(int[] nums, int maxLoad) {
        Arrays.sort(nums);
        int count=0;
        int i=0;
        int j=nums.length-1;
        while(i<j){
            if (nums[i] + nums[j] < maxLoad) {
                i++;
                j--;
            } else {
                j--;
            }
            count++;
        }
        return count + (j == i ? 1 : 0);
    }
}
