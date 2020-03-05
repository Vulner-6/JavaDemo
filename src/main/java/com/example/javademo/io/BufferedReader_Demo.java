package com.example.javademo.io;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReader_Demo
{
    public static void main(String[] args) throws Exception
    {
        FileReader fr=new FileReader("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo\\io\\results\\testMkdir01\\bufferedMore.txt");
        BufferedReader_Demo brd=new BufferedReader_Demo();
        brd.bufferedRead(fr);
    }

    /**
     * 字符读取缓冲流
     */
    public void bufferedRead(FileReader fr) throws Exception
    {
        BufferedReader br=new BufferedReader(fr);
        String oneLine=br.readLine();//读取一行，还有好几钟读取方法
        System.out.println("读取的内容是："+oneLine);
    }
}
