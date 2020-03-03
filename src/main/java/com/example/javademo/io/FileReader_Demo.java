package com.example.javademo.io;

import java.io.File;
import java.io.FileReader;

/**
 * 字符输入流
 */
public class FileReader_Demo
{
    public static void main(String[] args)
    {
        File file=new File("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo\\io\\results\\test.txt");
        FileReader_Demo frd=new FileReader_Demo();
        frd.readOneChar(file);
        frd.readMoreChar(file);
    }

    /**
     * 读取单个字符
     * @param file
     */
    public void readOneChar(File file)
    {
        try
        {
            FileReader fr=new FileReader(file);
            int singleCh=fr.read();
            System.out.println("读取的单个字符是："+(char)singleCh);
            fr.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 每次读取1024个字符
     * @param file
     */
    public void readMoreChar(File file)
    {
        try
        {
            FileReader fr=new FileReader(file);
            char[] chars=new char[1024];
            int len=0;
            while ((len=fr.read(chars))!=-1)
            {
                System.out.println("一次性读取的多个字符结果是："+new String(chars,0,len));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
