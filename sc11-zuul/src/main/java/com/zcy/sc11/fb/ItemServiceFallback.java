package com.zcy.sc11.fb;

import com.zcy.sc11.http.CustomClientHttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ItemServiceFallback implements FallbackProvider {
    @Override
    public String getRoute() {
        //指定应用此降级类的服务id，星号或null值可以通配所有服务
        return "item-service"; //"*"; //null;
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new CustomClientHttpResponse();
    }

}
