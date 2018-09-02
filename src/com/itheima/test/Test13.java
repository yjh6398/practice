package com.itheima.test;
/*
 * 浅克隆和深克隆
 */
public class Test13{
	public static void main(String[] args)
	{
		Teacher t=new Teacher();
		Student s1=new Student(t,"yjh",18);
		t.setAge(48);
		t.setName("z");
		Student s2=(Student)s1.clone();
		System.out.println(s2.getName());
		s2.setName("shd");
		System.out.println(s2.getName());
		System.out.println(s1.getName());
		System.out.println(s2.getT().getAge());
		s2.getT().setAge(89);
		System.out.println(s1.getT().getAge());
		System.out.println(s2.getT().getAge());
	}
}
class Student implements Cloneable
{
	private Teacher t;
	private String name;
	private int age;
	public Student(Teacher t,String name,int age)
	{
		this.age=age;
		this.name=name;
		this.t=t;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Teacher getT() {
		return t;
	}
	public void setT(Teacher t) {
		this.t = t;
	}
	public Object clone()
	{
		Student o=null;
		try {
			o=(Student)super.clone();
			o.t=(Teacher)t.clone();
		} catch (CloneNotSupportedException e) 
		{
			e.printStackTrace();
		}
		return o;
	}
}
class Teacher implements Cloneable
{
	private Student s;
	private String name;
	private int age;
	public Student getS() {
		return s;
	}
	public void setS(Student s) {
		this.s = s;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Object clone()
	{
		Teacher o=null;
		try {
			o=(Teacher)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}
}
