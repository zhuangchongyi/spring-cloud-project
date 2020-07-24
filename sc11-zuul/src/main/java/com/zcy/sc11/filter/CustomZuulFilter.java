package com.zcy.sc11.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.zcy.sc1.utils.JsonResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author zhuangchongyi
 * @Description 定义过滤器，继承 ZuulFilter
 * @Date 2020/7/24 12:52
 */
@Component
public class CustomZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //该过滤器顺序要 > 5，才能得到 serviceId
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 1;
    }

    @Override
    public boolean shouldFilter() {
        //对指定的serviceid过滤，如果要过滤所有服务，直接返回 true
        RequestContext ctx = RequestContext.getCurrentContext();
        String serviceId = (String) ctx.get(FilterConstants.SERVICE_ID_KEY);
        if ("item-service".equals(serviceId)) {
            return true;
        }
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            ctx.setSendZuulResponse(false); //此设置会阻止请求被路由发到后台微服务
            ctx.setResponseStatusCode(200);
            ctx.setResponseBody(JsonResult.err().code(JsonResult.NOT_LOGIN).toString());
        }
        return null;
    }
}
