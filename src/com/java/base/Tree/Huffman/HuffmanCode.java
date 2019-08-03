package com.java.base.Tree.Huffman;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode {
		/*
		 * eg:
		 * can you can a can as a can canner can a can.
		 * 出现的次数: c:7 a:11 n:8 y:1 o:1 u:1 s:1 e:1 r:1 空格:11 .:1                      
		 * 					     44                          n:00
		 *                    0/   1\                   (空格):01 
		 * 		            19        25                     a:10
		 * 			      0/ 1\     0/ 1\                    c:111  
		 * 				  8   11    11  14                   o:11000
		 * 							  0/  1\                 y:110010
		 *                            7     7                .:110011 
		 *                         0/  1\                    u:110100
		 *                        3       4                  e:110101
		 *                      0/1\    0/1\                 r:110110  
		 *                      1   2   2   2                s:110111 
		 *                        0/1\0/1\0/1\
		 *                         1 1 1 1 1 1
		 * 
		 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String msg="can you can a can as a can canner can a can.";
		//转化为byte数组(也可以用char数组)
		//c->99 a->97 n->110 空格->32 ....
		byte[] bytes=msg.getBytes();
		System.out.println(bytes.length);
		System.out.println(Arrays.toString(bytes));
		System.out.println("*****************************");
		//进行赫夫曼编码压缩
		byte[] newBytes=huffmanZip(bytes);
		System.out.println(newBytes.length);
		for(byte b:newBytes) {
			//Integer.toBinaryString(s)要补齐32位，+补0，-补1
			System.out.println(b+":"+Integer.toBinaryString(b));
		}
		System.out.println("******************************");
		//进行解码
		byte[] oldBytes=decode(newBytes,huffCodes);
		System.out.println(Arrays.toString(oldBytes));
		System.out.println(new String(oldBytes));
		System.out.println("******************************");
		String src="C:\\Users\\WangShuaiJie\\Downloads\\head.jpg", dst="C:\\Users\\WangShuaiJie\\Downloads\\test";
		zipFile(src, dst);
		String newSrc="C:\\Users\\WangShuaiJie\\Downloads\\test", newDst="C:\\Users\\WangShuaiJie\\Downloads\\test.jpg";
		unZipFile(newSrc, newDst);
	}

	/**
	 * 进行赫夫曼压缩
	 * @param bytes
	 * @return
	 */
	private static byte[] huffmanZip(byte[] bytes) {
		//先统计出每一个byte出现的次数，并放入一个集合中
		List<Node> nodes=getNodes(bytes);
		//创建一个赫夫曼树
		Node huffmanTree=createHuffmanTree(nodes);
		//创建一个赫夫曼编码表
		Map<Byte,String> huffCodes=getCodes(huffmanTree);
		/*for(Byte b:huffCodes.keySet()) {
			System.out.println(b+":"+huffCodes.get(b));
		}*/
		//编码
		byte[] b=zip(huffCodes,bytes);
		return b;
	}

	/**
	 * 将byte数组转为node集合
	 * @param bytes
	 * @return
	 */
	private static List<Node> getNodes(byte[] bytes) {
		List<Node> nodes=new ArrayList<>();
		//统计每一个字符(byte)出现的次数
		Map<Byte, Integer> map=new HashMap<Byte, Integer>();
		for(Byte b:bytes) {
			if(map.containsKey(b)) {
				map.put(b, map.get(b)+1);
			}else {
				map.put(b, 1);
			}
		}
		/*for(Byte b:map.keySet()) {
			System.out.println(b+"出现的次数:"+map.get(b));
		}*/
		//把每一个键值转换成node对象
		for(Byte b:map.keySet()) {
			nodes.add(new Node(b, map.get(b)));
		}
		return nodes;
	}
	/**
	 * 创建huffman树
	 * @param nodes
	 * @return
	 */
	private static Node createHuffmanTree(List<Node> nodes) {
		while(nodes.size()>1) {
			//排序
			Collections.sort(nodes);
			//取出两个权值最低的二叉树
			Node left=nodes.get(nodes.size()-1);
			Node right=nodes.get(nodes.size()-2);
			Node parent=new Node(null,left.weight+right.weight);
			parent.left=left;
			parent.right=right;
			//把之前取出的两个二叉树删掉
			nodes.remove(left);
			nodes.remove(right);
			//把新创建的二叉树放入集合中
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	/**
	 * 遍历huffman树得到编码表(左子树为0，右子树为1)
	 * @param huffmanTree
	 * @return
	 */
	static StringBuilder sb=new StringBuilder();
	static Map<Byte, String> huffCodes=new HashMap<>();
	private static Map<Byte, String> getCodes(Node huffmanTree) {
		if(huffmanTree==null) return null;
		getCodes(huffmanTree.left,"0",sb);
		getCodes(huffmanTree.right,"1",sb);
		return huffCodes;
	}
	private static void getCodes(Node node, String code, StringBuilder sb) {
		StringBuilder res=new StringBuilder(sb);
		res.append(code);
		//不是叶节点
		if(node.data==null) {
			getCodes(node.left,"0",res);
			getCodes(node.right,"1",res);
		}else {
			huffCodes.put(node.data,res.toString());
		}
	}
	/**
	 * 将byte数组根据huffman编码表转换成01代码
	 * @param huffCodes
	 * @param bytes
	 * @return
	 */
	private static byte[] zip(Map<Byte, String> huffCodes, byte[] bytes) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<bytes.length;i++) {
			sb.append(huffCodes.get(bytes[i]));
			/*sb.append(huffCodes.get(bytes[i])+" ");*/
		}
		/*System.out.println(sb.toString());*/
		//每8个进行压缩
		int len;
		if(sb.length()%8==8) {
			len=sb.length()/8;
		}else {
			len=sb.length()/8+1;
		}
		//用于存储压缩后的数组
		byte[] res=new byte[len];
		int index=0;
		for(int i=0;i<sb.length();i+=8) {
			String str;
			if((i+8)>sb.length()) {
				str=sb.substring(i);
			}else {
				str=sb.substring(i, i+8);
			}
			//System.out.println(str);
			//Integer.parseInt(str,2):把2进制字符串转换成10进制数字
			Byte byt=(byte) Integer.parseInt(str,2);
			res[index]=byt;
			index++;
		}
		return res;
	}
	/**
	 * 使用指定的赫夫曼编码表进行解码
	 * @param bytes
	 * @param huffCodes 
	 * @return
	 */
	private static byte[] decode(byte[] bytes, Map<Byte, String> huffCodes) {
		StringBuilder sb=new StringBuilder();
		//将byte数组转为二进制字符串
		for(int i=0;i<bytes.length;i++) {
			//Integer.toBinaryString(b)适用于int类型，byte类型会出现自动补齐位数（32位）的情况
			/*String s=Integer.toBinaryString(b);*/
			byte b=bytes[i];
			//是否是最后一个
			boolean flag=(i!=(bytes.length-1));
			sb.append(byteToBinaryString(b,flag));
			
		}
		/*System.out.println(sb.toString());*/
		//根据字符串解码
		//把赫夫曼键值对进行调换
		Map<String, Byte> map=new HashMap<>();
		for(Byte b:huffCodes.keySet()) {
			map.put(huffCodes.get(b), b);
		}
		
		//创建一个集合，存取byte
		List<Byte> list=new ArrayList<>();
		
		//处理字符串
		//需要循环截取，所以不能是平常的for循环
		for(int i=0;i<sb.length();) {
			int count=1;
			boolean flag=true;
			Byte b=null;
			while(flag) {
				String key=sb.substring(i,i+count);
				b=map.get(key);
				if(b==null) {
					count++;
				}else {
					flag=false;
				}
			}
			list.add(b);
			i+=count;
		}
		//把集合转为数组
		byte[] b=new byte[list.size()];
		for(int i=0;i<list.size();i++) {
			b[i]=list.get(i);
		}
		return b;
	}
	
	/**
	 * 工具方法
	 * byte类型转二进制字符串
	 * @return
	 */
	public static String byteToBinaryString(byte b,boolean flag) {
		//将byte转换成int，然后利用Integer.toBinaryString(int)来转换成2进制字符串
		//不能将byte强转为int不行
		int temp=b;
		//进行或计算（两个位只要有一个为1，那么结果就是1，否则就为0,相当于用0补齐）
		//新问题：如果全都补齐，以前老编码若不是8的倍数，如111会被补为00000111，影响结果,所以最后一位不补
		if(flag) {
			temp |= 256;
		}
		String str=Integer.toBinaryString(temp);
		if(flag) {
			return str.substring(str.length()-8, str.length());
		}else {
			return str;
		}
	}
	
	/**
	 * 对文件的压缩
	 * @param str
	 * @param dst
	 * @throws IOException
	 */
	public static void zipFile(String src,String dst)throws IOException{
		//创建一个输入流
		InputStream is=new FileInputStream(src);
		//创建一个和输入流指向文件大小一样的byte数组
		byte[] b=new byte[is.available()];
		//读取文件内容
		is.read(b);
		is.close();
		//使用huffman编码进行文件压缩
		byte[] newBytes=huffmanZip(b);
		//输出流
		OutputStream os=new FileOutputStream(dst);
		ObjectOutputStream oos=new ObjectOutputStream(os);
		//把压缩后的byte数组写入文件
		oos.writeObject(newBytes);
		//把huffman编码表写入文件
		oos.writeObject(huffCodes);
		oos.close();
		os.close();
	}
	/**
	 * 解压文件
	 * @param src
	 * @param dst
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 */
	public static void unZipFile(String src,String dst)throws IOException, ClassNotFoundException{
		//创建一个输入流
		InputStream is=new FileInputStream(src);
		ObjectInputStream ois=new ObjectInputStream(is);
		//读取byte数组
		byte[] b=(byte[]) ois.readObject();
		//读取huffman编码
		Map<Byte,String> code=(Map<Byte, String>) ois.readObject();
		ois.close();
		is.close();
		//解码
		byte[] oldBytes=decode(b, code);
		//创建一个输出流
		OutputStream os=new FileOutputStream(dst);
		//写出数据
		os.write(oldBytes);
		os.close();		
	}
}

/**
 * huffman编码节点
 * @author WangShuaiJie
 *
 */
class Node implements Comparable<Node>{
	//叶子节点存放的还有字符
	Byte data;
	//权值
	int weight;
	Node left;
	Node right;
	
	public Node(Byte data, int weight) {
		this.data=data;
		this.weight=weight;
	}

	@Override
	public int compareTo(Node o) {
		//从大到小
		return o.weight-this.weight;
	}
}
