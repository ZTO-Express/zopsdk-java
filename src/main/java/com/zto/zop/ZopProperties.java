package com.zto.zop;

import lombok.Data;

@Data
public class ZopProperties {
    private String companyId;
    private String key;

    public ZopProperties(String companyId, String key) {
        this.companyId = companyId;
        this.key = key;
    }
}
