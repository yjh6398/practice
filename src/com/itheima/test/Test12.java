package com.itheima.test;

import java.util.Scanner;
public class Test12
{
	static int[] str={1,2,3,4,5};
    public static void main(String[] args)
    {
    	System.arraycopy(str, 2, str, 0, 3);
    	for(int obj:str)
    	{
    		System.out.println(obj);
    	}
    	Scanner sc=new Scanner(System.in);
    	while(sc.hasNext())
    	{
    		int n=sc.nextInt();
    		System.out.println(getNewInt(n));
    	}
    }
    public static int getNewInt(int n)
    {
    	int count=0;
    	StringBuilder sb=new StringBuilder(String.valueOf(n));
        char[] cha=String.valueOf(n).toCharArray();
        int[] index=new int[cha.length];
        for(int i=cha.length-1;i>=1;i--)
        {
        	for(int j=i-1;j>=0;j--)
        	{
        		if(cha[i]==cha[j])
        		{
        			index[count]=j;
        		    count++;
        		}
        		    
        	}
        }
        System.out.println(count);
        for(int obj:index)
        {
        	System.out.println(obj);
        }
        for(int i=0;i<count-1;i++)
        {
        	sb.replace(index[i], index[i]+1, "");
        }
        return Integer.parseInt(sb.toString());
    }
}
