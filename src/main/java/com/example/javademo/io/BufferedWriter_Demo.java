package com.example.javademo.io;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class BufferedWriter_Demo
{
    public static void main(String[] args) throws Exception
    {
        BufferedWriter_Demo bwd=new BufferedWriter_Demo();
        FileWriter fw=new FileWriter("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo" +
                "\\io\\results\\testMkdir01\\bufferedWriter.txt");
        bwd.bufferedWriterUse(fw);
    }

    /**
     * 写入字符串到指定文本文件
     * @param fw
     * @throws Exception
     */
    public void bufferedWriterUse(FileWriter fw) throws Exception
    {
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write("使用BufferedWriter写入一句话");
        bw.flush();
        bw.close();
    }
}
