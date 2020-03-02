package com.example.javademo.io;

import java.io.File;
import java.io.IOException;

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
        fd.createNewFile();
        fd.useMkdir();
        fd.deleteFile();
        fd.listDir();
        fd.recursive(1);
        fd.recursiveSum(1,0);
        fd.recursiveMultiplication(1,3,1);
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

    /**
     * File类的方法：public boolean createNewFile(String path)
     * 1.只能创建文件
     * 2.若传入的路径，已经存在该文件，则返回false；否则创建该文件，并返回true;
     */
    public void createNewFile()
    {
        File file=new File("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo\\io\\results" +
                "\\test.txt");
        try
        {
            boolean result=file.createNewFile();
            System.out.println("createNewFile创建新文件，是否成功："+result);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * File类中的 mkdir() 和 mkdirs()
     * 创建单个空文件夹  mkdir(),若文件夹已经存在，创建失败，返回false；若文件夹不存在，创建成功，返回true;
     * 创建多个个空文件夹  mkdirs(),若文件夹已经存在，创建失败，返回false；若文件夹不存在，创建成功，返回true;
     * 若传给File的路径不存在，则全都返回false
     * 这两个方法只能创建文件夹，不能创建文件！！！
     */
    public void useMkdir()
    {
        File f1=new File("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo\\io\\results" +
                "\\testMkdir01");
        System.out.println("mkdir创建单个空文件夹是否成功："+f1.mkdir());
        File f2=new File("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo\\io\\results" +
                "\\testMkdir02\\testMkdir03");
        System.out.println("mkdirs()创建多个个空文件夹是否成功："+f2.mkdirs());
        File f3=new File("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo\\io\\results" +
                "\\testMkdirFile.txt");
        System.out.println("尝试利用mkdir创建文件，结果估计是文件名命名的文件夹："+f3.mkdir());
    }

    /**
     * File类中的delete()方法，删除传入的文件路径指定的文件。
     * 删除文件，不走回收站，删除需谨慎！！！
     * 删除成功返回true，否则返回失败。
     */
    public void deleteFile()
    {
        File file=new File("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo\\io\\results" +
                "\\testMkdirFile.txt");
        System.out.println("delete()删除传入的指定路径的文件或文件夹，是否成功删除："+file.delete());
    }

    /**
     * File类中，还有遍历目录/遍历文件的方法
     * public String[] list(); 返回一个String[]数组，表示该文件目录下的所有文件夹和文件（包括隐藏起来的文件或文件夹）
     *   1.若传入的文件目录路径不存在，则抛出空指针异常！
     *   2.若传入的不是文件目录，也会抛出空指针异常；
     * public String[]
     */
    public void listDir()
    {
        File file=new File("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo\\io\\results");
        String[] allFiles=file.list();
        for(String fileName:allFiles)
        {
            System.out.println("遍历出来的文件或文件夹："+fileName);
        }

        File[] files=file.listFiles();
        for(File f:files)
        {
            System.out.println("获取到的File类的相对路径："+f.getPath());
        }
    }

    /**
     * 递归
     *     直接递归：方法中调用自己方法
     *     间接递归：方法中调用其他方法
     * 递归有一定的次数限制，次数太多，就会导致内存堆栈溢出。因此使用递归的时候，一定要在一定次数内，让递归停下来；
     * 构造方法中，禁止使用递归，个人认为会导致无限循环。
     */
    public void recursive(Integer i)
    {
        System.out.println("第"+i+"次递归");
        Integer tempNum=i+1;
        if(tempNum<500)
        {
            recursive(tempNum);
        }
        else
        {
            System.out.println("停下递归了，此时已经递归了"+tempNum+"次数");
        }
    }

    /**
     * 练习：递归计算1-100的和
     * @param num
     * @param sum
     */
    public void recursiveSum(Integer num,Integer sum)
    {
        if(num==101)
        {
            System.out.println("递归计算1-100的和为："+sum);
        }
        else
        {
            sum=sum+num;
            num=num+1;
            recursiveSum(num,sum);
        }
    }

    /**
     * 练习：使用递归计算阶乘
     * @param start
     * @param stop
     * @param result
     */
    public void recursiveMultiplication(Integer start,Integer stop,Integer result)
    {
        if(start==(stop+1))
        {
            System.out.println("阶乘的结果为："+result);
        }
        else
        {
            result=result*start;
            start=start+1;
            recursiveMultiplication(start,stop,result);
        }
    }
}
