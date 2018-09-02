package com.itheima.test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * 动态代理
 */
//接口
interface Dog
{
	public void run();
}
//接口实现类
class GunDog implements Dog
{
	public void run()
	{
		System.out.println("Runing");
	}
}
//包含增强处理方法的类
class  DogUtil
{
	public void method1()
	{
		System.out.println("method1");
	}
	public void method2()
	{
		System.out.println("method2");
	}
}
//代理类
class MyInvocationHandler implements InvocationHandler
{
    Object target;
    public void setTarget(Object target)
    {
    	this.target=target;
    }
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		DogUtil u=new DogUtil();
		u.method1();
		Object result=method.invoke(target, args);
		u.method2();
		return result;
	}
}
//代理工厂类
class ProxyFactory
{
	public static Object getProxy(Object target)
	{
		MyInvocationHandler handler=new MyInvocationHandler();
		handler.setTarget(target);
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),handler);
	}
}
public class Test9
{
	public static void main(String[] args)
	{
		 Dog target=new GunDog();
		 Dog d=(Dog)ProxyFactory.getProxy(target);
		 d.run();
	}
}