package com.itheima.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 题目要求：将a.txt文件中的单词与b.txt文件中的单词交替合并到c.txt文件中，a.txt文件中
 * 单词用回车符分隔，b.txt文件中的用回车符或者空格分隔
 */
public class Test7 {
   public static void main(String[] args) throws IOException
   {
	  FileManager a=new FileManager("C:\\Users\\Administrator.WQ-20180111OSAG\\Desktop\\a.txt",new char[]{'\n'});
	  FileManager b=new FileManager("C:\\Users\\Administrator.WQ-20180111OSAG\\Desktop\\b.txt",new char[]{'\n',' '});
	  FileWriter c=new FileWriter("C:\\Users\\Administrator.WQ-20180111OSAG\\Desktop\\c.txt");
	  String aWord=null;
	  String bWord=null;
	  while((aWord=a.nextWords())!=null)
	  {
		  c.write(aWord+'\n');
		  bWord=b.nextWords();
		  if(bWord!=null)
		  {
			  c.write(bWord+'\n');
		  }
	  }
	  while((bWord=b.nextWords())!=null)
	  {
		  c.write(bWord+'\n');
	  }
	  c.close();
   }
}
class FileManager
{
	String[] words=null;
	int pos=0;
	public FileManager(String fileName,char[] seperators) throws IOException
	{
		File f=new File(fileName);
		FileReader reader=new FileReader(f);
		char[] buf=new char[(int)f.length()];
		int len=reader.read(buf);
		String results=new String(buf,0,len);
		String regex=null;
		if(seperators.length>1)
		{
			regex=""+seperators[0]+seperators[1];
		}
		else
		{
			regex=""+seperators[0];
		}
		words=results.split(regex);
	}
	public String nextWords()
	{
		if(pos==words.length)
		{
			return null;
		}
		else
		{
			return words[pos++];
		}
	}
}