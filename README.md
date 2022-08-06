### nacos-samples

本实例使用相关技术版本列表

>  Nacos 2.0.2
>
> ```xml
> <spring.boot.version>2.3.5.RELEASE</spring.boot.version>
> <!-- Spring Cloud -->
> <spring.cloud.version>Hoxton.SR12</spring.cloud.version>
> <spring.cloud.alibaba.version>2.2.7.RELEASE</spring.cloud.alibaba.version>
> ```

Spring Cloud Alibaba 参考文档(**hoxton版**)

https://spring-cloud-alibaba-group.github.io/github-pages/hoxton/en-us/index.html

## provider-consumer-gateway 流程说明

provider : http://localhost:8082/provider/echo/{string}

consumer: http://localhost:8081/consumer/{string}  使用openfeign 访问provider

gateway: 
http://localhost:9000/consumer/**  路由到consumer上。 

http://localhost:9000/provider/**  路由到provider上。 

```text
gateway -->consumer-->provider
        -->provider 
```



参考文章如下 (收录整理时间2022年8月5日),文档有时效，注意查看对应时间和版本信息

[1] [nacos整合openfeign](https://www.jianshu.com/p/5f01ade994da)  
[2] [Spring Cloud Hoxton.SR12 现已发布](https://www.xujun.org/note-136263.html)  
[3] [spring-cloud-alibaba-dependencies版本问题](https://blog.51cto.com/u_15076224/3865887)  
[4] [Spring Cloud Alibaba Reference Documentation](https://spring-cloud-alibaba-group.github.io/github-pages/hoxton/en-us/index.html)  
[5] [SpringCloud——OpenFeign详解](https://blog.csdn.net/weixin_50616848/article/details/124540101)  