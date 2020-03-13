package com.example.okhttpdemo;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class SynchronousGet
{
    //声明OkHttpClient客户端
    private final OkHttpClient client = new OkHttpClient();

    public void run() throws Exception
    {
        //定义请求包
        Request request = new Request.Builder()
                .url("https://publicobject.com/helloworld.txt")
                .build();
        //同步方式发送请求包
        try (Response response = client.newCall(request).execute())
        {
            //如果返回包的状态不是200，就抛出异常
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            //获取返回包头部信息，并打印返回包头部信息
            Headers responseHeaders = response.headers();
            for (int i = 0; i < responseHeaders.size(); i++) {
                System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
            }
            //打印返回包包体内容。
            System.out.println(response.body().string());
        }
    }
}
