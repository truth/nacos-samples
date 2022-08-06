## nacos-samples

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

## OpenFeign+ Sentinel  fallback测试

测试只通过application.properties启用

```properties
feign.sentinel.enabled=true
```

ProviderClient类中有相对应的操作说明， 如果关闭provider， 将会调用Fallback。
```java
@FeignClient(name = "demo-provider", path = "/provider",fallback = EchoServiceFallback.class, configuration = FeignConfiguration.class)
public interface ProviderClient {

    @GetMapping("/echo/{str}")
    String hello(@PathVariable(value="str")  String str);
}
class FeignConfiguration {
    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }
}

class EchoServiceFallback implements ProviderClient {
    /*
     * 当Provider 关闭以后， FeignCLient 请求会失败， 这样sentinel 就会起作用
     *  执行fallback ， 就是下面的代码
     */
    public String hello(@PathVariable("str") String str) {
        return "echo fallback";
    }
}
```

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



**参考文章:**
*如下 (收录整理时间2022年8月5~6日),文档有时效，注意查看对应时间和版本信息*

[1]   [nacos整合openfeign](https://www.jianshu.com/p/5f01ade994da)  
[2]   [Spring Cloud Hoxton.SR12 现已发布](https://www.xujun.org/note-136263.html)  
[3]   [spring-cloud-alibaba-dependencies版本问题](https://blog.51cto.com/u_15076224/3865887)  
[4]   [Spring Cloud Alibaba Reference Documentation](https://spring-cloud-alibaba-group.github.io/github-pages/hoxton/en-us/index.html)  
[5]   [SpringCloud——OpenFeign详解](https://blog.csdn.net/weixin_50616848/article/details/124540101)  
[6]   [Spring Cloud Gateway 服务网关的部署与使用详细介绍](https://blog.csdn.net/a745233700/article/details/122917167)  
[7]   [Spring Cloud Gateway+Oauth2 实现统一认证和鉴权](https://blog.csdn.net/const_/article/details/123742701)  
[8]   [SpringCloud+Gateway+Security 搭建微服务统一认证授权（附源码）](https://zhuanlan.zhihu.com/p/521038718)  
[9]   [Spring cloud gateway 详解和配置使用](https://zhuanlan.zhihu.com/p/354236947)  
[10] [Sentinel 简介](https://zhuanlan.zhihu.com/p/364009727)  

