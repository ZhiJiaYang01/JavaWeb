package com.powernode.filter;

import com.powernode.utils.CurrentHolder;
import com.powernode.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        //1.获取请求的URI
        String requestURI = httpRequest.getRequestURI();

        //2.判断是否登录请求，如果路径是登录请求 /login，则放行
        if ("/login".equals(requestURI)) {
            log.info("登录请求，放行");
            chain.doFilter(request, response);
            return;
        }

        //3.获取请求头中的token
        String token = httpRequest.getHeader("token");

        //4.判断token是否存在，如果不存在，说明用户没有登录，返回错误信息（响应401状态码）
        if (token == null || token.isEmpty()) {
            log.info("令牌为空，响应401");
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        //5.如果token存在，校验令牌，如果校验失败->返回错误信息（响应401状态码）
        try {
            Claims claims = JwtUtils.parseToken(token);
            Integer empId = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(empId);
            log.info("当前用户ID:{}", empId);
        } catch (Exception e) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        //6.校验令牌成功->放行
        chain.doFilter(request, response);

        //删除ThreadLocal中的数据
        CurrentHolder.removeCurrentId();
    }
}
