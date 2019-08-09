package com.java.���Ծ�ѡ;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * ��дһ�����򣬽�a.txt�ļ��еĵ�����b.txt�ļ��еĵ��ʽ���ϲ���c.txt�ļ��У�
 * a.txt�ļ��еĵ����ûس����ָ���b.txt�ļ����ûس���ո���зָ���
 * @author WangShuaiJie
 *
 */
public class Main13 {
	public static void main(String[] args) throws Exception {
		FileManager a= new FileManager("a.txt", new char[] {'\n'});
        FileManager b= new FileManager("b.txt",new char[]{'\n',' '});        
        FileWriter c= new FileWriter("c.txt");
        String aWord= null;
        String bWord= null;
        while((aWord= a.nextWord()) !=null ){
               c.write(aWord+ "\n");
               bWord= b.nextWord();
               if(bWord!= null)
                      c.write(bWord+ "\n");
        }
      
        while((bWord= b.nextWord()) != null){
               c.write(bWord+ "\n");
        }   
        c.close();
	}
	
	static class FileManager{
		String[] words=null;
		int pos=0;
		public FileManager(String filename, char[] seperators)throws Exception {
			File file=new File(filename);
			FileReader fileReader=new FileReader(file);
			char[] buff=new char[(int)file.length()];
			int len=fileReader.read(buff);
			String results=new String(buff,0,len);
			String regex=null;
			if(seperators.length>1 ){
                regex= "" + seperators[0] + "|" + seperators[1];
			}else{
                regex= "" + seperators[0];
			}
			words =results.split(regex);
		}
		
		public String nextWord(){
            if(pos ==words.length)
                   return null;
            return words[pos++];
		}
	}
}

