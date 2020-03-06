package com.example.javademo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class Example_PaiXu
{
    public static void main(String[] args) throws Exception
    {
        FileReader fr=new FileReader("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo\\io\\results\\paixuqian.txt");
        FileWriter fw=new FileWriter("E:\\Programming\\Projects\\JavaDemo\\src\\main\\java\\com\\example\\javademo" +
                "\\io\\results\\paixuhou.txt");
        Example_PaiXu epx=new Example_PaiXu();
        epx.paiXu(fr,fw);
    }

    /**
     * 使用字符缓冲流实现文本排序
     */
    public void paiXu(FileReader fr, FileWriter fw) throws Exception
    {
        BufferedReader br=new BufferedReader(fr);
        String tempRead="";
        HashMap<String,String> hashMap=new HashMap<String,String>();
        while ((tempRead=br.readLine())!=""&&tempRead!=null)
        {
            //分割读取到的字符串，以键值对方式存到hashMap中
            String[] str =tempRead.split("\\.");
            hashMap.put(str[0],str[1]);
        }
        //当全都读取结束后，将hashMap里面的键值对都输出到指定文本中
        BufferedWriter bw=new BufferedWriter(fw);
        for(String key:hashMap.keySet())
        {
            bw.write(key+"."+hashMap.get(key));
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
