package com.itheima.test;

import java.util.HashMap;
import java.util.Map;

/*
 * �򵥹���ģʽ
 */
public class Test_1 {
	
}
//����һ���ӿ�
interface Shape
{
	void draw();
}
//�����ӿڵ�ʵ����
class Rectangle implements Shape
{
	public void draw()
	{
		System.out.println("����Rectangle���е�draw()����");
	}
}
class Square implements Shape
{
	public void draw()
	{
		System.out.println("����Square���е�draw()����");
	}
}
class Circle implements Shape
{
	public void draw()
	{
		System.out.println("����Circle���е�draw()����");
	}
}
//����������
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