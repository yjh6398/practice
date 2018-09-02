package com.itheima.test;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


class Person
{
	private  String name;
	private  int age;
	public String toString()
	{
		return "person[name:"+name+","+"age:"+age+"]";
	}
}

public class Test6{
  //����1��Ҫ���ȡ�û�������ַ������ַ������ȣ����ַ������ȶ��ַ������зָ�
	public static void main(String[] args) throws IOException, SecurityException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException
	{
       Class clazz=Person.class;
       Person p=(Person) clazz.newInstance();
       Field f_name=clazz.getDeclaredField("name");
       f_name.setAccessible(true);
       f_name.set(p, "yjh");
       Field f_age=clazz.getDeclaredField("age");
       f_age.setAccessible(true);
       f_age.set(p, 12);
       System.out.println(p.toString());
       Method m=clazz.getMethod("toString");
       Object obj=m.invoke(p);
       System.out.println(obj);
	}
	private void sayHello(String name)
	{
		System.out.println(name+":Hello");
	}
	//����1��Ҫ���ȡ�û�������ַ������ַ������ȣ����ַ������ȶ��ַ������зָ�
	public static String[] splitStr(String arr,int l)
	{
		int n=0;
		int k=arr.length()/l;
		int m=arr.length()%l;
		if(m!=0)
		{
			n=k+m;
		}
		String[] ret=new String[n];
		for(int i=0;i<n;i++)
		{
			if(i<n-1)
			{
				ret[i] = arr.substring(i*l , (i+1)*l); 
			}
			else
			{
				ret[i] = arr.substring(i*l); 
			}
		}
		return ret;
	}
	//��1��100�ĺ�
	public static void getSum()
	{
		int sum=0;
		for(int i=0;i<=100;i++)
		{
			sum+=i;
		}
		System.out.println(sum);
	}
	//��֪һ�����飬������������ֵ
	public static void getMax(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println(arr[0]);
	}
	//�ָ��ַ�����������split
	public static String[] getArrays(String s,String mark)
	{
		StringTokenizer st=new 	StringTokenizer(s,mark);
		int count=st.countTokens();
		String[] str=new String[count];
		int i=0;
		while(st.hasMoreElements())
		{
			str[i]=(String) st.nextElement();
			i++;
		}
		return str;
	}
	//��ӡ���9*9�˷��ھ���
	public static void printT()
	{
		for(int i=1;i<=9;i++)
		{
			for(int j=1;j<=9;j++)
			{
				System.out.print(i+"*"+j+"="+i*j+" ");
				if(j==9)
				{
					System.out.println();
				}
			}
		}
	}
	//ͳ��һ�ַ����и��ַ����ֵĴ���
	public  static Map<Character,Integer> getCount(String str)
	{
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		char[] chaArray=str.toCharArray();
		for(char obj:chaArray)
		{
			map.put(obj, !map.containsKey(obj)?1:map.get(obj)+1);
		}
		return map;
	}
}
	