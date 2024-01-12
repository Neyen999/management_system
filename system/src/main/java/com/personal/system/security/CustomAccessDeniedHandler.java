package com.personal.system.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.system.exceptions.CustomException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.server.authorization.ServerAccessDeniedHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // Set the response status to 403
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        // Set the content type to JSON
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        // Write the exception message to the response body
        ObjectMapper objectMapper = new ObjectMapper();
        // Create a custom exception object
        CustomException customException = new CustomException(HttpStatus.FORBIDDEN);
        customException.setErrorCode(403);
        // Convert the custom exception object to a JSON string
        String json = objectMapper.writeValueAsString(customException);
        response.getWriter().write(json);

    }
}
