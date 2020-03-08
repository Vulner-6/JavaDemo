package com.example.javademo.io;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 字节读取转换流，字节转向字符的桥梁
 * 读取的编码方式如果和当初存储的不一样，会报错。
 */
public class InputStreamReader_Demo
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream fis=new FileInputStream("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo\\io\\results\\testMkdir02\\testMkdir03\\outputStreamWriter.txt");
        InputStreamReader_Demo isrd=new InputStreamReader_Demo();
        isrd.readGBK(fis);
    }

    /**
     * 按指定编码读取文本文件内容
     * @param fis
     * @throws Exception
     */
    public void readGBK(FileInputStream fis) throws Exception
    {
        InputStreamReader isr=new InputStreamReader(fis,"GBK");
        int len=0;
        while ((len=isr.read())!=-1)
        {
            System.out.println((char)len);
        }
    }
}
