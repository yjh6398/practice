package com.itheima.test;

import java.util.Scanner;
public class Test32
{
   public static void main(String[] args)
   {
	   Scanner sc=new Scanner(System.in);
	   String str1=sc.next();
	   String str2=sc.next();
	   System.out.println(boollsAllCharExist(str1,str2));
   }
   public static boolean boollsAllCharExist(String str1,String str2)
   {
	   int count=0;
	   boolean flag=false;
	   for(int i=0;i<str1.length();i++)
	   {
		   for(int j=0;j<str2.length();j++)
		   {
			   if(str1.charAt(i)==str2.charAt(j))
			   {
				   count++;
			   }
		   }
	   }
	   if(str1.length()==count)
	   {
		   flag=true;
	   }
	   return flag;
   }
}
