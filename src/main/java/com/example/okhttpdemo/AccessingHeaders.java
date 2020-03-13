package com.example.okhttpdemo;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccessingHeaders
{
    //声明OkHttpClient，一般建议用final，声明一个就可以了。
    private final OkHttpClient client = new OkHttpClient();

    public void run() throws Exception
    {
        //构造请求包，可以添加自定义的头部
        Request request = new Request.Builder()
                .url("https://api.github.com/repos/square/okhttp/issues")
                .header("User-Agent", "OkHttp Headers.java")
                .addHeader("Accept", "application/json; q=0.5")
                .addHeader("Accept", "application/vnd.github.v3+json")
                .build();
        //同步方式发送GET请求包
        try (Response response = client.newCall(request).execute()) {
            //如果返回包的状态不是200
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            //打印指定返回包头部指定键的值
            System.out.println("Server: " + response.header("Server"));
            System.out.println("Date: " + response.header("Date"));
            System.out.println("Vary: " + response.headers("Vary"));
        }
    }
}
