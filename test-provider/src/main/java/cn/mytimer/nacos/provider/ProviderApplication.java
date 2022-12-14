package  cn.mytimer.nacos.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
/**
 * 这个注解非常重要 cn.mytimer.nacos.consumer
 * https://www.jianshu.com/p/5f01ade994da
 */
@EnableDiscoveryClient
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }

    @RestController
    public class EchoController {
        @GetMapping(value = "/provider/echo/{string}")
        public String echo(@PathVariable String string) {
            return "Hello Nacos Discovery " + string;
        }
        @GetMapping(value = "/")
        public String index(@PathVariable String string) {
            return "index";
        }
    }
}