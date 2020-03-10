package com.example.javademo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * 练习：序列化集合
 */
public class Example_Serializable
{
    public static void main(String[] args) throws Exception
    {
        Example_Serializable es=new Example_Serializable();
        ArrayList<Person_Demo> person_demos=new ArrayList<Person_Demo>();
        person_demos.add(new Person_Demo("老大",24));
        person_demos.add(new Person_Demo("老二",18));
        FileOutputStream fos=new FileOutputStream("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example" +
                "\\javademo\\io\\results\\serializable.txt");
        es.objectOutputStreamStart(fos,person_demos);
        FileInputStream fis=new FileInputStream("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example" +
                "\\javademo\\io\\results\\serializable.txt");
        es.objectInputStreamStart(fis);
    }

    /**
     * 将数组里面的所有对象，都序列化存到文件中
     * @param fos
     * @param list
     * @throws Exception
     */
    public void objectOutputStreamStart(FileOutputStream fos, ArrayList<Person_Demo> list) throws Exception
    {
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.flush();
        oos.close();
    }

    /**
     * 将文件中存储的序列化数组反序列化出来，并打印重写的toString()方法
     * @param fis
     * @throws Exception
     */
    public void objectInputStreamStart(FileInputStream fis) throws Exception
    {
        ObjectInputStream ois=new ObjectInputStream(fis);
        //利用ObjectInputStream中的readObject()方法，可以读取文件中保存的集合
        ArrayList<Person_Demo> list2=(ArrayList<Person_Demo>)ois.readObject();
        for(Person_Demo p:list2)
        {
            System.out.println(p.toString());
        }
        ois.close();
    }

}
