package com.itheima.test;

import java.util.Scanner;
public class Test40
{
   public static void main(String[] args)
   {
	  Scanner sc=new Scanner(System.in);
	  while(sc.hasNext())
	  {
		  String str=sc.next();
		  System.out.println(getTime(str));
	  }
	   
   }
   public static int getTime(String str)
   {
	   String[] strArr=new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	   char[] cha=str.toCharArray();
	   int index=0;
	   int time=0;
	   int t=-1;
	   while(index<str.length())
	   {
		   for(int i=0;i<strArr.length;i++)
		   {
			   if(strArr[i].indexOf(cha[index])!=-1)
			   {
				   if(t==i)
				   {
					   time+=2+strArr[i].indexOf(cha[index])+1;
				   }
				   else
				   {
					   time+=strArr[i].indexOf(cha[index])+1;
				   }
				   index++;
				   t=i;
				   break;
			   }
		   }
	   }
	   return time;
   }
}
