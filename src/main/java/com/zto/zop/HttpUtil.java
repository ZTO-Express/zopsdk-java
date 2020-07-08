package com.zto.zop;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

public class HttpUtil {
    private static final int DEFAULT_TIMEOUT = 3000;


    public static String post(String interfaceUrl, Map<String, String> headers, String queryString) throws IOException {
        URL url = new URL(interfaceUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        con.setDoOutput(true);
        con.setConnectTimeout(DEFAULT_TIMEOUT);
        con.setReadTimeout(DEFAULT_TIMEOUT);
        for (Map.Entry<String, String> e : headers.entrySet()) {
            con.setRequestProperty(e.getKey(), e.getValue());
        }
        DataOutputStream out = null;

        BufferedReader in = null;
        try {
            out = new DataOutputStream(con.getOutputStream());
            out.write(queryString.getBytes(Charset.forName("UTF-8")));
            out.flush();
            in = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "UTF-8"));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception ignored) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ignored) {
                }
            }
        }

    }


    public static String postJson(String interfaceUrl, Map<String, String> headers, String json) throws IOException {
        URL url = new URL(interfaceUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        con.setDoOutput(true);
        con.setConnectTimeout(DEFAULT_TIMEOUT);
        con.setReadTimeout(DEFAULT_TIMEOUT);
        for (Map.Entry<String, String> e : headers.entrySet()) {
            con.setRequestProperty(e.getKey(), e.getValue());
        }
        DataOutputStream out = null;

        BufferedReader in = null;
        try {
            out = new DataOutputStream(con.getOutputStream());
            out.write(json.getBytes(Charset.forName("UTF-8")));
            out.flush();
            in = new BufferedReader(
                    new InputStreamReader(con.getInputStream(), "UTF-8"));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception ignored) {
                }
            }
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ignored) {
                }
            }
        }

    }

}
