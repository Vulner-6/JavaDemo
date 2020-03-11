package com.example.javademo.internet;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Tcp客户端
 * Socket类
 *   构造方法：Socket socket=new Socket(String host, int port);
 *   方法：
 *       获取网络字节输出流（向服务器端发数据）socket.get
 */
public class TcpClient
{
    public static void main(String[] args) throws Exception
    {
        //向服务器端发送三次握手，如果服务器端没启动，这里就会抛出异常
        Socket socket=new Socket("127.0.0.1",65535);
        //获取网络字节输出流，客户端就可以利用网络字节输出流向服务器端发送字节流信息
        OutputStream os=socket.getOutputStream();
        os.write("你好，世界！".getBytes());

        //获取网络字节输入流，打印从服务器端返回的消息
        InputStream is=socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));

        //释放资源
        socket.close();
    }
}
