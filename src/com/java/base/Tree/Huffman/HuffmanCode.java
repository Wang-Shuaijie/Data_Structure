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
		 * ���ֵĴ���: c:7 a:11 n:8 y:1 o:1 u:1 s:1 e:1 r:1 �ո�:11 .:1                      
		 * 					     44                          n:00
		 *                    0/   1\                   (�ո�):01 
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
		//ת��Ϊbyte����(Ҳ������char����)
		//c->99 a->97 n->110 �ո�->32 ....
		byte[] bytes=msg.getBytes();
		System.out.println(bytes.length);
		System.out.println(Arrays.toString(bytes));
		System.out.println("*****************************");
		//���кշ�������ѹ��
		byte[] newBytes=huffmanZip(bytes);
		System.out.println(newBytes.length);
		for(byte b:newBytes) {
			//Integer.toBinaryString(s)Ҫ����32λ��+��0��-��1
			System.out.println(b+":"+Integer.toBinaryString(b));
		}
		System.out.println("******************************");
		//���н���
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
	 * ���кշ���ѹ��
	 * @param bytes
	 * @return
	 */
	private static byte[] huffmanZip(byte[] bytes) {
		//��ͳ�Ƴ�ÿһ��byte���ֵĴ�����������һ��������
		List<Node> nodes=getNodes(bytes);
		//����һ���շ�����
		Node huffmanTree=createHuffmanTree(nodes);
		//����һ���շ��������
		Map<Byte,String> huffCodes=getCodes(huffmanTree);
		/*for(Byte b:huffCodes.keySet()) {
			System.out.println(b+":"+huffCodes.get(b));
		}*/
		//����
		byte[] b=zip(huffCodes,bytes);
		return b;
	}

	/**
	 * ��byte����תΪnode����
	 * @param bytes
	 * @return
	 */
	private static List<Node> getNodes(byte[] bytes) {
		List<Node> nodes=new ArrayList<>();
		//ͳ��ÿһ���ַ�(byte)���ֵĴ���
		Map<Byte, Integer> map=new HashMap<Byte, Integer>();
		for(Byte b:bytes) {
			if(map.containsKey(b)) {
				map.put(b, map.get(b)+1);
			}else {
				map.put(b, 1);
			}
		}
		/*for(Byte b:map.keySet()) {
			System.out.println(b+"���ֵĴ���:"+map.get(b));
		}*/
		//��ÿһ����ֵת����node����
		for(Byte b:map.keySet()) {
			nodes.add(new Node(b, map.get(b)));
		}
		return nodes;
	}
	/**
	 * ����huffman��
	 * @param nodes
	 * @return
	 */
	private static Node createHuffmanTree(List<Node> nodes) {
		while(nodes.size()>1) {
			//����
			Collections.sort(nodes);
			//ȡ������Ȩֵ��͵Ķ�����
			Node left=nodes.get(nodes.size()-1);
			Node right=nodes.get(nodes.size()-2);
			Node parent=new Node(null,left.weight+right.weight);
			parent.left=left;
			parent.right=right;
			//��֮ǰȡ��������������ɾ��
			nodes.remove(left);
			nodes.remove(right);
			//���´����Ķ��������뼯����
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	/**
	 * ����huffman���õ������(������Ϊ0��������Ϊ1)
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
		//����Ҷ�ڵ�
		if(node.data==null) {
			getCodes(node.left,"0",res);
			getCodes(node.right,"1",res);
		}else {
			huffCodes.put(node.data,res.toString());
		}
	}
	/**
	 * ��byte�������huffman�����ת����01����
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
		//ÿ8������ѹ��
		int len;
		if(sb.length()%8==8) {
			len=sb.length()/8;
		}else {
			len=sb.length()/8+1;
		}
		//���ڴ洢ѹ���������
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
			//Integer.parseInt(str,2):��2�����ַ���ת����10��������
			Byte byt=(byte) Integer.parseInt(str,2);
			res[index]=byt;
			index++;
		}
		return res;
	}
	/**
	 * ʹ��ָ���ĺշ����������н���
	 * @param bytes
	 * @param huffCodes 
	 * @return
	 */
	private static byte[] decode(byte[] bytes, Map<Byte, String> huffCodes) {
		StringBuilder sb=new StringBuilder();
		//��byte����תΪ�������ַ���
		for(int i=0;i<bytes.length;i++) {
			//Integer.toBinaryString(b)������int���ͣ�byte���ͻ�����Զ�����λ����32λ�������
			/*String s=Integer.toBinaryString(b);*/
			byte b=bytes[i];
			//�Ƿ������һ��
			boolean flag=(i!=(bytes.length-1));
			sb.append(byteToBinaryString(b,flag));
			
		}
		/*System.out.println(sb.toString());*/
		//�����ַ�������
		//�Ѻշ�����ֵ�Խ��е���
		Map<String, Byte> map=new HashMap<>();
		for(Byte b:huffCodes.keySet()) {
			map.put(huffCodes.get(b), b);
		}
		
		//����һ�����ϣ���ȡbyte
		List<Byte> list=new ArrayList<>();
		
		//�����ַ���
		//��Ҫѭ����ȡ�����Բ�����ƽ����forѭ��
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
		//�Ѽ���תΪ����
		byte[] b=new byte[list.size()];
		for(int i=0;i<list.size();i++) {
			b[i]=list.get(i);
		}
		return b;
	}
	
	/**
	 * ���߷���
	 * byte����ת�������ַ���
	 * @return
	 */
	public static String byteToBinaryString(byte b,boolean flag) {
		//��byteת����int��Ȼ������Integer.toBinaryString(int)��ת����2�����ַ���
		//���ܽ�byteǿתΪint����
		int temp=b;
		//���л���㣨����λֻҪ��һ��Ϊ1����ô�������1�������Ϊ0,�൱����0���룩
		//�����⣺���ȫ�����룬��ǰ�ϱ���������8�ı�������111�ᱻ��Ϊ00000111��Ӱ����,�������һλ����
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
	 * ���ļ���ѹ��
	 * @param str
	 * @param dst
	 * @throws IOException
	 */
	public static void zipFile(String src,String dst)throws IOException{
		//����һ��������
		InputStream is=new FileInputStream(src);
		//����һ����������ָ���ļ���Сһ����byte����
		byte[] b=new byte[is.available()];
		//��ȡ�ļ�����
		is.read(b);
		is.close();
		//ʹ��huffman��������ļ�ѹ��
		byte[] newBytes=huffmanZip(b);
		//�����
		OutputStream os=new FileOutputStream(dst);
		ObjectOutputStream oos=new ObjectOutputStream(os);
		//��ѹ�����byte����д���ļ�
		oos.writeObject(newBytes);
		//��huffman�����д���ļ�
		oos.writeObject(huffCodes);
		oos.close();
		os.close();
	}
	/**
	 * ��ѹ�ļ�
	 * @param src
	 * @param dst
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 */
	public static void unZipFile(String src,String dst)throws IOException, ClassNotFoundException{
		//����һ��������
		InputStream is=new FileInputStream(src);
		ObjectInputStream ois=new ObjectInputStream(is);
		//��ȡbyte����
		byte[] b=(byte[]) ois.readObject();
		//��ȡhuffman����
		Map<Byte,String> code=(Map<Byte, String>) ois.readObject();
		ois.close();
		is.close();
		//����
		byte[] oldBytes=decode(b, code);
		//����һ�������
		OutputStream os=new FileOutputStream(dst);
		//д������
		os.write(oldBytes);
		os.close();		
	}
}

/**
 * huffman����ڵ�
 * @author WangShuaiJie
 *
 */
class Node implements Comparable<Node>{
	//Ҷ�ӽڵ��ŵĻ����ַ�
	Byte data;
	//Ȩֵ
	int weight;
	Node left;
	Node right;
	
	public Node(Byte data, int weight) {
		this.data=data;
		this.weight=weight;
	}

	@Override
	public int compareTo(Node o) {
		//�Ӵ�С
		return o.weight-this.weight;
	}
}
