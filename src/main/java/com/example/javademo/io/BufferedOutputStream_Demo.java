package com.example.javademo.io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStream_Demo
{
    public static void main(String[] args) throws Exception
    {
        //字节输出流一旦关闭了，再写入就会抛出异常。因此，单个字节输出流对象，一定要确保不再使用后，再进行关闭。
        FileOutputStream fos=new FileOutputStream("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example" +
                "\\javademo\\io\\results\\testMkdir01\\bufferedWriteTest.txt",true);
        BufferedOutputStream_Demo bosd=new BufferedOutputStream_Demo();
        bosd.bufferedWriteOneByte(fos);
        FileOutputStream fos2=new FileOutputStream("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example" +
                "\\javademo\\io\\results\\testMkdir01\\bufferedMore.txt",true);
        bosd.bufferedWriteMoreBytes(fos2);

    }

    /**
     * 利用BufferedOutputStream写入单个字符到目标文件
     * @param fos
     * @throws Exception
     */
    public void bufferedWriteOneByte(FileOutputStream fos) throws Exception
    {
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        bos.write(97);
        bos.close();

    }

    public void bufferedWriteMoreBytes(FileOutputStream fos) throws Exception
    {
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        bos.write("啊啊啊啊啊".getBytes());
        bos.close();
    }
}
