package com.itheima.test;

import java.util.Random;

public class Test{
   public static void main(String[] args)
   {
	   StringBuilder s=new StringBuilder();
	   s.append("java");
	   s.append("dfjjds",3,5);
	   System.out.println(s);
	   int[] arr=new int[20];
	   Random r=new Random();
	   for(int i=0;i<arr.length;i++)
	   {
		   arr[i]=r.nextInt(100);
	   }
	   arr=orderArr(arr);
	   printArr(arr);
   }
   public static void printArr(int[] a)
   {
	   for(int i=0;i<a.length;i++)
	   {
		   System.out.print(a[i]+" ");
	   }
   }
   public static int binarySearch(int[] arr,int num)
   {
	  int mid;
	  int low_index=0;
	  int high_index=arr.length-1;
	  while(low_index<high_index)
	  {
		  mid=(low_index+high_index)/2;
		  if(arr[mid]==num)
			  return mid;
		  else if(num>arr[mid])
			  low_index=mid+1;
		  else
			  high_index=mid-1;
	  }
	  return -1;
   }
   public static int[] orderArr(int[] arr)
   {
	   int temp=0;
	   for(int i=0;i<arr.length;i++)
	   {
		   for(int j=i;j<arr.length;j++)
		   {
			   if(arr[i]>arr[j])
			   {
				   temp=arr[i];
			       arr[i]=arr[j];
			       arr[j]=temp;
			   }
		   }
	   }
	   return arr;
   }
}
	
	

