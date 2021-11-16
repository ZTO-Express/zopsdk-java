package com.zto.zop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ZopPublicRequest {
    private String url;
    private Map<String, String> params = new HashMap<String, String>();


    // 如果body有值，表示使用application/json的方式传值
    private String body;

    public ZopPublicRequest() {
    }

    public void setBody(String body){
        this.body = body;
    }


    public String getBody() {
        return body;
    }

    public void addParam(String k, String v) {
        params.put(k, v);
    }

    public void setData(String data) {
        try {
            JSONObject jsonObject = JSON.parseObject(data);
            for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
                params.put(entry.getKey(), entry.getValue().toString());
            }
        } catch (Exception e) {
            throw new RuntimeException("JSON格式不对,请检查数据", e);
        }
    }

    public void setDataObj(Map<String, String> data) {
        params.putAll(data);
    }

    public void addParam(Map<String, String> p) {
        for (Map.Entry<String, String> entry : p.entrySet()) {
            params.put(entry.getKey(), entry.getValue());
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(Map<String, String> params) {
        this.params = params;
    }
}
