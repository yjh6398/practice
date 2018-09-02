package com.itheima.test;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
 * ����һ�����֣���������26���ַ�����ɣ���������ַ����ġ�Ư���ȡ�����������ĸ��Ư���ȡ����ܺ͡� 
 * ÿ����ĸ����һ����Ư���ȡ�����Χ��1��26֮�䡣û���κ�������ĸӵ����ͬ�ġ�Ư���ȡ�����ĸ���Դ�Сд�� 
 * ����������֣�����ÿ�����������ܵġ�Ư����
 */
public class Test34
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String[] str=new String[n];
		for(int i=0;i<n;i++)
		{
			str[i]=sc.next();
		}
		for(int i=0;i<n;i++)
		{
			System.out.println(getMax(str[i]));
		}
	}
    public static int getMax(String str)
    {
    	int index=0;
    	int num=26;
    	int max=0;
    	char[] arr=str.toCharArray();
    	Map<Character,Integer> map=new HashMap<Character,Integer>();
    	for(char obj:arr)
    	{
    		map.put(obj, !map.containsKey(obj)?1:map.get(obj)+1);
    	}
    	int[] intArr=new int[map.size()];
    	for(Character key:map.keySet())
    	{
    		intArr[index]=map.get(key);
    		index++;
    	}
    	intArr=order(intArr);
    	for(int i=0;i<intArr.length;i++)
    	{
    		max+=num*intArr[i];
    		num--;
    	}
    	return max;
    }
    public static int[] order(int[] arr)
    {
    	int temp;
    	for(int i=0;i<arr.length;i++)
    	{
    		for(int j=0;j<arr.length;j++)
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
