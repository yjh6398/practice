package com.itheima.test;

import java.util.Scanner;
public class Test29
{
    public static void main(String[] args)
    {
    	Scanner sc=new Scanner(System.in);
    	int m=sc.nextInt();
    	int n=sc.nextInt();
    	System.out.println(countBitDiff(m,n));
    }
    /*
     * �����������Ķ����Ʊ��ʽ�в�ͬλ��������
     */
    public static int countBitDiff(int m,int n)
    {
    	int count=0;
    	int num=m^n;
    	while(num>0)
    	{
    		count++;
    		num=num&(num-1);
    	}
    	return count;
    }
}
