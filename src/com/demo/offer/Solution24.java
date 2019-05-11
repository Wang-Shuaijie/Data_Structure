package com.demo.offer;

public class Solution24 {
	/**
	 * 输入一个整数数组，判断该数组是不是某二元查找树的后序遍历的结果。如果是返回true，否则返回false。

例如输入5、7、6、9、11、10、8，由于这一整数序列是如下树的后序遍历结果：

         8
       / \
      6   10
    / \    / \
   5  7   9  11

因此返回true。

如果输入7、4、6、5，没有哪棵树的后序遍历的结果是这个序列，因此返回false。


算法思想：后序遍历，数组的最后一个节点是二叉树的根节点，数组的前半部分都小于根节点(因为是二元查找树)，后半部分都大于根节点。

思路：先找到右子树的开始位置，然后分别进行左右子树递归处理。
	 */
	public boolean verifySequenceofBST(int[] sequence) {
		if(sequence==null || sequence.length==0) return false;
		return helper(sequence, 0, sequence.length-1);
	}
	
	private boolean helper(int[] sequence, int left, int right) {
		if(left>=right) {
			return true;
		}
		int i=left;
		//找到右子树
		for(;i<right-1;i++) {
			if(sequence[i]>sequence[right]) {
				break;
			}
		}
		int j=i;
		for(;j<right-1;j++) {
			if(sequence[j]<sequence[right]) {
				return false;
			}
		}
		return helper(sequence, left, i-1) && helper(sequence, i, right-1);
	}
}
