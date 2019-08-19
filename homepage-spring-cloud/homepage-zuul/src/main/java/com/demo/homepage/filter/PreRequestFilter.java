package com.demo.homepage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * <h1>在过滤器中存储客户端发起请求的时间戳</h1>
 */
@Component
public class PreRequestFilter extends ZuulFilter {

    /**
     * <h2>指定过滤器类型</h2>
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * <h2>过滤器优先级，值越小，与进程类似</h2>
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * <h2>是否启用当前过滤器</h2>
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        // 用于在过滤器之间传递消息
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.set("startTime", System.currentTimeMillis());

        return null;
    }
}
