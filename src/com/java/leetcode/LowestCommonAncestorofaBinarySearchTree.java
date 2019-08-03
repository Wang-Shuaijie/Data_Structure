package com.java.leetcode;

public class LowestCommonAncestorofaBinarySearchTree {
	/**
	 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
       6
      / \
     2   8 
    / \ / \
   0  4 7  9
     / \
    3   5
 

示例 1:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6 
解释: 节点 2 和节点 8 的最近公共祖先是 6。

	 */
	
	//二叉搜索树的特点左<根<右
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
         * 所以根节点的值一直都是中间值，大于左子树的所有节点值，小于右子树的所有节点值，那么我们可以做如下的判断，如果根节点的值大于p和q之间的较大值，说明p和q都在左子树中，那么此时我们就进入根节点的左子节点继续递归，如果根节点小于p和q之间的较小值，说明p和q都在右子树中，那么此时我们就进入根节点的右子节点继续递归，如果都不是，则说明当前根节点就是最小共同父节点，直接返回即可
         */
		if(root==null) return null;
		//在左子树
		if(root.val>Math.max(p.val, q.val)) {
			return lowestCommonAncestor(root.left, p, q);
		}
		//在右子树
		else if(root.val<Math.min(p.val, q.val)) {
			return lowestCommonAncestor(root.right, p, q);
		}else {
			return root;
		}
    }
	
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		val=x;
	}
}
}
