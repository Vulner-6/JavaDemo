package com.example.javademo.io;

import java.io.File;

/**
 * 练习：使用递归打印多级目录
 */
public class Example_printMoreDir
{
    public static void main(String[] args)
    {
        Example_printMoreDir epmd=new Example_printMoreDir();
        File file=new File("D:\\编程开发资源");
        epmd.printAllFiles(file);
    }

    public void printAllFiles(File file)
    {
        File[] files=file.listFiles();
        for(File f: files)
        {
            System.out.println(f.getAbsolutePath());
            if(f.isDirectory())
            {
                printAllFiles(f);
            }
        }
    }
}
