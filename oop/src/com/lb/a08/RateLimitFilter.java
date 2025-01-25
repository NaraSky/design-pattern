package com.lb.a08;

// 接口实现：RateLimitFilter
public class RateLimitFilter implements Filter {
    @Override
    public void doFilter(RpcRequest req) throws RpcException {
        // 限流逻辑
        System.out.println("Rate limit filter applied.");
    }
}
