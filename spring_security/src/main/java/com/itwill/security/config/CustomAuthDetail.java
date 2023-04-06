package com.itwill.security.config;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthDetail implements AuthenticationDetailsSource<HttpServletRequest, RequestInfo> {

    @Override
    public RequestInfo buildDetails(HttpServletRequest request) {
        return RequestInfo.builder()
                .loginTime(LocalDateTime.now())
                .remoteIp(request.getRemoteAddr())
                .sessionId(request.getSession().getId())
                .build();
    }

}
