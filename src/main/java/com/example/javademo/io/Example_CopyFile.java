package com.example.javademo.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 练习：文件的复制
 */
public class Example_CopyFile
{
    public static void main(String[] args) throws Exception
    {
        String sourcePath="E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo\\io" +
                "\\resource\\appendByteResult.txt";
        String targetPath="E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo\\io" +
                "\\resource\\beCopiedFile.txt";
        Example_CopyFile ecf=new Example_CopyFile();
        ecf.copyFile(sourcePath,targetPath);
    }

    public void copyFile(String sourcPath,String targetPath) throws Exception
    {
        FileInputStream fis=new FileInputStream(sourcPath);
        FileOutputStream fos=new FileOutputStream(targetPath);
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len=fis.read(bytes))!=-1)
        {
            fos.write(bytes);
        }
        //释放资源,先关闭写的，后关闭读的。
        fos.close();
        fis.close();

    }
}
