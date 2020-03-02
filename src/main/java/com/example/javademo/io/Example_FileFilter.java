package com.example.javademo.io;

import java.io.File;

/**
 * 练习：使用文件过滤，打印指定目录下的所有.java结尾的文件
 */
public class Example_FileFilter
{
    public static void main(String[] args)
    {
        Example_FileFilter eff=new Example_FileFilter();
        File file=new File("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo");
        eff.printFile(file);
    }

    public void printFile(File file)
    {
        //这里获取的，都是accept()方法重写过，返回true的File对象
        //因此，这里不仅有.java结尾的文件，还有文件夹
        File[] files=file.listFiles(new FileFilter_Demo());
        for(File f:files)
        {
            if(f.isDirectory())
            {
                printFile(f);
            }
            else
            {
                System.out.println("java文件有："+f.getAbsolutePath());
            }
        }

    }
}
