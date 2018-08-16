# 中通开放平台SDK（JAVA版）

## 环境
jdk1.6

## 使用方式

在pom.xml里添加如下依赖
```xml
<repositories>
    <repository>
        <id>zto-maven</id>
        <url>https://dl.bintray.com/chocotan/maven</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.zto.zop</groupId>
    <artifactId>zopsdk</artifactId>
    <version>0.4</version>
</dependency>
```


```java
// ZopClient类的构造方法接收两个参数，分别是companyid和key，都需要注册中通开放平台后到个人中心查看
ZopClient client = new ZopClient("kfpttestCode", "kfpttestkey==");
ZopPublicRequest request = new ZopPublicRequest();
// 请使用request.addParam方法将"业务参数"添加进来，每个接口的"业务参数"请参考文档描述
request.addParam("data", "{\"content\":{\"branchId\":\"\",\"buyer\":\"\",\"collectMoneytype\":\"CNY\",\"collectSum\":\"12.00\",\"freight\":\"10.00\",\"id\":\"xfs2018031500002222333\",\"orderSum\":\"0.00\",\"orderType\":\"1\",\"otherCharges\":\"0.00\",\"packCharges\":\"1.00\",\"premium\":\"0.50\",\"price\":\"126.50\",\"quantity\":\"2\",\"receiver\":{\"address\":\"育德路XXX号\",\"area\":\"501022\",\"city\":\"四川省,XXX,XXXX\",\"company\":\"XXXX有限公司\",\"email\":\"yyj@abc.com\",\"id\":\"130520142097\",\"im\":\"yangyijia-abc\",\"mobile\":\"136*****321\",\"name\":\"XXX\",\"phone\":\"010-222***89\",\"zipCode\":\"610012\"},\"remark\":\"请勿摔货\",\"seller\":\"\",\"sender\":{\"address\":\"华新镇华志路XXX号\",\"area\":\"310118\",\"city\":\"上海,上海市,青浦区\",\"company\":\"XXXXX有限公司\",\"email\":\"ll@abc.com\",\"endTime\":1369033200000,\"id\":\"131*****010\",\"im\":\"1924656234\",\"mobile\":\"1391***5678\",\"name\":\"XXX\",\"phone\":\"021-87***321\",\"startTime\":1369022400000,\"zipCode\":\"610012\"},\"size\":\"12,23,11\",\"tradeId\":\"2701843\",\"type\":\"1\",\"typeId\":\"\",\"weight\":\"0.753\"},\"datetime\":\"2018-06-13 13:26:00\",\"partner\":\"test\",\"verify\":\"ZTO123\"}");
request.setUrl("http://58.40.16.120:9001/submitOrderCode");
System.out.println(client.execute(request));
```

## 其他
1. 该项目刚创建，功能还很不完善，如有问题请提issue
2. 由于中通开放平台各个接口返回值格式没有统一，所以未封装返回值，未来可能会做封装
