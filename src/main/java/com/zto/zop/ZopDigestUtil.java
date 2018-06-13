package com.zto.zop;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class ZopDigestUtil {
    public static String digest(String str) {
        return Base64.encodeBase64String(DigestUtils.md5(str));
    }
}
