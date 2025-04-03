package com.example.schedules.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

public class LoginFilter implements Filter {

    private static final String[] WHITE_LIST = {"/", "/users/signUp", "/users/login", "/users/logout"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        if (isNotWhiteList(requestURI)) {

            HttpSession session = httpRequest.getSession(false);

            //로그인이 안되어있을시 예외 처리
            if (session == null || session.getAttribute("userId") == null) {

                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.setStatus(401);
                httpResponse.setContentType("application/json");
                httpResponse.setCharacterEncoding("UTF-8");

                String message = "로그인이 필요합니다.";
                httpResponse.getWriter().write(message);
                return;
            }
        }

        chain.doFilter(request, response);
    }

    private boolean isNotWhiteList(String requestURI) {
        return !PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }

}
