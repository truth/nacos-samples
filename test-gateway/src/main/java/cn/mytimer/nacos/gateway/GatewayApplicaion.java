package cn.mytimer.nacos.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplicaion {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplicaion.class);
    }
}
