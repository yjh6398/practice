package com.itheima.test;

import java.util.Scanner;
public class Test31
{
   public static void main(String[] args)
   {
	   Scanner sc=new Scanner(System.in);
	   int m=sc.nextInt();
	   int n=sc.nextInt();
	   System.out.println(getMin(m,n));
   }
   public static int getMin(int m,int n)
   {
	   int top=m*n;
	   int temp=0;
	   int result=top;
	   int max=2*m;
	   if(2*n>max)
	   {
		   max=2*n;
	   }
	   for(int i=top;i>=max;i--)
	   {
		   if(i%m==0&&i%n==0)
		   {
			   temp=i;
			   if(temp<result)
			   {
				   result=temp;
			   }
		   }
	   }
	   return result;
   }
}
