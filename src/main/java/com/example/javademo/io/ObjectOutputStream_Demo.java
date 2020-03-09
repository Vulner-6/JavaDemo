package com.example.javademo.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * 将类的实例进行序列化存到txt文件中
 */
public class ObjectOutputStream_Demo
{
    public static void main(String[] args) throws Exception
    {
        FileOutputStream fos=new FileOutputStream("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example" +
                "\\javademo\\io\\results\\objectOutputStream.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(new Person_Demo("小明",12));
        oos.flush();
        oos.close();
    }
}
