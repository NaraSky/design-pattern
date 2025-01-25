package com.lb.a08;

import java.util.ArrayList;
import java.util.List;

// 过滤器使用Demo
public class Application {
    private List<Filter> filters = new ArrayList<>();

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void handleRpcRequest(RpcRequest req) {
        try {
            for (Filter filter : filters) {
                filter.doFilter(req);
            }
            System.out.println("Request processed: " + req.getData());
        } catch (RpcException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Application app = new Application();

        // 添加过滤器
        app.addFilter(new AuthencationFilter());
        app.addFilter(new RateLimitFilter());

        // 模拟一个请求
        RpcRequest req = new RpcRequest("Some RPC request data");

        // 处理请求
        app.handleRpcRequest(req);
    }
}
