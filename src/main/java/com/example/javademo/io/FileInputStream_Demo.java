package com.example.javademo.io;

import java.io.FileInputStream;

/**
 * FileInputStream 继承自 InputStream
 * 作用：
 *     把硬盘中的文件读取到内存中使用
 * 构造方法：
 *     FileInputStream(File file)
 *     FileInputStream(String readName)
 * 使用步骤：
 *     1.创建FileInputStream对象，构造方法中绑定要读取的数据源
 *     2.使用FileInputStream对象中的read()方法，读取文件
 *     3.释放资源，关闭数据流
 * 读取方法：
 *     int read()    //每次从输入流中只读取一个字节
 *     int read(byte[] bytes)   //从输入流中读取bytes长度的字节，并存储到bytes数组中
 */
public class FileInputStream_Demo
{
    public static void main(String[] args) throws Exception
    {
        FileInputStream_Demo fisDemo=new FileInputStream_Demo();
        //只读取一个字节
        fisDemo.readOneByte();
        //读取1024个长度的字节
        fisDemo.readMoreBytes();
    }

    /**
     * 每次只读取一个字节
     * @throws Exception
     */
    public void readOneByte() throws Exception
    {
        String readPath="E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo\\io" +
                "\\resource\\writeByteResult.txt";
        FileInputStream fis=new FileInputStream(readPath);
        //int read()方法，每次只读取一个字节
        while (true)
        {
            int result=fis.read();
            if(result==-1)
            {
                System.out.println("文件读取结束，因为read()返回值为-1");
                fis.close();
                break;
            }
            else
            {
                System.out.println(result);   //97  对应的是 a
            }
        }




    }

    /**
     * 每次读取指定长度的 byte[] bytes
     * 一般定义读取的长度为1024字节的整数倍
     */
    public void readMoreBytes() throws Exception
    {
        String readPath="E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo\\io" +
                "\\resource\\writeByteResult.txt";
        FileInputStream fis=new FileInputStream(readPath);
        byte[] bytes=new byte[1024];
        int len=0;
        while ((len=fis.read(bytes))!=-1)
        {
            //只转换有效的字符，虽然每次读取1024个字节，但是可能目标总共就4个字节大小。
            //new String(byte[] bytes, int offset, int len)  //
            System.out.println(new String(bytes,0,len));
        }

    }
}
