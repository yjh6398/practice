package com.itheima.test;

import java.util.HashMap;
import java.util.Map;

/*
 * 简单工厂模式
 */
public class Test_1 {
	
}
//创建一个接口
interface Shape
{
	void draw();
}
//创建接口的实现类
class Rectangle implements Shape
{
	public void draw()
	{
		System.out.println("调用Rectangle类中的draw()方法");
	}
}
class Square implements Shape
{
	public void draw()
	{
		System.out.println("调用Square类中的draw()方法");
	}
}
class Circle implements Shape
{
	public void draw()
	{
		System.out.println("调用Circle类中的draw()方法");
	}
}
//创建工厂类
class ShapeFactory
{
	public Shape getShape(String shapeType)
	{
		if(shapeType==null)
			return null;
		if(shapeType.equalsIgnoreCase("Circle"))
			return new Circle();
		if(shapeType.equalsIgnoreCase("Rectangle"))
			return new Rectangle();
		if(shapeType.equalsIgnoreCase("Square"))
			return new Square();
		return null;
	}
}