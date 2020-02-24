package com.example.javademo.io;

import java.io.File;

/**
 * Java把电脑中的文件/文件夹封装成一个File类，因此可以通过File类对文件/文件夹进行操作
 * File类的功能：
 *     获取一个文件/文件夹
 *     获取一个文件的大小
 *     判断一个文件/文件夹是否存在
 *     创建一个文件/文件夹
 *     删除一个文件/文件夹
 *     遍历文件夹
 */
public class File_Demo
{
    public static void main(String[] args)
    {
        File_Demo fd=new File_Demo();
        fd.printPath();
    }

    /**
     *为了写的程序，再进行文件操作时，可以在windows/linux平台上都能无BUG运行，所以必须会分隔符
     * static String pathSeparator    //与系统有关的路径分隔符
     * static char pathSeparatorChar
     * static String separator    //与系统有关的默认名称分隔符
     * static char separatorChar
     * 技巧：
     *     操作文件时，操作路径不能写死，因此需要熟练使用上面的分隔符
     */
    public void printPath()
    {
        //windows分隔符是"\"正斜杠
        String path1= File.separator+"program"+File.separator+"project";
        String path2=File.separator+"program"+File.separator+"project"+File.pathSeparator+"test"+File.separator+
                "hello"+File.pathSeparator;
        System.out.println(path1+"\r\n"+path2);
    }
}
