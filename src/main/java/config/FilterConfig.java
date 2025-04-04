package config;

import jyplord.calender.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.PatternMatchUtils;

@Configuration
public class FilterConfig{
    @Bean
    public FilterRegistrationBean<LoginFilter> loginFilter() {
        FilterRegistrationBean<LoginFilter> filter = new FilterRegistrationBean<>();

        filter.setFilter(new LoginFilter());
        filter.addUrlPatterns("/*");
        filter.setOrder(1);

        return filter;
    }
    private static final String[] WHITE_LIST = {"/", "/user/signup", "/login", "/logout"};

    public static boolean isWhiteList(String requestURI){
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI) ;
    }
}