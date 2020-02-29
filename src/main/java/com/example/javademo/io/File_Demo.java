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
        fd.printPathSeparator();
        fd.printFilePath();
        fd.getFileInfo();
        fd.judgeFile();
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
    public void printPathSeparator()
    {
        //windows分隔符是"\"正斜杠
        String path1= File.separator+"program"+File.separator+"project";
        String path2=File.separator+"program"+File.separator+"project"+File.pathSeparator+"test"+File.separator+
                "hello"+File.pathSeparator;
        System.out.println("使用File.separator和File.pathSeparator这两个静态方法作为路径分隔符：\n"+path1+"\r\n"+path2);
    }

    /**
     * File的构造方法，路径可以是存在的，也可以是不存在的
     * 路径可以是相对路径，也可以是绝对路径
     * 路径可以是文件结尾，也可以是文件夹结尾
     * File(String path)
     * File(String parent,String child)    //父路径，子路径，更加灵活。并且父路径里可以使用File中的一些方法。
     */
    public void printFilePath()
    {
        String path1="D:\\parent\\";
        String path2="hello.txt";
        File file1=new File(path1);
        File file2=new File(path1,path2);
        System.out.println("File()传入单个参数："+file1);
        System.out.println("File()传入父参数和子参数"+file2);
    }

    /**
     * File类的获取功能
     * 1.获取File绝对路径字符串
     * public String getAbsolutePath()
     * 2.将此File转换成路径字符串
     * public String getPath()
     * 3.返回由此File表示的文件或目录名称
     * public String getName()
     * 4.返回由此File表示的文件的长度。文件夹没有大小，所以不能对文件夹使用,会出现不准确的字节。如果文件不存在，返回大小就是0；
     * public Long getLength()
     */
    public void getFileInfo()
    {
        File f1=new File("D:\\V2ray\\config.json");
        File f2=new File("c.txt");
        //打印f1的绝对路径
        System.out.println("getAbsolutePath方法打印f1的绝对路径："+f1.getAbsolutePath());
        //打印f2的绝对路径
        System.out.println("getAbsolutePath方法打印f2的绝对路径："+f2.getAbsolutePath());
        //利用getPath()方法，打印f1,f2的路径
        System.out.println("getPath方法打印f1的绝对路径："+f1.getPath());
        System.out.println("getPath方法打印f2的绝对路径："+f2.getPath());
        //利用getName，返回File构造方法中传递字符串的结尾部分
        System.out.println("getName方法打印f1的绝对路径："+f1.getName());
        System.out.println("getName方法打印f2的绝对路径："+f2.getName());
        //打印获取的文件大小
        System.out.println("这是存在的文件夹的大小："+f1.length());
        System.out.println("这是不存在的文件的大小："+f2.length());

    }

    /**
     * 判断File是否存在 exits()
     * 判断File是否是个目录  isDirectory()
     * 判断File是否是个文件  isFile()
     */
    public void judgeFile()
    {
        File f1=new File("D:\\a\\b\\c.txt");
        File f2=new File("D:\\V2ray\\config.json");
        if(f1.exists())
        {
            System.out.println("我的电脑中不存在这个路径："+f1.getAbsolutePath());
            System.out.println("这是一个目录："+f1.isDirectory());
            System.out.println("这是一个文件："+f1.isFile());
        }
        else
        {
            System.out.println("我的电脑中不存在这个路径："+f1.getAbsolutePath());
            System.out.println("这是一个目录："+f1.isDirectory());
            System.out.println("这是一个文件："+f1.isFile());
        }
        if(f2.exists())
        {
            System.out.println("我的电脑中存在这个路径："+f2.getAbsolutePath());
            System.out.println("这是一个目录："+f2.isDirectory());
            System.out.println("这是一个文件："+f2.isFile());
        }
        else
        {
            System.out.println("我的电脑中存在这个路径："+f2.getAbsolutePath());
            System.out.println("这是一个目录："+f2.isDirectory());
            System.out.println("这是一个文件："+f2.isFile());
        }
    }
}
