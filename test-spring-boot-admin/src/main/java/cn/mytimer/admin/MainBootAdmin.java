package cn.mytimer.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @PROJECT_NAME: spring-boot-admin-nacos
 * @DESCRIPTION:
 * @author: wzl
 * @DATE: 2022/10/58 10:59 上午
 */
@EnableAdminServer
@EnableDiscoveryClient
@SpringBootApplication
public class MainBootAdmin {

    public static void main(String[] args) {
        SpringApplication.run(MainBootAdmin.class,args);
    }

}