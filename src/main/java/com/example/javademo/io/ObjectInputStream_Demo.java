package com.example.javademo.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * 将存储在txt文件中的序列化对象，反序列化取出来
 */
public class ObjectInputStream_Demo
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream fis=new FileInputStream("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo\\io\\results\\objectOutputStream.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        System.out.println(ois.readObject());
        ois.close();
    }
}
