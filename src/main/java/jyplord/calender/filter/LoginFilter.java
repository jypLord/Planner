package jyplord.calender.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static config.FilterConfig.isWhiteList;

@Slf4j
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        log.info("request URI = {}=", requestURI);

        if (isWhiteList(requestURI)) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = httpRequest.getSession(false);

        if (session == null || session.getAttribute("loginUser") == null) {
            log.info("세선 없음: {}", requestURI);
            httpResponse.sendRedirect("/login");
            return;
        }
        chain.doFilter(request, response);
    }

}
