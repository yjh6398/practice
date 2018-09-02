package com.itheima.test;

import java.util.ArrayList;
import java.util.Collection;

public class GenericMethodTest {
	public static <T> void fromArrayToCollection(T[] a,Collection<T> c)
	{
		for(T o:a)
		{
			c.add(o);
		}
	}
    public static void main(String[] args)
    {
    	Object[] oa=new Object[100];
    	Collection<Object> co=new ArrayList<Object>();
    	fromArrayToCollection(oa,co);
    }
}
