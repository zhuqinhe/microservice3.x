package com.discoverynacos.exception;

import com.alibaba.cloud.sentinel.rest.SentinelClientHttpResponse;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import feign.Feign;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;

public class ExceptionUtils {

	/**
	 * 静态方法
	 * 返回值: SentinelClientHttpResponse
	 * 参数 : request , byte[] , clientRquestExcetion , blockException
	 */
	//限流熔断业务逻辑
	public static SentinelClientHttpResponse handleBlock(HttpRequest request, byte[] body, ClientHttpRequestExecution execution, BlockException ex) {

		return new SentinelClientHttpResponse(JSON.toJSONString("触发限流"));
	}

	//异常降级业务逻辑
	public static SentinelClientHttpResponse handleFallback(HttpRequest request, byte[] body,
		ClientHttpRequestExecution execution, BlockException ex) {
		return new SentinelClientHttpResponse("异常执行降级服务");
	}

	public static void handleException(BlockException ex) {
		System.out.println("Oops: " + ex.getClass().getCanonicalName());
	}
}
