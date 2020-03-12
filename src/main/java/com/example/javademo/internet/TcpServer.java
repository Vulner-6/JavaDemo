package com.example.javademo.internet;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务端
 * ServerSocket类
 *   构造方法：ServerSocket serverSocket=new ServerSocket(int port);
 *   我不知道为什么不能用while循环一直读取网络字节输入流的内容。一旦这么做，就会导致服务端的输出流无法传递到客户端。
 */
public class TcpServer
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket serverSocket=new ServerSocket(65535);
        //获取客户端发过来的TCP三次握手请求
        Socket socket =serverSocket.accept();
        //获取网络字节输入流，并打印出来
        InputStream is=socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));

        //返回信息给客户端
        OutputStream os=socket.getOutputStream();
        os.write("服务端收到了，谢谢".getBytes());
        //关闭socket流
        socket.close();
        serverSocket.close();
    }
}
