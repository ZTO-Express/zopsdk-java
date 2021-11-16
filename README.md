# 中通开放平台SDK（JAVA版）

## 环境
jdk1.6

## 使用方式
请自行下载源码install到本地或内部私服


```java
// ZopClient类的构造方法接收两个参数，分别是companyid和key，都需要注册中通开放平台后到个人中心查看
ZopClient client = new ZopClient("kfpttestCode", "kfpttestkey==");
ZopPublicRequest request = new ZopPublicRequest();
// 请使用request.addParam方法将"业务参数"添加进来，每个接口的"业务参数"请参考文档描述
request.setData("{\n" +
                "\t\"company_id\": \"kfpttestCode\",\n" +
                "\t\"msg_type\": \"GETMARK\",\n" +
                "\t\"data\": {\n" +
                "\t\t\"unionCode\": \"536178917071\",\n" +
                "\t\t\"send_province\": \"上海市\",\n" +
                "\t\t\"send_city\": \"上海市\",\n" +
                "\t\t\"send_district\": \"青浦区\",\n" +
                "\t\t\"send_address\": \"华新镇华志路123号\",\n" +
                "\t\t\"receive_province\": \"四川省\",\n" +
                "\t\t\"receive_city\": \"成都市\",\n" +
                "\t\t\"receive_district\": \"武侯区\",\n" +
                "\t\t\"receive_address\": \"610号和兴润园二期1栋2单元1003室\"\n" +
                "\t}\n" +
                "}");
request.setUrl("http://58.40.16.120:9001/submitOrderCode");
System.out.println(client.execute(request));
```

## 其他
1. 该项目刚创建，功能还很不完善，如有问题请提issue
2. 由于中通开放平台各个接口返回值格式没有统一，所以未封装返回值，未来可能会做封装
