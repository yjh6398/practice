package com.itheima.test;

import java.util.Scanner;
public class Test26
{
    public static void main(String[] args)
    { 
       Scanner sc=new Scanner(System.in);
       String str1=sc.nextLine();
       String str2=sc.nextLine();
       System.out.println(getResult(str1,str2));
    }
    public static String getResult(String str1,String str2)
    {  
       String str="Yes";
       char[] arr=str2.toCharArray();
       for(int i=0;i<arr.length;i++)
       {
    	   int m=str1.indexOf(arr[i]);
    	   if(m!=-1)
    	   {
    		   str1=str1.substring(m+1);
    	   }
    	   else
    	   {
    	      str="No";
    	      break;
    	   }
       }
       return str;
    }
}
