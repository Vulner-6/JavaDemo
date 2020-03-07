package com.example.javademo.io;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * 字节输出转换流，是字节转换到字符的桥梁。
 * 可以自己设置转换编码为gbk或者utf-8等其他的编码。
 */
public class OutputStreamWriter_Demo
{
    public static void main(String[] args) throws Exception
    {
        FileOutputStream fos=new FileOutputStream("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example" +
                "\\javademo\\io\\results\\testMkdir02\\testMkdir03\\outputStreamWriter.txt");
        OutputStreamWriter_Demo oswd=new OutputStreamWriter_Demo();
        oswd.writeGBK(fos);
    }

    /**
     * 按照GBK编码写入字符到指定文件
     * @param fos
     * @throws Exception
     */
    public void writeGBK(FileOutputStream fos) throws Exception
    {
        OutputStreamWriter osw=new OutputStreamWriter(fos,"gbk");
        osw.write("你好");
        osw.flush();
        osw.close();
    }
}
