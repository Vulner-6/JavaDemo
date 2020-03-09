package com.example.javademo.io;

import java.io.Serializable;

/**
 * 这个类用于测试序列化。
 * 要被序列化的类，必须实现Serializable
 */
public class Person_Demo implements Serializable
{
    public String name;
    private int age;

    public Person_Demo(String name,int age)
    {
        this.name=name;
        this.age=age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Person_Demo{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
