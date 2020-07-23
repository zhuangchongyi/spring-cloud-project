package com.zcy.sc7;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 启动断路器，断路器提供两个核心功能：
 * 降级，超时、出错、不可到达时，对服务降级，返回错误信息或者是缓存数据
 * 熔断，当服务压力过大，错误比例过多时，熔断所有请求，所有请求直接降级
 */
//@EnableCircuitBreaker //启用 hystrix 断路器
//@EnableDiscoveryClient //启用 eureka客户端
//@SpringBootApplication
@SpringCloudApplication //@SpringCloudApplication 注解代替三个注解
public class HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }

    @LoadBalanced //负载均衡注解
    @Bean
    public RestTemplate getRestTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(1000);// 连接超时时间
        factory.setReadTimeout(1000);// 读取超时时间
        return new RestTemplate(factory);
    }
}
