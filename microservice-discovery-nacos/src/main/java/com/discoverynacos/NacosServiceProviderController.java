package com.nacos;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 */
@RestController
public class NacosServiceProviderController {

    @RequestMapping(value= "/findName/{string}",method = RequestMethod.GET)
    public String findName(@PathVariable String string){
        return "Nacos Service Provider:欢迎 "+string+" 访问";
    }
}
