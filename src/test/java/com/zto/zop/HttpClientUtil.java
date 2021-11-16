package com.zto.zop;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HttpClientUtil {

    private static OkHttpClient client = new OkHttpClient.Builder().connectTimeout(3, TimeUnit.SECONDS).build();

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    public static Response post(String url, Map<String, Object> params) throws IOException {
        FormBody.Builder builder = new FormBody.Builder();
        params.entrySet().forEach(entry -> {
            if (entry.getValue() == null) {
                entry.setValue("");
            }
            builder.add(entry.getKey(), String.valueOf(entry.getValue()));
        });
        Request request = new Request.Builder().url(url)
                .post(builder.build()).build();
        return client.newCall(request).execute();
    }

    public static final MediaType XML_MEDIA
            = MediaType.parse("text/xml;charset=UTF-8");

   public static String postBody(String url, String json) throws IOException {

        RequestBody body = RequestBody.create(XML_MEDIA, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
