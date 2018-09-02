package com.itheima.test;
/*
 * 装饰器模式
 * 使用RedShapeDecorator来装饰Shape对象
 */
public class Test28
{
   public static void main(String[] args)
   {
	   Shape1 circle=new Circle1();
	   Shape1 redCircle = new RedShapeDecorator(new Circle1());
	   Shape1 redRectangle = new RedShapeDecorator(new Rectangle1());
	   System.out.println("Circle with normal border");
	   circle.draw();
	   System.out.println("\nCircle of red border");
	   redCircle.draw();
	   System.out.println("\nRectangle of red border");
	   redRectangle.draw();
   }
}
//创建接口
interface Shape1
{
	public void draw();
}
//创建实现接口的实体类
class Rectangle1 implements Shape1
{
	public void draw()
	{
		System.out.println("Shape:Rectangle");
	}
}
class Circle1 implements Shape1
{
	public void draw()
	{
		System.out.println("Shape:Circle");
	}
}
//创建实现了Shape接口的抽象装饰类
abstract class ShapeDecorator implements Shape1
{
	protected Shape1 decoratedShape;
	public ShapeDecorator(Shape1 decoratedShape)
	{
		this.decoratedShape=decoratedShape;
	}
	public void draw()
	{
		decoratedShape.draw();
	}
}
//扩展ShapeDecorator类的实体装饰类
class RedShapeDecorator extends ShapeDecorator
{
	public RedShapeDecorator(Shape1 decoratedShape)
	{
		super(decoratedShape);
	}
	public void draw()
	{
		decoratedShape.draw();
		setRedBorder(decoratedShape);
		
	}
	private void setRedBorder(Shape1 decoratedShape)
	{
		System.out.println("Border Color:Red");
	}
}


