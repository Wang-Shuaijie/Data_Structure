package com.java.campus;

import java.util.Scanner;

/**
 * 11
某天猿辅导 HR 组织大家去漂流，早上，参加团建的同学都到齐了，并且按到达公司的先后顺序排好队了。 由于员工太多，一个大巴车坐不下，需要分多个车，车是足够的，但所有人需要按一定顺序上车，按如下规则安排上车的顺序：
假设大巴车容量为 m，从队首开始，每 m 个人分成一个小组，每个小组坐一辆车。同时只有一个车打开车门供员工上车。 小组之间按从队尾到队首顺序依次上车，同一小组内先到的同学先上，求所有人上车的顺序。

例如： 员工数 8， 车容量 3， 员工到达顺序为 1 2 3 4 5 6 7 8， 3个人一个小组，分三个小组， 小组一： 1， 2， 3， 小组二： 4， 5， 6，小组三： 7，8。 小组上车顺序为： 小组三，小组二，小组一 。 所有员工上车顺序为 7 8 4 5 6 1 2 3 
 * @author WangShuaiJie
 *
 */
public class Solution11 {
	/*
	 * 思路就是只利用数组来完成
     * 比如 员工到达顺序为 1 2 3 4 5 6 7 8
     * 车容量为3个人
     * 所以是3组
     * 现在数组存的就是 int[] ps={1 2 3 4 5 6 7 8};
     * 分为三组的情况下：
     * 第一组123第二组456第三组78
     * 所以只需将每一组中的设置两个标识位begin和end，
     * 然后将begin和end值互换即可
     * 比如第一组123，开始时begin=0，end=2，然后将ps[0]和ps[2]互换
     * 然后再将begin++，end--。
     * 互换的次数就有每一组的数量来决定=每一组的数量/2
     * 最终每一组互换之后就会得到3 2 1 6 5 4 8 7
     * 只需再倒序输出即可
     */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//员工数量
		int pNum=sc.nextInt();
		//车的容纳量
		int cNum=sc.nextInt();
		int[] ps=new int[pNum];
		for(int i=0;i<pNum;i++) {
			ps[i]=sc.nextInt();
		}
		//大巴车数量
		int a=(pNum%cNum)==0?pNum/cNum:pNum/cNum+1;
		//flag存储每一组要进行交换的次数=车的容纳量/2
		int flag,temp;
		flag=cNum/2;
		//开始对每一组进行交换
		for(int i=0;i<a;i++) {
			int begin=i*cNum;
			int end=0;
			//这个判断是为了计算最后一组的数量，因为最后一组的数量可能小于车的容纳量
            if((i*cNum+cNum-1)<(ps.length))
             end=i*cNum+cNum-1;
            else
             end=ps.length-1;
            //开始对每一组中的值进行交换
            for(int j=0;j<flag;j++){
                temp=ps[begin];
                ps[begin]=ps[end];
                ps[end]=temp;
                begin++;
                end--;
            }
		}
        //倒序输出
        int max=ps.length-1;
        for(int i=max;i>=0;i--) {
            System.out.print(ps[i]+" ");
        }
	}
}
