package com.itheima.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 排序和查找算法练习
 */
public class Test2 {
	public static void main(String[] args)
	{
		int[] arr=new int[]{1,3,24,56,78};
		arr=orderArr(arr);
		for(int obj:arr)
		{
			System.out.println(obj);
		}
	}
	//二分法查找
	public static int binarySearch(int[] arr,int obj)
	{
		int low=0;
		int high=arr.length-1;
		int mid;
		while(low<high)
		{
			mid=(low+high)/2;
			if(arr[mid]==obj)
				return mid;
			else if(arr[mid]>obj)
				high=mid-1;
			else
				low=mid+1;
		}
		return -1;
	}
	//插值查找法
	public static int insertSearch(int[] arr,int obj)
	{
		int low=0;
		int high=arr.length-1;
		int mid;
		while(low<high)
		{
			mid=(low+high)/2;
			if(arr[mid]==obj)
			{
				return mid;
			}
			else if(arr[mid]>obj)
			{
				high=mid-1;
			}
			else
			{
				low=mid+1;
			}
		}
		return -1;
	}
	//冒泡排序法
	public static int[] orderArr(int[] arr)
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
	//选择排序法
	public static int[] selectOrder(int[] arr)
	{
		int temp;
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
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
	//快速排序法
	public static void quickSort(int[] arr,int low,int high)
	{
		if(low>high)
			return;
		int i=arr[low];
		int j=arr[high];
		int key=arr[low];
		while(i<j)
		{
			while(i<j&&arr[j]>key)
			{
				j--;
			}
			while(i<j&&arr[i]<=key)
			{
				i++;
			}
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		int t=arr[i];
		arr[i]=arr[low];
		arr[low]=t;
		quickSort(arr,low,i-1);
		quickSort(arr,i+1,high);
	}
	//插入排序法
	public static void insertSort(int[] arr)
	{
		int temp;
		int j;
		for(int i=1;i<arr.length;i++)
		{
			temp=arr[i];
			j=i-1;
			while(j>=0&&temp<arr[i])
			{
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp;
		}
		System.out.println(arr.toString());
	}
	//顺序查找法
	public static String sequence_Search(int[] arr,int obj)
	{
	  int count=0;
	  for(int i=0;i<arr.length;i++)
	  {
		  if(arr[i]==obj)
		  {
			  count++;
		  }
	  }
	  if(count==0)
	  {
		  return "抱歉，没有找到";
	  }
	  else
	  {
		  return "一共找到"+count+"个数据";
	  }
	}
	//统计字符串中各个字符出现的次数
   public static Map<Character,Integer> getCount(String str)
   {
	   Map<Character,Integer> map=new HashMap<Character,Integer>();
	   char[] arr=str.toCharArray();
	   for(char obj:arr)
	   {
		   map.put(obj, !map.containsKey(obj)?1:map.get(obj)+1);
	   }
	   return map;
   }
}
//实现动态数组类
class DynArray
{
	int size;
	int default_size;
	int[] arr;
	public DynArray()
	{
		size=0;
		arr=new int[default_size];
	}
	public void add(int element)
	{
		ensureCapacity();
		arr[size++]=element;
	}
	public void ensureCapacity()
	{
		if(size==arr.length)
		{
			int[] longArr=new int[size*2];
			System.arraycopy(arr, 0, longArr, 0, size);
			this.arr=longArr;
		}
	}
}