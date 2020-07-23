package com.zcy.sc6;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class RibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }

    /**
     * 创建 RestTemplate 实例，并存入 spring 容器
     * @LoadBalanced 负载均衡注解，会对 RestTemplate 实例进行封装，创建动态代理对象，并切入（AOP）负载均衡代码，把请求分散分发到集群中的服务器
     */
    @LoadBalanced //负载均衡注解
    @Bean
    public RestTemplate getRestTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(1000);// 连接超时时间
        factory.setReadTimeout(1000);// 读取超时时间
        return new RestTemplate(factory);

        //RestTemplate 中默认的 Factory 实例中，两个超时属性默认是 -1，
        //未启用超时，也不会触发重试
        //return new RestTemplate();
    }
}
