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
     * ʵ��ɾ���ַ����г��ִ������ٵ��ַ���������ַ����ִ���һ������ɾ��;
     * ���ɾ����Щ���ʺ���ַ������ַ����������ַ�����ԭ����˳��;
     */
    public static String process(String str)
    {
    	return null;
    }
    /*
     * ͳ����������
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
