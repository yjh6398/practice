package com.itheima.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * 序列化java对象
 */
public class Test5 implements Serializable{
   public static String filePath="C:\\Users\\Administrator.WQ-20180111OSAG\\Desktop\\1.txt";
   //将对象写入指定文件
   public void writeObject(Test5 t) throws FileNotFoundException
   {
	  FileOutputStream outputStream=new FileOutputStream(filePath);
	  try
	  {
		  if(t==null)
		  {
			  return;
		  }
		  ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
		  objectOutputStream.writeObject(t);
		  System.out.println(t);
		  outputStream.close();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
   }
   //从文件中读取指定对象
   @SuppressWarnings("unused")
   public Test5 readObject(String filePath) throws FileNotFoundException
   {
	   FileInputStream inputStream=new FileInputStream(filePath);
	   try
	   {
		 if(inputStream==null)  
		 {
			 return null;
		 }
		 
		 ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
		 Test5 tt=(Test5)objectInputStream.readObject();
		 System.out.println(tt);
		 return tt;
		}
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   return null;
   }
   //普通方法
    public void say()
    {
    	System.out.println("Hello");
    }
   //程序入口
   public static void main(String[] args) throws FileNotFoundException
   {
	   Test5 t=new Test5();
	   t.writeObject(t);
	   Test5 read_t=t.readObject(filePath);
	   read_t.say();
   }
}
