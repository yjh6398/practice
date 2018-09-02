package com.itheima.test;

import java.util.Scanner;

/*
 * ¹ºÂòÆ»¹ûÎÊÌâ
 */
public class Test11 {
   public static void main(String[] args)
   {
	   Scanner sc=new Scanner(System.in);
	   int n=sc.nextInt();
	   int min=0;
	   int[] dp=new int[n];
	   for(int i=0;i<n;i++)
	   {
		   for(int j=0;j<n;j++)
		   {
			   if((i*6+j*8)==n)
			   {
				   dp[i]=i+j;
				   min=dp[i];
				   if(dp[i+1]<min)
				   {
					   min=dp[i+1];
				   }
			   }
		   }
	   }
	   System.out.println(min);
   }
}
