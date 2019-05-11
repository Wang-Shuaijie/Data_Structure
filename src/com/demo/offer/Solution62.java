package com.demo.offer;

public class Solution62 {
	/**
	 * 请实现两个函数，分别用来序列化和反序列化二叉树
	 * 序列化：前序遍历二叉树存入字符串中；反序列化：根据前序遍历重建二叉树。
	 */
	public String serialize(TreeNode root) {
		StringBuilder sb=new StringBuilder();
		if(root==null) {
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val+",");
		sb.append(serialize(root.left));
		sb.append(serialize(root.right));
		return sb.toString();
	}
	
	private int index=-1;
	public TreeNode deserialize(String s) {
		index++;
		if(s==null || s.length()==0) return null;
		if(index>=s.length()) return null;
		String[] str=s.split(",");
		TreeNode root=null;
		if(!str[index].equals("#")) {
			root = new TreeNode(Integer.valueOf(str[index]));
			root.left=deserialize(s);
			root.right=deserialize(s);
		}
		return root;
	}
	
	
	
	
	//大神CyC2018解法
	private String deserializeStr;

	public String Serialize(TreeNode root) {
	    if (root == null)
	        return "#";
	    return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
	}

	public TreeNode Deserialize(String str) {
	    deserializeStr = str;
	    return Deserialize();
	}

	private TreeNode Deserialize() {
	    if (deserializeStr.length() == 0)
	        return null;
	    int index = deserializeStr.indexOf(" ");
	    String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
	    deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
	    if (node.equals("#"))
	        return null;
	    int val = Integer.valueOf(node);
	    TreeNode t = new TreeNode(val);
	    t.left = Deserialize();
	    t.right = Deserialize();
	    return t;
	}
	
	
	
	
	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			x=val;
		}
	}
}
