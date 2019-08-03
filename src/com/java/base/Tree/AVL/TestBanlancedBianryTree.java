package com.java.base.Tree.AVL;

public class TestBanlancedBianryTree {
//	/*     
//	 *         8                 ___ 6                 6
//	 *        / \               |   X \               / \
//	 *       6   9     ÓÒÐý×ª          |  6   8             5   8
//	 *      / \       ---->     | /   / \   ---->   /   / \
//	 *     5   7                5    7   9         4   7   9  
//	 *    /                    /
//	 *   4                    4
//	 * 
//	 */
//	public static void main(String[] args) {
//		int[] nums=new int[] {8,9,6,7,5,4};
//		BanlancedBinaryTree tree=new BanlancedBinaryTree();
//		for(int i:nums) {
//			tree.add(new TreeNode(i));
//		}
//		System.out.println(tree.root.value);
//		System.out.println(tree.root.getHeight());
//	}
	
//	/*     
//	 *         2                 4
//	 *        / \               / \
//	 *       1   4     ×óÐý×ª        2   5
//	 *          / \     ----> / \   \
//	 *         3   5         1   3   6  
//	 *              \
//	 *               6
//	 * 
//	 */
//	public static void main(String[] args) {
//		int[] nums=new int[] {2,1,4,3,5,6};
//		BanlancedBinaryTree tree=new BanlancedBinaryTree();
//		for(int i:nums) {
//			tree.add(new TreeNode(i));
//		}
//		System.out.println(tree.root.value);
//		System.out.println(tree.root.getHeight());
//	}
	
	/*     
	 *         8                 8               6
	 *        / \               / \             / \
	 *       5   9     Ë«Ðý×ª        6   9           5   8
	 *      / \      ---->    / \     ---->   /   / \
	 *     4   6             5   7           4   7   9
	 *          \           /
	 *           7         4
	 * 
	 */
	public static void main(String[] args) {
		int[] nums=new int[] {8,9,5,4,6,7};
		BanlancedBinaryTree tree=new BanlancedBinaryTree();
		for(int i:nums) {
			tree.add(new TreeNode(i));
		}
		System.out.println(tree.root.value);
		System.out.println(tree.root.getHeight());
	}
}
