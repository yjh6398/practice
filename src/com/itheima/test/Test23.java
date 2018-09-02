package com.itheima.test;

import java.util.Scanner;

public class Test23
{
    public static void main(String[] args)
    {
    	Scanner sc=new Scanner(System.in);
    	String str=sc.nextLine();
    	System.out.println(order(str));
    }
    public static String order(String str)
    {
    	StringBuilder sb=new StringBuilder();
    	char[] arr=str.toCharArray();
    	for(int i=0;i<26;i++)
    	{
    		char c=(char)(i+'A');
    		for(int j=0;j<str.length();j++)
    		{
    			if(str.charAt(j)==c||str.charAt(j)-32==c)
    			{
    				sb.append(str.charAt(j));
    			}
    		}
    	}
    	for(int i=0;i<str.length();i++)
    	{
    		if(!(str.charAt(i)>='a'&&str.charAt(i)<='z')&&!(str.charAt(i)<='Z'&&str.charAt(i)>='A'))
    		{
    			sb.insert(i, str.charAt(i));
    		}
    	}
    	return sb.toString();
    }
}
