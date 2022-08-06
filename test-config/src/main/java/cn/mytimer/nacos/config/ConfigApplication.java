package cn.mytimer.nacos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
@RestController
public class ConfigApplication {
    @Value("${member.nickname}")
    private  String nickname;

    @Value("${member.age}")
    private  Integer age;
    @RequestMapping("/test-local-config")
    public Object testLocalConfig() {
        return "姓名:" + nickname + ",年龄:"+age;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
}
