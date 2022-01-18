package com.zto.zop;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class ZopDigestUtil {

    public static String digest(String str, Boolean isBase64, EncryptionType encryptionType, Long timestamp) {
        if (timestamp != null) {
            str = timestamp + str;
        }
        boolean base64 = isBase64 == null || isBase64;
        return base64 ? EncryptionType.SHA256.equals(encryptionType) ? Base64.encodeBase64String(DigestUtils.sha256(str)) : Base64.encodeBase64String(DigestUtils.md5(str))
                : EncryptionType.SHA256.equals(encryptionType) ? DigestUtils.sha256Hex(str) : DigestUtils.md5Hex(str);
    }
}
