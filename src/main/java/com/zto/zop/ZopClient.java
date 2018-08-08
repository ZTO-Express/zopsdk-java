package com.zto.zop;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class ZopClient {
    private final ZopProperties properties;

    public ZopClient(ZopProperties properties) {
        this.properties = properties;
    }

    public ZopClient(String companyId, String key) {
        this.properties = new ZopProperties(companyId, key);
    }


    public String execute(ZopPublicRequest request) throws IOException {
        Map<String, String> params = request.getParams();
        StringBuilder queryBuilder = new StringBuilder();
        StringBuilder strToDigestBuilder = new StringBuilder();
        for (Map.Entry<String, String> e : params.entrySet()) {
            strToDigestBuilder.append(e.getKey()).append("=").append(e.getValue()).append("&");
            queryBuilder.append(urlEncode(e.getKey())).append("=").append(urlEncode(e.getValue())).append("&");
        }

        String queryString = queryBuilder.substring(0, queryBuilder.length() - 1);
        String strToDigest = strToDigestBuilder.substring(0, strToDigestBuilder.length() - 1);
        strToDigest = strToDigest + properties.getKey();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("x-companyid", properties.getCompanyId());
        headers.put("x-datadigest", ZopDigestUtil.digest(strToDigest));
        return HttpUtil.post(request.getUrl(), headers, queryString);
    }


    private String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return str;
        }
    }

}
