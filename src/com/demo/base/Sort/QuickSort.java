package com.demo.base.Sort;

import java.util.Arrays;
/**
 * 快速排序
 * @author WangShuaiJie
 *
 */
public class QuickSort {
	public static void quickSort(int[] arr,int start,int end) {
		//解决无限递归
		if(start<end) {
			//数组第0个元素作为基准值
			int stard= arr[start];
			//记录需要排序的下标
			int i=start;
			int j=end;
			//循环找比标准数大的数字和比标准数小的数字
			while(i<j) {
				//右边数字比标准数大，无需移位
				while(i<j && stard<=arr[j]) {
					j--;
				}
				//使用右边比标准数小的数字替换基准位
				arr[i]=arr[j];
				
				//左边数字比标准数小，无需移位
				while(i<j && arr[i]<=stard) {
					i++;
				}
				//使用左边比标准数大的数字替换空位
				arr[j]=arr[i];
			}
			//标准数最后放
			arr[i]=stard;
			//处理所有比标准数小的数字
			quickSort(arr, start, i);
			//处理所有比标准数大的数字
			quickSort(arr, i+1, end);
		}
		
	}
	
	/*分别从初始序列“5,7,3,9,8,4,0,6,7,2”两端开始“探测”。
	 * 先从右往左找一个小于5的数，放在基准数位，再从左往右找一个大于5的数，放在缺位	。
	 * 这里可以用两个变量i和j，分别指向序列最左边和最右边。
	 * 刚开始的时候让i指向序列的最左边（即i=0），指向数字5。
	 * 让j指向序列的最右边（即j=9），指向数字2。
	 * 每次交换结束后j先行动
	 * 5,7,3,9,8,4,0,6,7,2 初始态 以5为基准值 i=0 j=9
	 * 2,0,3,4,5,8,9,6,7,7
	 * 
	 */
	public static void main(String[] args) {
		int[] arr=new int[] {5,7,3,9,8,4,0,6,7,2};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}
