package com.itheima.test;


import java.util.Scanner;

public class Test17
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String str=Integer.toBinaryString(n);
        char[] arr=str.toCharArray();
        int count=0;
        for(char obj:arr)
        {
        	if(obj=='1')
        		count++;
        }
        System.out.println(count);
    }
}
