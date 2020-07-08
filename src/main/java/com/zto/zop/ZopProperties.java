package com.zto.zop;

public class ZopProperties {
    private String companyId;
    private String key;

    public ZopProperties() {
    }

    public ZopProperties(String appKey, String appSecret) {
        this.companyId = appKey;
        this.key = appSecret;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
