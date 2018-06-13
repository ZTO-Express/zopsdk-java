package com.zto.zop;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ZopPublicRequest {
    private String url;
    private Map<String, String> params = new HashMap<String, String>();

    public ZopPublicRequest() {
    }

    public void addParam(String k, String v) {
        params.put(k, v);
    }

    public void addParam(Map<String, String> p) {
        for (Map.Entry<String, String> entry : p.entrySet()) {
            params.put(entry.getKey(), entry.getValue());
        }
    }
}
