package com.example.javademo.io;

import java.io.File;

/**
 * 练习：打印指定目录下，以.java结尾的文件
 */
public class Example_SearchFile
{
    public static void main(String[] args)
    {
        File file=new File("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo\\io");
        Example_SearchFile esf=new Example_SearchFile();
        esf.search(file,".java");
    }

    public void search(File file, String keywords)
    {
        File[] files=file.listFiles();
        for(File f:files)
        {
            //只打印包含关键字的文件或目录
            if(f.getName().indexOf(keywords)!=-1)
            {
                System.out.println(f.getAbsolutePath());
            }
            //如果是目录，就继续递归查询
            if(f.isDirectory())
            {
                search(f,keywords);
            }
        }
    }
}
