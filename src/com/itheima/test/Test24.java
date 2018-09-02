package com.itheima.test;
import java.util.Scanner;
public class Test24
{
    public static void main(String[] args)
    {
    	Scanner sc=new Scanner(System.in);
    	int n=sc.nextInt();
    	get(n);
    }
    public static void get(int n)
    {
    	for(int i=0;i<20;i++)
    	{
    		for(int j=0;j<33;j++)
    		{
    			if(100-5*i-3*j>0)
    			{
    				System.out.println(i+" "+j+" "+((100-5*i-3*j)*3));
    			}
    		}
    	}
    }
}
