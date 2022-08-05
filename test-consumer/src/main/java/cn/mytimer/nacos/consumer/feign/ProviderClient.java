package cn.mytimer.nacos.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "demo-provider", path = "/provider")
public interface ProviderClient {

    @GetMapping("/echo/{str}")
    String hello(@PathVariable(value="str")  String str);
}
