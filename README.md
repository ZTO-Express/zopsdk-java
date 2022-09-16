# 中通开放平台SDK（JAVA版）

## 环境

jdk1.6及以上

## 使用方式
请自行下载源码install到本地或内部私服

```java
// ZopClient类的构造方法接收两个参数，分别是appKey和appSecret，都需要注册中通开放平台后到个人中心查看
ZopClient client=new ZopClient("kfpttestCode","kfpttestkey==");
        ZopPublicRequest request=new ZopPublicRequest();
        //Content-Type为application/x-www-form-urlencoded的请使用request.addParam方法将"业务参数"添加进来，每个接口的"业务参数"请参考文档描述
        //Content-Type为application/json的请使用request.setBody将请求json添加进来
        request.setBody("{\n"+
        "\t\"company_id\": \"kfpttestCode\",\n"+
        "\t\"msg_type\": \"GETMARK\",\n"+
        "\t\"data\": {\n"+
        "\t\t\"unionCode\": \"536178917071\",\n"+
        "\t\t\"send_province\": \"上海市\",\n"+
        "\t\t\"send_city\": \"上海市\",\n"+
        "\t\t\"send_district\": \"青浦区\",\n"+
        "\t\t\"send_address\": \"华新镇华志路123号\",\n"+
        "\t\t\"receive_province\": \"四川省\",\n"+
        "\t\t\"receive_city\": \"成都市\",\n"+
        "\t\t\"receive_district\": \"武侯区\",\n"+
        "\t\t\"receive_address\": \"610号和兴润园二期1栋2单元1003室\"\n"+
        "\t}\n"+
        "}");
        request.setUrl("https://japi-test.zto.com/submitOrderCode");
        //指定是否需要base64，不指定默认为true
        request.setBase64(true);
        //指定加密方式，MD5或者SHA256，如果不指定默认为MD5
        request.setEncryptionType(EncryptionType.SHA256);
        //非appSecret,当加密方式为EncryptionType.HmacSHA256时，需要配置额外的HmacSHA256加密key，此key要和中通开放平台上的加密key一致
        request.setSecretKey("secrest_key");
        //请求头中指定时间戳，如果接口文档上标注需使用时间戳则使用，其他不要设定值，否则会导致签名错误
        request.setTimestamp(System.currentTimeMillis());
        System.out.println(client.execute(request));
```
