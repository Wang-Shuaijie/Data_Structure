package com.java.base.Sort;

import java.util.Arrays;

/**
 * 堆排序--大顶堆
 * @author WangShuaiJie
 * 
 * 
 * 堆排序是一种树形选择排序方法，它的特点是：在排序的过程中，将array[0，...，n-1]看成是一颗完全二叉树的顺序存储结构，利用完全二叉树中双亲节点和孩子结点之间的内在关系，在当前无序区中选择关键字最大（最小）的元素。

1. 若array[0，...，n-1]表示一颗完全二叉树的顺序存储模式，则双亲节点指针和孩子结点指针之间的内在关系如下：

　　任意一节点指针 i：父节点：i==0 ? null : (i-1)/2

　　　　　　　　　　  左孩子：2*i + 1

　　　　　　　　　　  右孩子：2*i + 2

2. 堆的定义：n个关键字序列array[0，...，n-1]，当且仅当满足下列要求：(0 <= i <= (n-1)/2)

　　　　　　① array[i] <= array[2*i + 1] 且 array[i] <= array[2*i + 2]； 称为小根堆；

　　　　　　② array[i] >= array[2*i + 1] 且 array[i] >= array[2*i + 2]； 称为大根堆；

3. 建立大根堆：

　　n个节点的完全二叉树array[0，...，n-1]，最后一个节点n-1是第(n-1-1)/2个节点的孩子。对第(n-1-1)/2个节点为根的子树调整，使该子树称为堆。

　　对于大根堆，调整方法为：若【根节点的关键字】小于【左右子女中关键字较大者】，则交换。

　　之后向前依次对各节点（(n-2)/2 - 1）~ 0为根的子树进行调整，看该节点值是否大于其左右子节点的值，若不是，将左右子节点中较大值与之交换，交换后可能会破坏下一级堆，于是继续采用上述方法构建下一级的堆，直到以该节点为根的子树构成堆为止。

　　反复利用上述调整堆的方法建堆，直到根节点。

4.堆排序：（大根堆）

　　①将存放在array[0，...，n-1]中的n个元素建成初始堆；

　　②将堆顶元素与堆底元素进行交换，则序列的最大值即已放到正确的位置；

　　③但此时堆被破坏，将堆顶元素向下调整使其继续保持大根堆的性质，再重复第②③步，直到堆中仅剩下一个元素为止。

堆排序算法的性能分析：

　　空间复杂度:o(1)；

　　时间复杂度:建堆：o(n)，每次调整o(log n)，故最好、最坏、平均情况下：o(n*logn);

　　稳定性：不稳定
 *
 */
public class HeapSort {
	
	public static void heapSort(int[] arr) {
		//开始位置是最后一个非叶子节点，即最后一个节点的父节点
		int start=(arr.length-2)/2;
		//调整为大顶堆
		for(int i=start;i>=0;i--) {
			maxHeap(arr, arr.length, i);
		}
		//先把数组中的第0个和堆中的最后一个交换位置，再把前面的处理为大顶堆
		for(int i=arr.length-1;i>0;i--) {
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;
			maxHeap(arr, i, 0);
		}
	}
	public static void maxHeap(int[] arr, int size, int index) {
		//左节点
		int leftNode=2*index+1;
		//右节点
		int rightNode=2*index+2;
		int max=index;
		//和两个子节点分别对比，找出最大的节点
		if(leftNode<size && arr[leftNode]>arr[max]) {
			max=leftNode;
		}
		if(rightNode<size && arr[rightNode]>arr[max]) {
			max=rightNode;
		}
		//交换位置
		if(max!=index) {
			int temp=arr[index];
			arr[index]=arr[max];
			arr[max]=temp;
			//交换位置,可能会破坏之前排好的堆，所以之前排好的堆要重新排列
			maxHeap(arr, size, max);
		}
		
	}
	public static void main(String[] args) {
		int[] arr=new int[] {9,6,12,18,1,8,7,0,1,10,4,2,11};
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
