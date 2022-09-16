package com.zto.zop;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class ZopDigestUtil {

    private static final String HMAC_SHA_256 = "HmacSHA256";

    private static final Map<String, Mac> MAC_MAP = new ConcurrentHashMap<>();

    public static String digest(String str, Boolean isBase64, EncryptionType encryptionType, Long timestamp, String secretKey) {
        if (timestamp != null) {
            str = timestamp + str;
        }
        boolean base64 = isBase64 == null || isBase64;
        switch (encryptionType) {
            case SHA256:
                return base64 ? Base64.encodeBase64String(DigestUtils.sha256(str)) : DigestUtils.sha256Hex(str);
            case HmacSHA256:
                return base64 ? Base64.encodeBase64String(hmacSha256(secretKey, str)) : hmacSha256Str(secretKey, str);
            default:
                return base64 ? Base64.encodeBase64String(DigestUtils.md5(str)) : DigestUtils.md5Hex(str);
        }
    }

    public static String hmacSha256Str(String key, String body) {
        return Hex.encodeHexString(hmacSha256(key, body));
    }

    public static byte[] hmacSha256(String key, String body) {
        if (Objects.isNull(key)) {
            key = "";
        }
        Mac mac = MAC_MAP.get(key);
        if (mac == null) {
            try {
                mac = Mac.getInstance(HMAC_SHA_256);
                SecretKey secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), HMAC_SHA_256);
                mac.init(secretKey);
                MAC_MAP.put(key, mac);
            } catch (NoSuchAlgorithmException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        }
        return mac.doFinal(body.getBytes(StandardCharsets.UTF_8));
    }

}
