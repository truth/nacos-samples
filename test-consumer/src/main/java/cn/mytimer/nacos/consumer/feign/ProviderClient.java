package cn.mytimer.nacos.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
