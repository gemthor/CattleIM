package com.example.factory.net;


import com.example.common.Common;
import com.example.factory.net.Interceptor.ReceiveInterceptor;
import com.example.factory.net.Interceptor.SendInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 1.为了防止对于retrofit 对象的重复书写，对其进行抽象表现为单例模式
 * 2.处理 csrf， 设置前后的拦截器
 */
public class Network {

    private static Network instance;
    private Retrofit retrofit;
    private OkHttpClient client;
    static {
        instance = new Network();
    }

    private Network() {
    }

    public static OkHttpClient getClient() {



        if (instance.client != null) {
            return instance.client;
        }


        instance.client = new OkHttpClient.Builder()
                .addInterceptor(new SendInterceptor()) //这部分
                .addInterceptor(new ReceiveInterceptor()) //这部分
                .build();
        return instance.client;

    }

    public static Retrofit getRetrofit() {

        if (instance.retrofit != null){
            return instance.retrofit;
        }
        instance.retrofit = new Retrofit.Builder()
                //设置数据解析器
                .addConverterFactory(GsonConverterFactory.create())
                //设置网络请求的Url地址
                .baseUrl(Common.Constance.BASE_URL)
                .client(Network.getClient())
                .build();

        return instance.retrofit;
    }

    /**
     * 与服务器建立连接的通道
     *
     * @return 返回一个带着与服务器交互的所有的基础接口
     */
    public static NetInterface getConnect() {

        return Network.getRetrofit().create(NetInterface.class);
    }

}