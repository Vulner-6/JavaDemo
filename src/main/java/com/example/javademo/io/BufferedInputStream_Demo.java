package com.example.javademo.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStream_Demo
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream fis=new FileInputStream("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example" +
                "\\javademo\\io\\results\\testMkdir01\\bufferedWriteTest.txt");
        BufferedInputStream_Demo bisd=new BufferedInputStream_Demo();
        bisd.bufferedReadOneByte(fis);

        FileInputStream fis2=new FileInputStream("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example" +
                "\\javademo\\io\\results\\testMkdir01\\bufferedMore.txt");
        bisd.bufferedReadMoreBytes(fis2);
    }

    /**
     * 使用BufferedInputStream读取单个字符
     * @param fis
     * @throws Exception
     */
    public void bufferedReadOneByte(FileInputStream fis) throws Exception
    {
        BufferedInputStream bis=new BufferedInputStream(fis);
        int len=bis.read();
        System.out.println("BufferedInputStream读取到的单个字符是："+(char)len);
        bis.close();
    }

    /**
     * 使用BufferedInputStream读取多个字符
     * @param fis
     * @throws Exception
     */
    public void bufferedReadMoreBytes(FileInputStream fis) throws Exception
    {
        BufferedInputStream bis=new BufferedInputStream(fis);
        byte[] bytes=new byte[1024];
        int len=bis.read(bytes);
        System.out.println("BufferedInputStream读取的一串字符是："+new String(bytes));
        bis.close();
    }
}
