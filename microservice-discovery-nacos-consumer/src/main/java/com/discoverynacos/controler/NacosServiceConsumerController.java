package com.discoverynacos.controler;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.nacos.common.utils.ExceptionUtil;
import com.discoverynacos.service.EchoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 */
@RestController
public class NacosServiceConsumerController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private EchoService echoService;

    @GetMapping(value = "/test-rest/{str}")
    public String rest(@PathVariable String str) {
        return restTemplate.getForObject("http://discovery-nacos-provider/test/" + str, String.class);
    }
    @GetMapping(value = "/test-feign/{str}")
    public String feign(@PathVariable String str) {
        return echoService.echo(str);
    }


    /**
     * @SentinelResource
     *      blockHandler : 声明熔断时调用的降级方法
     *      fallback : 抛出异常执行的降级方法
     *      value : 自定义的资源名称
     *      不设置:当前全类名.方法名
     */
    @SentinelResource(value="test",blockHandler = "blockHandler",fallback = "fallback")
    @RequestMapping(value = "/test_custom_rule/{str}",method = RequestMethod.GET)
    public String test_custom_rule(@PathVariable String str) {
        if(StringUtils.isEmpty(str)){
            throw new RuntimeException("抛出异常时，执行的降级方法");
        }
        return restTemplate.getForObject("http://discovery-nacos-provider/test/"+str,String.class);
    }
    /**
     * 自定义限流降级方法
     * Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致
	 */
	public String blockHandler(String  str,BlockException be) {

		return "当前流量过大,blockHandler，系统拒绝服务";
	}

	/**
     * 接口后台异常，触发熔断降级
     * Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数
     * */
	public  String fallback(String str,Throwable t) {

		return "服务异常,fallback，启动降级服务";
	}

    // blockHandler 是位于 ExceptionUtil 类下的 handleException 静态方法，需符合对应的类型限制.
    @SentinelResource(value = "test_exception", blockHandler = "handleException", blockHandlerClass = {ExceptionUtil.class})
    public void test() {
        System.out.println("Test");
    }
}
