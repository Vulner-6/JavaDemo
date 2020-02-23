package com.example.javademo.io;

import java.io.FileOutputStream;

/**
 * FileOutputStream 继承自 OutputStream
 * 作用：
 *     将内存中的数据写入到硬盘文件中
 * 构造方法：
 *     FileOutputStream(File file)
 *     FileOutputStream(String fileName)
 *     FileOutputStream(File file, boolean append)
 *     FileOutputStream(String fileName, boolean append)
 * 构造方法作用：
 *     1.创建一个FileOutputStream对象
 *     2.会根据构造方法中传递的文件/文件路径，创建一个空文件
 *     3.会把FileOutputStream对象指向创建好的文件
 * 使用步骤：
 *     1.创建一个FileOutputStream对象，构造方法中传递数据的目的地
 *     2.利用FileOutputStream对象中的write()方法，写入数据到文件中
 *     3.释放资源（流使用会占用一定的内存，使用完毕后要清空内存，提高程序效率）
 */
public class FileOutputStream_Demo
{
    //运行各种demo的入口
    public static void main(String[] args) throws Exception
    {
        FileOutputStream_Demo fosDemo=new FileOutputStream_Demo();
        //尝试写入一个字节到指定文件
        fosDemo.writeBytes();
        //尝试追加数据到已存在的文件
        fosDemo.appendBytes();

    }

    /**
     * 写入一个字节到指定路径,如果已经有了该文件，就会覆盖重写
     * @throws Exception
     */
    public void writeBytes() throws Exception
    {
        FileOutputStream fos=new FileOutputStream("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example" +
                "\\javademo\\io\\writeByteResult.txt");
        fos.write(97);  //97对应的字符是a，输入的是正数，默认查询ascii码
        byte[] bytes={98,99,100,-101,-102};
        fos.write(bytes);  //如果写入的是负数，那么会和后面一个字节组成中文，查询gbk编码

        //写入字符串的方法
        String outputStr="你好，世界！";
        byte[] strTobytes=outputStr.getBytes();
        fos.write(strTobytes);
        fos.close();
    }

    /**
     * 如果不存在已有文件，就会自动创建文件并写入
     * 如果存在已有文件，就会追加
     * 换行符：
     *   windows:"\r\n"
     *   linux:"/n"
     *   mac:"/r"
     * @throws Exception
     */
    public void appendBytes() throws Exception
    {
        String fosPath="E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example" +
                "\\javademo\\io\\appendByteResult.txt";
        FileOutputStream fos=new FileOutputStream(fosPath,true);
        byte[] bytes="又追加了一句\r\n".getBytes();
        fos.write(bytes);
        fos.close();
    }
}
