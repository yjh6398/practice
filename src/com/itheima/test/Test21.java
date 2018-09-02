package com.itheima.test;

import java.util.Scanner;

public class Test21
{
    public static void main(String[] args)
    {
    	Scanner sc=new Scanner(System.in);
    	while(sc.hasNext())
    	{
    		int month=sc.nextInt();
    		System.out.println(getCount(month));
    	}
    }
    /*
     * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除;
     * 输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序;
     */
    public static String process(String str)
    {
    	return null;
    }
    /*
     * 统计兔子总数
     */
    public static int getCount(int month)
    {
    	int[] arr=new int[month+1];
    	arr[1]=1;
    	arr[2]=1;
    	arr[3]=2;
        for(int i=4;i<=month;i++)
        {
        	arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[month];
    }
}
