package com.example.okhttpdemo;

import okhttp3.*;

import java.io.IOException;

public class AsynchronousGet
{
    //声明OkHttpClient客户端
    private final OkHttpClient client = new OkHttpClient();

    public void run() throws Exception
    {
        //构造GET请求包
        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();
        //异步方式发送请求包
        client.newCall(request).enqueue(new Callback()
        {
            //返回包获取失败
            @Override public void onFailure(Call call, IOException e)
            {
                e.printStackTrace();
            }
            //返回包获取成功
            @Override public void onResponse(Call call, Response response) throws IOException
            {
                try (ResponseBody responseBody = response.body())
                {
                    //判断返回包状态是否是200，如果不是200，就抛出异常
                    if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

                    //获取返回包包头信息，并挨个打印出来
                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++)
                    {
                        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
                    }
                    //打印返回包包体信息
                    System.out.println(responseBody.string());
                }
            }
        });
    }
}
