package com.example.mastercrud.config;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
//        HttpServletRequest req = (HttpServletRequest) request;
//
//        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Origin", "*");
//        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, PATCH, POST");
//        ((HttpServletResponse) response).addHeader("Access-Control-Allow-Headers","*");
//
//        try {
//            chain.doFilter(request, response);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ServletException e) {
//            throw new RuntimeException(e);
//        }
    }
}
