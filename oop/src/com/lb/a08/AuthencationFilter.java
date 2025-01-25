package com.lb.a08;

// 接口实现：AuthencationFilter
public class AuthencationFilter implements Filter {
    @Override
    public void doFilter(RpcRequest req) throws RpcException {
        // 鉴权逻辑
        System.out.println("Authentication filter applied.");
    }
}
