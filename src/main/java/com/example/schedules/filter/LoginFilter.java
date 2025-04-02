package com.example.schedules.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

public class LoginFilter implements Filter {

    private static final String[] WHITE_LIST = {"/", "/users/signUp", "/login", "/logout"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (isNotWhiteList(requestURI)) {

            HttpSession session = httpRequest.getSession(false);

            if (session == null || session.getAttribute("sessionkey") == null) {
                throw new RuntimeException("로그인을 해주세요");
            }
        }

        chain.doFilter(request, response);
    }

    private boolean isNotWhiteList(String requestURI) {
        return !PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}
