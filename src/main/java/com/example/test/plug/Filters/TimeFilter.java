package com.example.test.plug.Filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class TimeFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        int random = 1000 + ThreadLocalRandom.current().nextInt(0, 1001);
        try {
            Thread.sleep(random);
        } catch (InterruptedException e) {
            throw new ServletException("Interrupted", e);
        }
        filterChain.doFilter(request, response);
    }
}
