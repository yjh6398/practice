package com.itheima.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
public class Test36
{
   public static void main(String[] args)
   {
	   Scanner sc=new Scanner(System.in);
	   while(sc.hasNext())
	   {
		   int n=sc.nextInt();
		   int[] weight=new int[n];
		   int[] nums=new int[n];
		   for(int i=0;i<n;i++)
		   {
			   weight[i]=sc.nextInt();
		   }
		   for(int i=0;i<n;i++)
		   {
			   nums[i]=sc.nextInt();
		   }
		   System.out.println(fama(n,weight,nums));
	   }
   }
   /*
    * ����һ�����룬����������ȣ��ֱ�Ϊm1,m2,m3��mn�� ÿ�������Ӧ������Ϊx1,x2,x3...xn
    * ����Ҫ����Щ����ȥ�����������(����ͬһ��)�����ܳƳ������ֲ�ͬ�������� ע�� ������������0  
    */
   public static int fama(int n,int[] weight,int[] nums)
   {
	   Set<Integer> set=new HashSet<Integer>();
	   for(int i=0;i<=nums[0];i++)
	   {
		   set.add(weight[0]*i);
	   }
	   for(int i=1;i<n;i++)
	   {
		   List<Integer> list=new ArrayList<Integer>(set);
		   for(int j=0;j<=nums[i];j++)
		   {
			   for(int k=0;k<list.size();k++)
			   {
				   set.add(list.get(k)+weight[i]*j);
			   }
		   }
	   }
	   return set.size();
   }
}
