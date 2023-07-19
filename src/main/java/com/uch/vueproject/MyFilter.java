package com.uch.vueproject;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uch.vueproject.model.BaseResponse;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/*", filterName = "myFilter")
public class MyFilter extends OncePerRequestFilter {
    // 白名單
    Set<String> ALLOW_LIST = new HashSet<>(Arrays.asList("/login", "/logout"));

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        System.out.println(request.getServletPath());

        // 不過濾白名單內的網址
        if(ALLOW_LIST.contains(request.getServletPath()) || 
           request.getServletPath().contains(".")) {
            filterChain.doFilter(request, response);
            return;
        }

        HttpSession httpSession = request.getSession();

        // 未登入
        if(httpSession.getAttribute("loginStatus") == null) {
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding("utf-8");
            response.getWriter().println(objectMapper.writeValueAsString(new BaseResponse(9, "未登入")));
        } else {
            filterChain.doFilter(request, response);
        }
    }
    
}
