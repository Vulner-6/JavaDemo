package com.example.javademo.io;

import java.io.File;
import java.io.FileWriter;

/**
 * 字符输出流使用步骤
 * 1.创建FileWriter对象，构造方法中绑定要写入数据的目的地
 * 2.使用FileWriter对象中的write()方法，将数据写入到内存缓冲区中！（注意，不是直接写到硬盘上，这是字符转换成字节的过程）
 * 3.使用FileWriter对象中的flush()方法，把内存缓冲区中的数据，刷新到文件中
 * 4.使用FileWriter对象中的close()方法，关闭字符输出流
 */
public class FileWriter_Demo
{
    public static void main(String[] args)
    {
        File file=new File("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo\\io\\results" +
                "\\test.txt");
        FileWriter_Demo fwd=new FileWriter_Demo();
        fwd.writeOneChar(file);
        fwd.writeMoreChar(file);
    }

    /**
     * 利用字符输出流，写入单个字符到指定目标文件中
     * @param file
     */
    public void writeOneChar(File file)
    {
        try
        {
            FileWriter fw=new FileWriter(file);
            char ch='P';
            fw.write(ch);   //将字符写入到内存缓冲区
            fw.flush();   //刷新缓冲区，写入到指定的目的地文件中
            fw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 一次性写入多个字符
     * @param file
     */
    public void writeMoreChar(File file)
    {
        try
        {
            FileWriter fw=new FileWriter(file);
            char[] chars="将字符串转换成字符数组，使用toCharArray".toCharArray();
            fw.write(chars);
            fw.flush();
            fw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
