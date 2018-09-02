package com.itheima.test;

import java.util.Scanner;

public class Test30
{
   public static void main(String[] args)
   {
	   Scanner sc=new Scanner(System.in);
	   int n=sc.nextInt();
	   int[] arr=new int[n];
	   for(int i=0;i<n;i++)
	   {
		   arr[i]=sc.nextInt();
	   }
	   System.out.println(getLIS(arr));
   }
   public static int getLIS(int[] arr)
   {
	   int[] dp=new int[arr.length];
	   int max=0;
	   for(int i=0;i<arr.length;i++)
	   {
		   dp[i]=1;
		   for(int j=0;j<i;j++)
		   {
			   if(arr[i]>arr[j]&&dp[j]+1>dp[i])
			   {
				   dp[i]=dp[j]+1;
			   }
		   }
	   }
	   for(int obj:dp)
	   {
		   if(obj>max)
			   max=obj;
	   }
	   return max;
   }
}
