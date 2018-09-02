package com.itheima.test;

import java.util.Scanner;

public class Test10
{
   public static void main(String[] args)
   {
	   int[] arr=new int[]{1,2,3,3,2,1};
	   System.out.println(getLIS(arr));
	   System.out.println(getLDS(arr));
	   System.out.println(getMax(arr));
	   System.out.println(longest("abcabccba"));
     
   }
   /*
    * 动态规划问题之求连续子数组的最大和
    */
   public static int getMax(int[] arr)
   {
	   int[] dp=new int[arr.length];
	   dp[0]=arr[0];
	   int max=arr[0];
	   for(int i=1;i<arr.length;i++)
	   {
		   if(dp[i-1]+arr[i]>arr[i])
			   dp[i]=dp[i-1]+arr[i];
		   else
			   dp[i]=arr[i];
		   if(dp[i]>max)
			   max=dp[i];
	   }
	   return max;
   }
   /*
    * 动态规划数组之求最大上升序列的长度
    */
   public static int getLIS(int[] arr)
   {
	   int max=0;
	   int[] dp=new int[arr.length];
	   for(int i=0;i<arr.length;i++)
	   {
		   dp[i]=1;
		   for(int j=0;j<i;j++)
		   {
			   if(arr[i]>arr[j]&&dp[j]+1>dp[i])
				   dp[i]=dp[j]+1;
		   }
	   }
	   for(int obj:dp)
	   {
		  if(obj>max) 
			  max=obj;
	   }
	   return max;
   }
   /*
    * 动态规划之求最长递减序列
    */
   public static int getLDS(int[] arr)
   {
	   int max=0;
	   int[] dp=new int[arr.length];
	   for(int i=0;i<arr.length;i++)
	   {
		   dp[i]=1;
		   for(int j=0;j<i;j++)
		   {
			   if(arr[i]<arr[j]&&dp[j]+1>dp[i])
				   dp[i]=dp[j]+1;
		   }
	   }
	   for(int obj:dp)
	   {
		   if(obj>max)
			   max=obj;
	   }
	   return max;
   }
   /*
    * 动态规划求解背包问题，找到能放进背包的物品的最大价值
    * w[i]:存储对应物体的体积
    * v[i]:存储对应物体的价值
    * capacity:背包容量
    * number:物体的数量
    */
   
   //动态规划求最长的回文串
   public static String longest(String s)
   {
	   if(s==null)
		   return null;
	   if(s.length()<=1)
		   return s;
	   int maxLen=0;
	   String longestStr=null;
	   int length=s.length();
	   int[][] table=new int[length][length];
	   //每个字母都是一个最小长度的回文串
	   for(int i=0;i<length;i++)
	   {
		   table[i][i]=1;
	   }
	   //连续的两个相同字母是长度为2的回文串
	   for(int i=0;i<=length-2;i++)
	   {
		   if(s.charAt(i)==s.charAt(i+1))
			   table[i][i+1]=1;
		   longestStr=s.substring(i,i+2);
	   }
	   //长度大于3的回文串
	   for(int l=3;l<=length;l++)
	   {
		   for(int i=0;i<=length-l;i++)
		   {
			   int j=i+l-1;
			   if(s.charAt(i)==s.charAt(j))
			   {
				   table[i][j]=table[i+1][j-1];
				   if(table[i][j]==1&&l>maxLen)
					   longestStr=s.substring(i,j+1);
			   }
			   else
			   {
				   table[i][j]=0;
			   }
		   }
	   }
	   return longestStr;
   }
   
}
