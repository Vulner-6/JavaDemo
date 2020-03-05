package com.example.javademo.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Example_BufferedCopy
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream fis=new FileInputStream("C:\\Users\\Vulner-6\\Pictures\\test.png");
        FileOutputStream fos=new FileOutputStream("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example" +
                "\\javademo\\io\\results\\testMkdir02\\testMkdir03\\testBufferedCopy.png",true);
        Example_BufferedCopy ebc=new Example_BufferedCopy();
        ebc.bufferedCopy(fis,fos);
    }

    /**
     * 利用字节缓冲流，实现文件的复制，效率很高
     */
    public void bufferedCopy(FileInputStream fis, FileOutputStream fos) throws Exception
    {
        long start=System.currentTimeMillis();
        BufferedInputStream bis=new BufferedInputStream(fis);
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        int len=0;
        byte[] bytes=new byte[1024];
        while ((len=bis.read(bytes))!=-1)
        {
            bos.write(bytes);
        }
        bos.close();
        bis.close();
        long stop=System.currentTimeMillis();
        System.out.println("复制文件，总共耗时："+(stop-start)+"毫秒");
    }
}
