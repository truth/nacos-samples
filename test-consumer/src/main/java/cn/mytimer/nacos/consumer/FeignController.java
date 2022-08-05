package cn.mytimer.nacos.consumer;

import cn.mytimer.nacos.consumer.feign.ProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignController {
    @Autowired
    private ProviderClient providerClient;

    /**
     *  openfeign示例
     * @param string 请求入参
     * @return 返回参数
     */
    @RequestMapping(value = "/consumer/{string}",method = RequestMethod.GET)
    public String consumer(@PathVariable String string){
        return providerClient.hello(string)+",consumer!";
    }

}