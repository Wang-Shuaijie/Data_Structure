package com.java.面试精选;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 公司组织团建活动，到某漂流圣地漂流，现有如下情况： 员工各自体重不一，第 i 个人的体重为 people[i]，每艘漂流船可以承载的最大重量为
 * limit。 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 为节省开支，麻烦帮忙计算出载到每一个人所需的最小船只数(保证每个人都能被船载)。 输入描述: 第一行输入参与漂流的人员对应的体重数组，
 * 
 * 第二行输入漂流船承载的最大重量
 * 
 * 输出描述: 所需最小船只数 示例1 输入 1 2 3 输出 1
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
