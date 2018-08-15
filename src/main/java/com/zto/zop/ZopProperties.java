package com.zto.zop;

public class ZopProperties {
    private String companyId;
    private String key;

    public ZopProperties(String companyId, String key) {
        this.companyId = companyId;
        this.key = key;
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
