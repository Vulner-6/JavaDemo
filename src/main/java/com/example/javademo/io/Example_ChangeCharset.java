package com.example.javademo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 练习：改变文件编码方式
 */
public class Example_ChangeCharset
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream fis=new FileInputStream("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo\\io\\results\\testMkdir02\\testMkdir03\\outputStreamWriter.txt");
        FileOutputStream fos=new FileOutputStream("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example" +
                "\\javademo\\io\\results\\testMkdir02\\testMkdir03\\changeUtf8.txt");
        Example_ChangeCharset ecc=new Example_ChangeCharset();
        ecc.changeCharsetUtf8(fis,fos);

    }

    /**
     * 将gbk编码的文件，转换成utf8
     * @param fis
     * @param fos
     * @throws Exception
     */
    public void changeCharsetUtf8(FileInputStream fis, FileOutputStream fos) throws Exception
    {
        InputStreamReader isr=new InputStreamReader(fis,"gbk");
        OutputStreamWriter osw=new OutputStreamWriter(fos,"utf8");
        char[] chars=new char[1024];
        int len=0;
        while ((len=isr.read(chars))!=-1)
        {
            osw.write(chars);
            osw.flush();
        }
        osw.close();
        isr.close();
    }
}
