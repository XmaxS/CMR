package com.sakura.core.util.web;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * okhttp3工具类
 */
public class HttpUtil {

    public void sendRequsetWithOkHttp(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }


}
