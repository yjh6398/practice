package com.itheima.test;
/*
 * װ����ģʽ
 * ʹ��RedShapeDecorator��װ��Shape����
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
//�����ӿ�
interface Shape1
{
	public void draw();
}
//����ʵ�ֽӿڵ�ʵ����
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
//����ʵ����Shape�ӿڵĳ���װ����
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
//��չShapeDecorator���ʵ��װ����
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


