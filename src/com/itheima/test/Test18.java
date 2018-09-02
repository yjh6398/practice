package com.itheima.test;

import java.util.Scanner;
/*
 * 合唱队
 */
public class Test18
{
    public static void main(String[] args)
    {
    	int max = 0;
    	Scanner sc=new Scanner(System.in);
    	int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<arr.length;i++)
        {
        	arr[i]=sc.nextInt();
        }
        int[] dp1=getLDS(arr);
        int[] dp2=getLIS(arr);
        for(int i=0;i<dp1.length;i++)
        {
        	if(dp1[i]+dp2[i]>max)
        	{
        		max=dp1[i]+dp1[i];
        	}
        }
        System.out.println(arr.length-max+1);
    }
    /*
     * 动态规划之求数组的最长递减序列
     */
    public static int[] getLDS(int[] arr)
    {
 	   int max=0;
 	   int[] dp=new int[arr.length];
 	   for(int i=0;i<arr.length;i++)
 	   {
 		   dp[i]=1;
 		   for(int j=0;j<i;j++)
 		   {
 			   if(arr[i]<arr[j]&&dp[j]+1>dp[i])
 			   {
 				   dp[i]=dp[j]+1;
 			   }
 		   }
 	   }
 	   for(int obj:dp)
 	   {
 		   System.out.println(obj);
 		   if(obj>max)
 		   {
 			   max=obj;
 		   }
 	   }
 	   return dp;
    }
    /*
     * 动态规划问题之求数组的最大上升序列的长度  
     */
    public static int[] getLIS(int[] arr)
    {
 	   int max=0;
 	   int[] dp=new int[arr.length];
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
 	   for(int i=0;i<dp.length;i++)
 	   {
 		   System.out.println(dp[i]);
 		   if(dp[i]>max)
 		   {
 			  max=dp[i]; 
 		   }
 	   }
 	   return dp;
    }
}
